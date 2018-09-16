package app.demo.example.com.trailtracker

import app.demo.example.com.trailtracker.global.GlobalPresenter
import app.demo.example.com.trailtracker.global.IGlobalView
import app.demo.example.com.trailtracker.location.LocationProviderImplementation
import app.demo.example.com.trailtracker.repository.Repository
import io.reactivex.Scheduler
import io.reactivex.internal.schedulers.ExecutorScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executor


/**
 *
 * Example of Unit test utilization
 *
 */
@RunWith(MockitoJUnitRunner::class)
class GlobalPresenterTest {

    lateinit var view: IGlobalView
    lateinit var presenter: GlobalPresenter
    lateinit var repository: Repository
    lateinit var locationProvider: LocationProviderImplementation

    @Before
    fun setup() {
        view = Mockito.mock(IGlobalView::class.java, Mockito.CALLS_REAL_METHODS)
        repository = Mockito.mock(Repository::class.java, Mockito.CALLS_REAL_METHODS)
        locationProvider = Mockito.mock(LocationProviderImplementation::class.java)
        presenter = GlobalPresenter(view, repository, MockSchedulers(), locationProvider)
        presenter = spy(presenter)
        view.presenter = presenter
    }

    @Test
    fun testFinishLocation(){
        `when`(view.getStringResource(R.string.start))
                .thenReturn("START")
        presenter.startLocation("FINISH")
        verify(locationProvider, never()).getMyLocation()
        verify(view,Mockito.times(1))
                .setStartButtonText(ArgumentMatchers.anyString())
        verify(view, Mockito.times(1))
                .stopChronometer()
    }

    class MockSchedulers : app.demo.example.com.trailtracker.rx.Schedulers {

        private val immediate = object : Scheduler() {
            override fun createWorker(): Scheduler.Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
            }
        }

        override fun io(): Scheduler {
            return immediate
        }

        override fun androidThread(): Scheduler {
            return immediate
        }

        override fun internet(): Scheduler {
            return immediate
        }
    }
}