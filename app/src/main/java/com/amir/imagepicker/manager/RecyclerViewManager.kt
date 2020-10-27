package com.amir.imagepicker.manager

import android.content.Context
import android.os.Parcelable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amir.imagepicker.adapter.FolderListAdapter
import com.amir.imagepicker.adapter.ImageListAdapter
import com.amir.imagepicker.model.Config

class RecyclerViewManager(recyclerView: RecyclerView,config: Config,orientation  : Int) {

    private var context: Context = recyclerView.context
    private var recyclerView: RecyclerView = recyclerView
    private var isShowingFolder : Boolean = config.isFolderMode()

    private lateinit var config: Config
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var imageListAdapter : ImageListAdapter

    private lateinit var folderList  : FolderListAdapter
    private var imageColumns = 0
    private var folderColumns = 0
    private lateinit var folderState : Parcelable
    private var title : String = ""

}