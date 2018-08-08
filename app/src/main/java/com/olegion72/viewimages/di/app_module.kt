package com.olegion72.viewimages.di

import android.arch.persistence.room.Room
import android.content.Context
import android.net.ConnectivityManager
import com.bumptech.glide.Glide
import com.olegion72.viewimages.data.db.AppDbManager
import com.olegion72.viewimages.data.db.DbManager
import com.olegion72.viewimages.data.db.images.IMAGES_DB
import com.olegion72.viewimages.data.db.images.ImagesDatabase
import org.koin.KoinContext
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext

val imagesModule = applicationContext {
    bean { Glide.with(get<Context>()) }
    bean { AppDbManager(get()) as DbManager }
    bean { get<Context>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    bean { Room.databaseBuilder(get(), ImagesDatabase::class.java, IMAGES_DB).build() }
}

inline fun <reified T> inject() = lazy { (StandAloneContext.koinContext as KoinContext).get<T>() }