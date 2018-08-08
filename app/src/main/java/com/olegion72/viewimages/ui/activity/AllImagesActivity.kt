package com.olegion72.viewimages.ui.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.olegion72.viewimages.R
import com.olegion72.viewimages.data.model.Image
import com.olegion72.viewimages.presenter.AllImagesPresenter
import com.olegion72.viewimages.ui.adapter.ImagesAdapter
import kotlinx.android.synthetic.main.activity_loaded_images.*

class AllImagesActivity : MvpAppCompatActivity(), AllImagesView {
    @InjectPresenter()
    lateinit var presenter: AllImagesPresenter
    private var imagesAdapter = ImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loaded_images)
        initViewImages()
    }

    override fun showImages(images: List<Image>) {
        imagesAdapter.updateImages(images)
    }


    private fun initViewImages() {
        with(allImages) {
            adapter = imagesAdapter
        }
    }
}