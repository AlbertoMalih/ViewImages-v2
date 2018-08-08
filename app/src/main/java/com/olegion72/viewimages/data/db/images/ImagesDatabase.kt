package com.olegion72.viewimages.data.db.images

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.olegion72.viewimages.data.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal const val IMAGES_TABLE_NAME = "images"
internal const val IMAGES_DB = "images_db"

@Database(entities = [(Image::class)], version = 1)
abstract class ImagesDatabase : RoomDatabase() {

    fun loadImages(): Single<List<Image>> =
            purchaseDao().loadImages()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun addImage(image: Image): Single<Image> =
            Single.create<Image> { emitter ->
                purchaseDao().insert(image)
                emitter.onSuccess(image)
            }
                    .subscribeOn(Schedulers.io())

    abstract fun purchaseDao(): ImageDao
}