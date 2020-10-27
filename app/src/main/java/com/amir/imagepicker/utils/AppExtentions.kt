package com.amir.imagepicker.utils

import android.util.Log
import android.view.View

fun Any.printLog(tag : String,message : String?){
    Log.d(tag,message.toString())
}

fun View.show(){
    visibility  = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}