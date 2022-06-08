package com.example.androidstudy

data class Post (
    val id: Long,
    val author: String,
    val message: String,
    val date: String,
    var likes: Int = 0,
    var shares: Int = 0,
    var views: Int = 0,
    var likedByMe: Boolean = false
)