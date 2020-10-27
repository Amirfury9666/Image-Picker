package com.amir.imagepicker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.amir.imagepicker.R
import com.amir.imagepicker.core.BaseListAdapter
import com.amir.imagepicker.model.Image

class ImageListAdapter : BaseListAdapter<Image>(ImageListDiffCallBack()) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_image
    }

    private class ImageListDiffCallBack : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.path == newItem.path
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.path == newItem.path
        }
    }
}