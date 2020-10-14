package com.example.mvprxjava

interface MainContract {
    interface View {
        fun setCalcResult(x: String)
    }
    interface Presenter {
        fun calc(x: String)
    }
}