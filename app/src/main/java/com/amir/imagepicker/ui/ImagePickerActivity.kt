package com.amir.imagepicker.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.amir.imagepicker.R
import com.amir.imagepicker.core.BaseActivity
import com.amir.imagepicker.databinding.ActivityImagePickerBinding

class ImagePickerActivity : BaseActivity<ActivityImagePickerBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_image_picker

    override fun getToolbar(binding: ActivityImagePickerBinding): Toolbar? = null

    override fun onActivityReady(instanceState: Bundle?, binding: ActivityImagePickerBinding) {

    }
    private fun setUpUi(binding: ActivityImagePickerBinding){

    }
}