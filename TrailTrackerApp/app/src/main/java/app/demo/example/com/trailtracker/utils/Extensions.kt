package app.demo.example.com.trailtracker.utils

import android.support.design.widget.Snackbar
import android.view.View


/**
 * Created by Guillermo Bonafonte Criado
 */
fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}