package com.olegion72.viewimages.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.olegion72.viewimages.R
import com.olegion72.viewimages.extensions.load
import com.olegion72.viewimages.data.model.Image
import kotlinx.android.synthetic.main.image_item.view.*

class ImagesAdapter :
        RecyclerView.Adapter<ImagesAdapter.ImageHolder>() {
    var listPhotos: MutableList<Image> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, typeHolder: Int): ImageHolder =
            ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false))

    override fun getItemCount(): Int = listPhotos.size

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        listPhotos[position].let { image -> holder.imageView.load(image.imageUrl) }
    }

    fun updateImages(images: List<Image>) {
        listPhotos.clear()
        listPhotos.addAll(images)
        notifyDataSetChanged()
    }

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.displayImage
    }
}
