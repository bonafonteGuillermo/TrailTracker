package app.demo.example.com.trailtracker.routename

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.model.Route
import app.demo.example.com.trailtracker.utils.snack
import app.demo.example.com.trailtracker.utils.textChanged
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_route_name.view.*
import app.demo.example.com.trailtracker.routes.RoutesActivity

/**
 *
 * View for routename screen
 *
 * Created by Guillermo Bonafonte Criado
 */
class RouteNameView(context: AppCompatActivity) : IRouteNameView {

    override var context: Context = context
    override var presenter: IRouteNamePresenter? = null
    override fun constructView(): View = view

    private var nameContent: PublishSubject<String> = PublishSubject.create()
    var view: View

    init {
        val parent = FrameLayout(context)
        parent.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        view = LayoutInflater.from(context).inflate(R.layout.activity_route_name, parent, true)
        view.et_route_name.textChanged { newText -> nameContent.onNext(newText)}
        view.btn_save.setOnClickListener {
            presenter?.saveBtnClicked()
            view.snack("Saved")
        }
    }

    override fun getTextViewRouteText(): String = view.tv_choose_name.text.toString()

    override fun routeName(): Observable<String> = nameContent

    override fun enableSaveButton() {
        view.btn_save.isEnabled = true
    }

    override fun disableSaveButton() {
        view.btn_save.isEnabled = false
    }

    override fun navigateToRoutesListScreen() {
        startActivity(RoutesActivity::class.java)
    }
}