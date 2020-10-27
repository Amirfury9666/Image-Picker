package com.amir.imagepicker.helper

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.amir.imagepicker.callbacks.PermissionCallBackListener

object PermissionHelper {
    fun checkPermission(activity : Activity,permission : String, listener : PermissionCallBackListener?){
        if (!hasSelfPermission(activity,permission)){
            if (shouldShowRequestPermissionRationale(activity,permission)){
                listener?.onPermissionPreviouslyDenied()
            }else{
                if (PreferenceHelper.isFirstTimeAskingForPermission(activity,permission)){
                    PreferenceHelper.firstTimeAskingForPermission(activity,permission,false)
                    listener?.onNeedPermission()
                }
            }
        }else{
            listener?.onPermissionGranted()
        }
    }


    private fun hasSelfPermission(context: Context, permission: String) : Boolean{
        if (shouldAskPermission()){
            return permissionHasGranted(context,permission)
        }
        return true
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun permissionHasGranted(context: Context, permission: String): Boolean {
        return hasPermissionGranted(context.checkSelfPermission(permission))
    }

    private fun hasPermissionGranted(grantResult : Int) : Boolean{
        return grantResult == PackageManager.PERMISSION_GRANTED
    }

    fun hasPermissionGranted(grantResults : Array<Int>) : Boolean{
        for (result  in grantResults){
            if (!hasPermissionGranted(result)){
                return false
            }
        }
        return true
    }

    private fun shouldAskPermission() : Boolean{
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    private fun shouldShowRequestPermissionRationale(activity: Activity,permission: String) : Boolean{
        return ActivityCompat.shouldShowRequestPermissionRationale(activity,permission)
    }
}