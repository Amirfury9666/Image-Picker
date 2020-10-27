package com.amir.imagepicker.model

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import java.util.*
import kotlin.collections.ArrayList

class Config() : Parcelable{
    private var toolbarColor : String? = ""
    private var statusBarColor  : String?  = ""
    private var toolbarTextColor  : String?  = ""
    private var toolbarIconColor  : String?  = ""
    private var progressBarColor  : String?  = ""
    private var backgroundColor   : String?  = ""
    private var isCameraOnly = true
    private var isMultipleMode = false
    private var isFolderMode = false
    private var isShowCamera = false
    private var maxSize = 0
    private var doneTitle  : String?  = ""
    private var folderTitle  : String?  = ""
    private var imageTitle  : String? = ""
    private var limitMessage  : String? = ""
    private var savePath: SavePath? = null
    private var isAlwaysShowDoneButton = false
    private var isKeepScreenOn = false
    private var requestCode = -1
    private var selectedImagesList : ArrayList<Image?>? = null

    constructor(parcel: Parcel) : this() {
        toolbarColor = parcel.readString()
        statusBarColor = parcel.readString()
        toolbarTextColor = parcel.readString()
        toolbarIconColor = parcel.readString()
        progressBarColor = parcel.readString()
        backgroundColor = parcel.readString()
        isCameraOnly = parcel.readByte() != 0.toByte()
        isMultipleMode = parcel.readByte() != 0.toByte()
        isFolderMode = parcel.readByte() != 0.toByte()
        isShowCamera = parcel.readByte() != 0.toByte()
        maxSize = parcel.readInt()
        doneTitle = parcel.readString()
        folderTitle = parcel.readString()
        imageTitle = parcel.readString()
        limitMessage = parcel.readString()
        savePath = parcel.readParcelable(SavePath::class.java.classLoader)
        isAlwaysShowDoneButton = parcel.readByte() != 0.toByte()
        isKeepScreenOn = parcel.readByte() != 0.toByte()
        requestCode = parcel.readInt()
    }


    fun getToolbarColor(): Int {
        if (TextUtils.isEmpty(toolbarColor)) {
            return Color.parseColor("#212121")
        }
        return Color.parseColor(toolbarColor)
    }

    fun setToolbarColor(toolbarColor: String) {
        this.toolbarColor = toolbarColor
    }

    fun getStatusBarColor(): Int {
        if (TextUtils.isEmpty(statusBarColor)) {
            return Color.parseColor("#000000")
        }
        return Color.parseColor(statusBarColor)
    }

    fun setStatusBarColor(statusBarColor: String){
        this.statusBarColor = statusBarColor
    }


    fun getToolbarTextColor(): Int {
        return if (TextUtils.isEmpty(toolbarTextColor)) {
            Color.parseColor("#FFFFFF")
        } else Color.parseColor(toolbarTextColor)
    }

    fun setToolbarTextColor(toolbarTextColor: String?) {
        this.toolbarTextColor = toolbarTextColor!!
    }

    fun getToolbarIconColor(): Int {
        return if (TextUtils.isEmpty(toolbarIconColor)) {
            Color.parseColor("#FFFFFF")
        } else Color.parseColor(toolbarIconColor)
    }

    fun setToolbarIconColor(toolbarIconColor: String?) {
        this.toolbarIconColor = toolbarIconColor!!
    }

    fun getProgressBarColor(): Int {
        return if (TextUtils.isEmpty(progressBarColor)) {
            Color.parseColor("#4CAF50")
        } else Color.parseColor(progressBarColor)
    }

    fun setProgressBarColor(progressBarColor: String?) {
        this.progressBarColor = progressBarColor!!
    }

    fun getBackgroundColor(): Int {
        return if (TextUtils.isEmpty(backgroundColor)) {
            Color.parseColor("#212121")
        } else Color.parseColor(backgroundColor)
    }

