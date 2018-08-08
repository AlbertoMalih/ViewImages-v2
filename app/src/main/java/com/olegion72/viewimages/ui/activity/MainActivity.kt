package com.olegion72.viewimages.ui.activity

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.olegion72.viewimages.R
import com.olegion72.viewimages.extensions.load
import com.olegion72.viewimages.data.model.Image
import com.olegion72.viewimages.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {
    @InjectPresenter()
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startSearch.setOnClickListener { presenter.createImage(imageUrl.text.toString()) }
        showCachedImages.setOnClickListener { startActivity(Intent(this, AllImagesActivity::class.java)) }
    }

    override fun showImage(image: Image) {
        foundImage.load(image.imageUrl)
    }
}