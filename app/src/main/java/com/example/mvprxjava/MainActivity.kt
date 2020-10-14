package com.example.mvprxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val subject = BehaviorSubject.createDefault("0")
        editText.addTextChangedListener {
            try {
                presenter.calc(editText.text.toString())
            } catch (e:Exception){
                println(e)
            }
//            subject.map { editText.text.toString() == "" }
//                .flatMap({ BehaviorSubject.range(1, 9) }
//                ) { _, row -> "0 x $row = 0\n" }
//                .scan { x, y -> x + y }
//                .subscribe { text -> textView.text = text }
//
//            subject.map { editText.text.toString().toLong() }
//                .flatMap({ BehaviorSubject.range(1, 9) }
//                ) { dan, row -> dan.toString() + " x " + row + " = " + dan * row + "\n" }
//                .scan { x, y -> x + y }
//                .doOnNext { data -> Log.d("onNext()", data) }
//                .subscribe({ text -> textView.text = text }) { obj: Throwable -> obj.message }
        }
    }

    override fun setCalcResult(x: String) {
        textView.text = x
    }
}