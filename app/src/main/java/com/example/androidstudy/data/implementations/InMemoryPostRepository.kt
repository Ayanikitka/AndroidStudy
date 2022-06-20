package com.example.androidstudy.data.implementations

import androidx.lifecycle.MutableLiveData
import com.example.androidstudy.Post
import com.example.androidstudy.data.PostRepository

class InMemoryPostRepository : PostRepository {

    override val data = MutableLiveData(
        Post(
            id = 0L,
            author = "Нетология",
            message = "Всем привет!",
            date = "08.06.2022",
            likes = 9_999,
            shares = 1,
            views = 1_100_000
        )
    )
    override fun like() {
        val currentPost = checkNotNull(data.value)
        val currentLikes =
            if (currentPost.likedByMe) currentPost.likes - 1
            else currentPost.likes + 1
        val likedPost = currentPost.copy(
            likedByMe = !currentPost.likedByMe,
            likes = currentLikes
        )
        data.value = likedPost
    }

    override fun share() {
        val currentPost = data.value
        val sharesPost = currentPost?.copy(
            shares = currentPost.shares + 1
        )
        data.value = sharesPost
    }
}