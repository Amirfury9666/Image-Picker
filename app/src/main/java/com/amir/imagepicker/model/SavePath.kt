package com.amir.imagepicker.model

import android.os.Parcel
import android.os.Parcelable

data class SavePath(val path : String?,val isFullPath : Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(path)
        parcel.writeByte(if (isFullPath) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SavePath> {
        override fun createFromParcel(parcel: Parcel): SavePath {
            return SavePath(parcel)
        }

        override fun newArray(size: Int): Array<SavePath?> {
            return arrayOfNulls(size)
        }
    }

}