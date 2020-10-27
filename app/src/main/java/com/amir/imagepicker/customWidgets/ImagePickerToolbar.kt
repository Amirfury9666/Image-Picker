package com.amir.imagepicker.customWidgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.amir.imagepicker.R
import com.amir.imagepicker.model.Config

class ImagePickerToolbar  : RelativeLayout{

    private lateinit var toolbarTitle : TextView
    private lateinit var doneText : TextView
    private lateinit var backButtonImage : AppCompatImageView
    private lateinit var cameraIcon : AppCompatImageView


    constructor(context : Context) : super(context){
        init(context)
    }

    constructor(context: Context,attrs : AttributeSet) : super(context,attrs){
        init(context)
    }

    constructor(context: Context,attrs: AttributeSet,defStyle : Int) : super(context,attrs,defStyle){
        init(context)
    }

    private fun init(context: Context){
        View.inflate(context, R.layout.image_picker_toolbar,this)
        if (isInEditMode){
            return
        }
        toolbarTitle = findViewById(R.id.toolbarTitle)
        doneText = findViewById(R.id.doneText)
        backButtonImage = findViewById(R.id.backButton)
        cameraIcon = findViewById(R.id.cameraIcon)
    }

    fun config(config : Config){
        setBackgroundColor(config.getToolbarColor())
        toolbarTitle.text = if (config.isFolderMode()){
            config.getFolderTitle()
        }else{
            config.getImageTitle()
        }

        doneText.text = config.getDoneTitle()
        doneText.setTextColor(config.getToolbarTextColor())
        backButtonImage.setColorFilter(config.getToolbarIconColor())
        cameraIcon.setColorFilter(config.getToolbarIconColor())
        cameraIcon.visibility = if (config.isShowCamera()){
           VISIBLE
        }else{
            GONE
        }
    }

    fun setTitle(title : String){
        toolbarTitle.text = title
    }

    fun showDoneButton(isShow : Boolean){
        doneText.visibility = if (isShow){
            VISIBLE
        }else{
            GONE
        }
    }

    fun setOnBackClickListener(clickListener : OnClickListener){
        backButtonImage.setOnClickListener(clickListener)
    }

    fun setOnCameraClickListener(clickListener: OnClickListener){
        cameraIcon.setOnClickListener(clickListener)
    }

    fun setOnDoneClickListener(clickListener: OnClickListener){
        doneText.setOnClickListener(clickListener)
    }
}