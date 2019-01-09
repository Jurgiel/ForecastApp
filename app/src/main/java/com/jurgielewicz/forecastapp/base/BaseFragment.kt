package com.jurgielewicz.forecastapp.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment<P: BasePresenter<BaseView>> : Fragment() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

}