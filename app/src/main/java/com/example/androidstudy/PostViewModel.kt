package com.example.androidstudy

import androidx.lifecycle.ViewModel
import com.example.androidstudy.data.PostRepository
import com.example.androidstudy.data.implementations.InMemoryPostRepository

class PostViewModel : ViewModel() {

    private val repository: PostRepository = InMemoryPostRepository()

    val data by repository::data

    fun onLikeClicked() = repository.like()

    fun onShareClicked() = repository.share()
}