import TestUtils.Companion.allowPermissionsIfNeeded
import android.os.Build
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.*
import android.util.Log
import app.demo.example.com.trailtracker.R
import app.demo.example.com.trailtracker.global.GlobalActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 *
 * Example of UI test utilization
 *
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class GlobalScreenTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<GlobalActivity>(GlobalActivity::class.java)

    @Before
    fun testSetup() = Intents.init()

    @After
    fun finishTest() = Intents.release()

    @Test
    fun startRoute() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_start)).perform(ViewActions.click())
        allowPermissionsIfNeeded()
        Espresso.onView(ViewMatchers.withId(R.id.progressBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}

class TestUtils {

    companion object {

        val timeoutPermissionsDialog : Long = 5000
        val textAllowButton = "ALLOW"

        fun allowPermissionsIfNeeded() {
            if (Build.VERSION.SDK_INT >= 23) {
                val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                device.wait(Until.findObject(By.text(textAllowButton)), timeoutPermissionsDialog)
                val allowPermissions = device.findObject(UiSelector().text(textAllowButton))
                if (allowPermissions.exists()) {
                    try {
                        allowPermissions.click()
                    } catch (e: UiObjectNotFoundException) {
                        Log.e(TestUtils::class.java.simpleName,e.message,e)
                    }
                }
            }
        }
    }
}