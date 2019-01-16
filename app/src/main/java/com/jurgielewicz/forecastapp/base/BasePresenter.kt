package com.jurgielewicz.forecastapp.base


interface BasePresenter {
    open fun onViewCreated(){}
    open fun onViewDestroyed(){}
}