package com.example.pc.mycoroutine.util.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pc.mycoroutine.feature.post.PostAdapter

@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: PostAdapter) {
    recyclerView.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(recyclerView: RecyclerView, layoutManager: LinearLayoutManager) {
    recyclerView.layoutManager = layoutManager
}