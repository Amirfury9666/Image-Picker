package com.amir.imagepicker.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amir.imagepicker.BR
import com.amir.imagepicker.callbacks.ICustomItemClickListener
/**
 * Created By Amir Fury on 3 jan 2020
 */
abstract class BaseListAdapter<T>(diffItemCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T,BaseListAdapter<T>.BaseViewHolder>(diffItemCallback) {

    private var listener  : ICustomItemClickListener<T>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder{
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), viewType, parent, false)
        return BaseViewHolder(binding)
    }

    fun setClickListener(clickListener: ICustomItemClickListener<T>){
        this.listener = clickListener
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind(getItem(position))

    inner class BaseViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            binding.setVariable(BR.model,item)
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                listener?.onItemClick(it.id,item)
            }
        }
    }

}