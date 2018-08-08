package com.olegion72.viewimages.data.db

import com.olegion72.viewimages.data.model.Image
import io.reactivex.Single

interface DbManager {
    fun loadImages(): Single<List<Image>>
    fun addImage(image: Image): Single<Image>
}