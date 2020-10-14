package com.example.mvprxjava

interface MainContract {
    interface View {
        fun setCalcResult(x: Long, res: Long)
        fun getNum(): Long
    }
    interface Presenter {
        fun calc(x: Long)
    }
}