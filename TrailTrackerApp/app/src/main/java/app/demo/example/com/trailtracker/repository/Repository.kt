package app.demo.example.com.trailtracker.repository

import android.annotation.SuppressLint
import app.demo.example.com.trailtracker.data.AppDatabase
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.rx.Schedulers
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

class Repository(
        private val localStorage: AppDatabase,
        private val schedulers: Schedulers
) : IRepository {

    @SuppressLint("CheckResult")
    override fun saveRouteInLocalStorage(route: Route): Single<Route> {
        var publisher = SingleSubject.create<Route>()
        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    localStorage.routesDao().insertRoute(route)
                    publisher.onSuccess(route)
                },
                {
                    publisher.onError(it)
                })
        return publisher

    }

    @SuppressLint("CheckResult")
    override fun getRoutesSavedInLocalStorage(): Single<List<Route>> {
        var publisher = SingleSubject.create<List<Route>>()

        Observable.just(localStorage).subscribeOn(schedulers.io()).subscribe(
                {
                    var routesLocallySaved = localStorage.routesDao().getRoutes()
                    publisher.onSuccess(routesLocallySaved)
                },
                {
                    publisher.onError(it)
                }
        )
        return publisher
    }
}