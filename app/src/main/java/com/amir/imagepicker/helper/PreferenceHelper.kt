package com.amir.imagepicker.helper

import android.content.Context


private const val PREFERENCE_FILE_NAME = "ImagePicker"

object PreferenceHelper {

    fun firstTimeAskingForPermission(context: Context, permission: String, isFirstTime: Boolean) {
        val preferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
        preferences.edit().putBoolean(permission, isFirstTime).apply()
    }

    fun isFirstTimeAskingForPermission(context: Context, permission: String): Boolean {
        return context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
            .getBoolean(permission, true)
    }
}