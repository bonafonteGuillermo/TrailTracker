package app.demo.example.com.trailtracker.routename

import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for RouteName screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class RouteNamePresenter(private var view: IRouteNameView, override var repository: IRepository, private var schedulers: Schedulers) : IRouteNamePresenter {

    override fun onCreate() {
    }

    override fun onDestroy() {
    }
}
