package com.example.mvprxjava

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    override fun calc(x: Long) {
        val res = x * 5
        view.setCalcResult(x, res)
    }
}