    fun setBackgroundColor(backgroundColor: String?) {
        this.backgroundColor = backgroundColor!!
    }

    fun isCameraOnly(): Boolean {
        return isCameraOnly
    }

    fun setCameraOnly(cameraOnly: Boolean) {
        isCameraOnly = cameraOnly
    }

    fun isMultipleMode(): Boolean {
        return isMultipleMode
    }

    fun setMultipleMode(multipleMode: Boolean) {
        isMultipleMode = multipleMode
    }

    fun isFolderMode(): Boolean {
        return isFolderMode
    }

    fun setFolderMode(folderMode: Boolean) {
        isFolderMode = folderMode
    }

    fun isShowCamera(): Boolean {
        return isShowCamera
    }

    fun setShowCamera(showCamera: Boolean) {
        isShowCamera = showCamera
    }

    fun getMaxSize(): Int {
        return maxSize
    }

    fun setMaxSize(maxSize: Int) {
        this.maxSize = maxSize
    }

    fun getDoneTitle(): String? {
        return doneTitle
    }

    fun setDoneTitle(doneTitle: String?) {
        this.doneTitle = doneTitle!!
    }

    fun getFolderTitle(): String? {
        return folderTitle
    }

    fun setFolderTitle(folderTitle: String?) {
        this.folderTitle = folderTitle!!
    }

    fun getImageTitle(): String? {
        return imageTitle
    }

    fun setImageTitle(imageTitle: String?) {
        this.imageTitle = imageTitle!!
    }

    fun getLimitMessage(): String? {
        return limitMessage
    }

    fun setLimitMessage(limitMessage: String?) {
        this.limitMessage = limitMessage!!
    }

    fun getSavePath(): SavePath? {
        return savePath
    }

    fun setSavePath(savePath: SavePath?) {
        this.savePath = savePath
    }

    fun isAlwaysShowDoneButton(): Boolean {
        return isAlwaysShowDoneButton
    }

    fun setAlwaysShowDoneButton(isAlwaysShowDoneButton: Boolean) {
        this.isAlwaysShowDoneButton = isAlwaysShowDoneButton
    }

    fun isKeepScreenOn(): Boolean {
        return isKeepScreenOn
    }

    fun setKeepScreenOn(keepScreenOn: Boolean) {
        isKeepScreenOn = keepScreenOn
    }

    fun getRequestCode(): Int {
        return requestCode
    }

    fun setRequestCode(requestCode: Int) {
        this.requestCode = requestCode
    }

    fun getSelectedImages(): ArrayList<Image?>? {
        return selectedImagesList
    }

    fun setSelectedImages(selectedImages: ArrayList<Image?>) {
        this.selectedImagesList = selectedImages
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(toolbarColor)
        parcel.writeString(statusBarColor)
        parcel.writeString(toolbarTextColor)
        parcel.writeString(toolbarIconColor)
        parcel.writeString(progressBarColor)
        parcel.writeString(backgroundColor)
        parcel.writeByte(if (isCameraOnly) 1 else 0)
        parcel.writeByte(if (isMultipleMode) 1 else 0)
        parcel.writeByte(if (isFolderMode) 1 else 0)
        parcel.writeByte(if (isShowCamera) 1 else 0)
        parcel.writeInt(maxSize)
        parcel.writeString(doneTitle)
        parcel.writeString(folderTitle)
        parcel.writeString(imageTitle)
        parcel.writeString(limitMessage)
        parcel.writeParcelable(savePath, flags)
        parcel.writeByte(if (isAlwaysShowDoneButton) 1 else 0)
        parcel.writeByte(if (isKeepScreenOn) 1 else 0)
        parcel.writeInt(requestCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Config> {
        override fun createFromParcel(parcel: Parcel): Config {
            return Config(parcel)
        }

        override fun newArray(size: Int): Array<Config?> {
            return arrayOfNulls(size)
        }
    }
}