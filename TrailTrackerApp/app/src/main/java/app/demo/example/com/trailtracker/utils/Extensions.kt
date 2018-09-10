package app.demo.example.com.trailtracker.utils

import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by Guille on 10/9/18.
 */
fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}