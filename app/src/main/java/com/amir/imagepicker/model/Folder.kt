package com.amir.imagepicker.model

class Folder(bucket : String) {
    var folderName = bucket
    var images = arrayListOf<Image>()
    var imagesCount = images.size

}