package com.olegion72.viewimages.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.olegion72.viewimages.data.db.images.IMAGES_TABLE_NAME

@Entity(tableName = IMAGES_TABLE_NAME)
data class Image(@PrimaryKey var imageUrl: String = "", var date: Long = -1L)