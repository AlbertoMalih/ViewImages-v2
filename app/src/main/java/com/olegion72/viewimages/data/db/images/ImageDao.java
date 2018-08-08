package com.olegion72.viewimages.data.db.images;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.olegion72.viewimages.data.model.Image;

import java.util.List;

import io.reactivex.Single;

import static com.olegion72.viewimages.data.db.images.ImagesDatabaseKt.IMAGES_TABLE_NAME;

@Dao
public interface ImageDao {
    @Query("SELECT * FROM " + IMAGES_TABLE_NAME + " ORDER BY date")
    Single<List<Image>> loadImages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Image users);
}