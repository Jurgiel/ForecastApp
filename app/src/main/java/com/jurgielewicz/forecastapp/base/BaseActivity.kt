package com.jurgielewicz.forecastapp.base

import android.content.Context
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P: BasePresenter<BaseView>> : BaseView, AppCompatActivity(){
    protected lateinit var presenter: P


    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}