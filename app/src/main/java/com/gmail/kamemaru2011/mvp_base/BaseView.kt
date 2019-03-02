package com.gmail.kamemaru2011.mvp_base

interface BaseView<T : BasePresenter>{
    var presenter: T
}