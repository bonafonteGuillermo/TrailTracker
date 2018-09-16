package app.demo.example.com.trailtracker.utils

import android.content.Context
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by Guillermo Bonafonte Criado
 */
fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun String?.isValidRouteName() : Boolean = !isNullOrBlank() && !isNullOrEmpty()

fun Long.toCustomStringFormat(): String =
        String.format("%02d hour, %02d min, %02d sec",
            TimeUnit.MILLISECONDS.toHours(this),
            TimeUnit.MILLISECONDS.toMinutes(this),
            TimeUnit.MILLISECONDS.toSeconds(this) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(this))
)

fun Date?.toCustomDateFormatString() : String {
    val df = SimpleDateFormat("EEE dd/MMM HH:mm:ss")
    return df.format(this)
}

fun Context.getStringResource(id : Int): String = resources.getString(id)

// Extensions widgets
fun EditText.textChanged(textChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(editable: Editable?) {
            textChanged.invoke(editable.toString())
        }
    })
}

