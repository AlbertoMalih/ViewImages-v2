package com.olegion72.viewimages.presenter

import com.arellomobile.mvp.InjectViewState
import com.olegion72.viewimages.base.BasePresenter
import com.olegion72.viewimages.ui.activity.AllImagesView

@InjectViewState
class AllImagesPresenter : BasePresenter<AllImagesView>() {

    override fun onFirstViewAttach() {
        loadImages()
        super.onFirstViewAttach()
    }

    private fun loadImages() {
        dbManager.loadImages()
                .subscribe { images -> viewState.showImages(images) }
    }
}