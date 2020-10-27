package com.amir.imagepicker.callbacks

interface ImageLoaderListener {
    fun onImageLoaded()
    fun onFailed(throwable: Throwable)
}