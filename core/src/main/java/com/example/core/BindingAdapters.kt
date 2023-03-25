package com.example.core

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingAdapters {
    companion object {

        @JvmStatic
        @BindingAdapter("submitListItems")
        fun submitListItems(recyclerView: RecyclerView?, list: List<Any>) {
            recyclerView?.adapter?.let {
                (it as ListAdapter<Any, *>).submitList(list)
            }
        }

        @JvmStatic
        @BindingAdapter("onButtonClickListener")
        fun setOnButtonClick(
            button: Button,
            onClickListener: () -> Unit
        ) {
            button.setOnClickListener {
                onClickListener.invoke()
            }
        }
    }
}