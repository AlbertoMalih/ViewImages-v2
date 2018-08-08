package com.olegion72.viewimages.ui.activity

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.olegion72.viewimages.data.model.Image

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun showImage(image: Image)
}