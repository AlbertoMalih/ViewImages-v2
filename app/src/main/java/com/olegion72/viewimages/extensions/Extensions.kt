package com.olegion72.viewimages.extensions

import android.net.ConnectivityManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.olegion72.viewimages.di.inject

fun ImageView.load(url: String) = Glide.with(this)
        .load(url)
        .into(this)

fun isOnline(): Boolean =
        with(connectivityManager.activeNetworkInfo) { return this != null && isConnected }


private val connectivityManager: ConnectivityManager by inject()
