package com.example.mvprxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener {
            try {
                presenter.calc(editText.text.toString())
            } catch (e:Exception){
                println(e)
            }
        }
    }

    override fun setCalcResult(x: String) {
        textView.text = x
    }
}