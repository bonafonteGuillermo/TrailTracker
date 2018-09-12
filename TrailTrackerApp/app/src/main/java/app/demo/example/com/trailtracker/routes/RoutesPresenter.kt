package app.demo.example.com.trailtracker.routes

import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for Routes screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class RoutesPresenter(private var view: IRoutesView, override var repository: IRepository, private var schedulers: Schedulers) : IRoutesPresenter {
    private lateinit var subscription: Disposable

    override fun onCreate() {
        subscription = getRoutes()

    }

    override fun onDestroy() {
        subscription.dispose()
    }

    override fun requestRouteMap(route: Route) {
        view.navigateToRouteDetailMap(route)
    }

    private fun getRoutes(): Disposable {
        return repository.getRoutesSavedInLocalStorage()
                .subscribeOn(schedulers.internet())
                .observeOn(schedulers.androidThread())
                .subscribe(
                        { routes ->
                            view.bindRecyclerData(routes)

                        },
                        {

                        }
                )
    }
}
