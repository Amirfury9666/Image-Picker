package com.amir.imagepicker.callbacks

interface ICustomItemClickListener<T> {
    fun onItemClick(id : Int,t : T)
}