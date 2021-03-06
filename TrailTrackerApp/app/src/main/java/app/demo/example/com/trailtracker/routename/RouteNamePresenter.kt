package app.demo.example.com.trailtracker.routename

import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers
import app.demo.example.com.trailtracker.utils.isValidRouteName
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 * Presenter for RouteName screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class RouteNamePresenter(private var view: IRouteNameView, override var repository: IRepository, private var schedulers: Schedulers) : IRouteNamePresenter {

    private lateinit var route : Route
    private var routeName : String? = null
    private var subscriptions: CompositeDisposable = CompositeDisposable()

    override fun onCreate(route: Route) {
        subscriptions.add(onRouteNameChanged())
        this.route = route
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
        subscriptions.clear()
    }

    override fun saveBtnClicked() {
        route.name = routeName
        saveRouteInLocalStorage() //TODO get boolean response from saveInLocalStorage
        view.navigateToRoutesListScreen()
    }

    private fun onRouteNameChanged(): Disposable {
        return view.routeName().subscribe { string -> checkRouteName(string) }
    }

    private fun saveRouteInLocalStorage() {
        repository.saveRouteInLocalStorage(route)
    }

    private fun checkRouteName(string: String?) {
        with(string){
            if(isValidRouteName()){
                routeName = string
                view.enableSaveButton()
            }else{
                view.disableSaveButton()
            }
        }
    }
}