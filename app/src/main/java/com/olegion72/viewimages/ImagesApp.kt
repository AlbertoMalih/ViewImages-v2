package com.olegion72.viewimages

import android.app.Application
import com.olegion72.viewimages.di.imagesModule
import org.koin.android.ext.android.startKoin


open class ImagesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(imagesModule))
    }
}