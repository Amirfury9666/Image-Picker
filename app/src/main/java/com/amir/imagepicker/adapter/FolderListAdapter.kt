package com.amir.imagepicker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.amir.imagepicker.R
import com.amir.imagepicker.core.BaseListAdapter
import com.amir.imagepicker.model.Folder

class FolderListAdapter : BaseListAdapter<Folder>(FolderListDiffCallBack()) {

    private class FolderListDiffCallBack : DiffUtil.ItemCallback<Folder>() {
        override fun areItemsTheSame(oldItem: Folder, newItem: Folder): Boolean {
            return oldItem.folderName == newItem.folderName && oldItem.images == newItem.images
        }

        override fun areContentsTheSame(oldItem: Folder, newItem: Folder): Boolean {
            return oldItem.folderName == newItem.folderName && oldItem.images == newItem.images
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_folder
    }
}