package com.example.androidstudy.data

import androidx.lifecycle.LiveData
import com.example.androidstudy.Post

interface PostRepository {

    val data: LiveData<Post>

    fun like()

    fun share()
}