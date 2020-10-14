package com.example.mvprxjava

import io.reactivex.subjects.BehaviorSubject

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    override fun calc(x: String) {

        val subject = BehaviorSubject.createDefault("0")

        subject.map { x == "" }
            .flatMap({ BehaviorSubject.range(1, 9) }
            ) { _, row -> "0 x $row = 0\n" }
            .scan { x, y -> x + y }
            .subscribe { text -> view.setCalcResult(text) }

        subject.map { x.toLong() }
            .flatMap({ BehaviorSubject.range(1, 9) }
            ) { dan, row -> dan.toString() + " x " + row + " = " + dan * row + "\n" }
            .scan { x, y -> x + y }
            .subscribe({ text -> view.setCalcResult(text) }) { obj: Throwable -> obj.message }
    }
}