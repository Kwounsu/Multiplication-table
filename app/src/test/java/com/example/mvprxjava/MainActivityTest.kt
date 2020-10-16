package com.example.mvprxjava

import android.R
import android.os.Build
import androidx.test.core.app.ActivityScenario
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config


@Config(manifest = Config.NONE, sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun getPresenter() {
        scenario.onActivity { activity ->
            activity.presenter.calc("")
            activity.presenter.calc("1")
        }
    }

    @Test
    fun onCreate() {
        scenario.onActivity { activity ->
            assertTrue("TextView contains incorrect text", activity.textView.text.isNotEmpty())
        }
    }

    @Test
    fun setCalcResult() {
        scenario.onActivity { activity ->
            val str = "x"
            activity.setCalcResult(str)
            assertTrue(activity.textView.text == str)
        }
    }

    @Test
    fun testChangeListener() {
        scenario.onActivity { activity ->
            activity.editText.setText("1")
            Shadows.shadowOf(activity.editText).watchers[0].afterTextChanged(null)
        }
    }
}