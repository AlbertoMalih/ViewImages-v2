package com.olegion72.viewimages.presenter

import com.arellomobile.mvp.InjectViewState
import com.olegion72.viewimages.base.BasePresenter
import com.olegion72.viewimages.data.model.Image
import com.olegion72.viewimages.extensions.isOnline
import com.olegion72.viewimages.ui.activity.MainView
import io.reactivex.android.schedulers.AndroidSchedulers

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {
    private lateinit var lastImage: Image


    fun createImage(imageUrl: String) {
        if (isOnline()) {
            lastImage = Image(imageUrl, System.currentTimeMillis())
            dbManager.addImage(lastImage)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ image -> viewState.showImage(image) }, {})
        }
    }
}