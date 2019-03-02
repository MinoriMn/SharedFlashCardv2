package com.gmail.kamemaru2011.mvp_base

interface BaseView<T : BasePresenter>{
    val presenter: T
}