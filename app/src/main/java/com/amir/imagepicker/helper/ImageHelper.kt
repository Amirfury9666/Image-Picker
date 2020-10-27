package com.amir.imagepicker.helper

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Environment
import com.amir.imagepicker.model.Image
import com.amir.imagepicker.model.SavePath
import com.amir.imagepicker.utils.printLog
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

private val TAG = ImageHelper::class.java.simpleName

object ImageHelper {

    @SuppressLint("SimpleDateFormat")
    fun saveImageFile(savePath: SavePath): File? {
        val path = savePath.path?: ""
        val mediaStorageDir = if (savePath.isFullPath) {
            File(path)
        } else {
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), path)
        }

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                printLog(TAG, "Oops! Fail to create $path")
                return null
            }
        }
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "IMG_$timeStamp"

        return try {
            File.createTempFile(fileName, ".jpg", mediaStorageDir)
        } catch (e: IOException) {
            printLog(TAG, "Oops! Fail to create $fileName file")
            return null
        }
    }


    private fun getNameFromFilePath(path : String) : String {
        return if (path.contains(File.separator)){
            path.substring(path.lastIndexOf(File.separator) + 1)
        }else{
            path
        }
    }

    fun grantAppPermission(context: Context, intent: Intent,fileUri : Uri){
        val resolveIntentActivities : MutableList<ResolveInfo> = context.packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY)
        for (resolveInfo in resolveIntentActivities){
            val packageName = resolveInfo.activityInfo.packageName
            context.grantUriPermission(packageName,fileUri,Intent.FLAG_GRANT_WRITE_URI_PERMISSION or  Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }


    fun revokeAppPermission(context: Context,fileUri : Uri){
        context.revokeUriPermission(fileUri,Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
    }

    fun singleListFromPath(path : String) : MutableList<Image>{
        val list = arrayListOf<Image>()
        list.add(Image(0, getNameFromFilePath(path),path))
        return list
    }

    fun isGifFormat(image : Image) : Boolean{
        val extension = image.path?.substring(image.path.lastIndexOf(".")+1)
        return extension == "gig"
    }
}