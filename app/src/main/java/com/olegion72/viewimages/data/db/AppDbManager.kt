package com.olegion72.viewimages.data.db

import com.olegion72.viewimages.data.db.images.ImagesDatabase
import com.olegion72.viewimages.data.model.Image
import io.reactivex.Single

class AppDbManager(private val database: ImagesDatabase) : DbManager {
    override fun loadImages(): Single<List<Image>> = database.loadImages()

    override fun addImage(image: Image): Single<Image> = database.addImage(image)
}