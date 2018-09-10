package app.demo.example.com.trailtracker.global

import io.reactivex.disposables.Disposable
import app.demo.example.com.trailtracker.repository.IRepository
import app.demo.example.com.trailtracker.rx.Schedulers

/**
 *
 * Presenter for Splash screen.
 *
 * Created by Guillermo Bonafonte Criado
 */
class GlobalPresenter(private var view: IGlobalView, override var repository: IRepository, private var schedulers: Schedulers) : IGlobalPresenter {

    private lateinit var subscription: Disposable

    override fun onCreate() {

    }

    override fun onDestroy() {
        subscription.dispose()
    }
}
