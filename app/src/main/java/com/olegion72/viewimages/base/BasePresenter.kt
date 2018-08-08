package com.olegion72.viewimages.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.olegion72.viewimages.data.db.DbManager
import com.olegion72.viewimages.di.inject

abstract class BasePresenter<VIEW : MvpView> : MvpPresenter<VIEW>() {
    protected val dbManager: DbManager by inject()
}