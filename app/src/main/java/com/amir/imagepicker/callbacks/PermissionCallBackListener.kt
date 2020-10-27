package com.amir.imagepicker.callbacks

interface PermissionCallBackListener {
    fun onNeedPermission()
    fun onPermissionPreviouslyDenied()
    fun onPermissionDisable()
    fun onPermissionGranted()
}