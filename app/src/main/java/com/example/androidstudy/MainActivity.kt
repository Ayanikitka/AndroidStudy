package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 0L,
            author = "Нетология",
            message = "Всем привет!",
            date = "08.06.2022",
            likes = 9_999,
            shares = 1,
            views = 1_100_000
        )
        binding.render(post)
        binding.likesIcon.setOnClickListener {
            if (!post.likedByMe) {
                binding.likesIcon.setImageResource(R.drawable.ic_baseline_thumb_up_alt_red_24)
                post.likes++
                binding.likesCount.text = PostService.getStringCount(post.likes)
            }
            else
            {
                binding.likesIcon.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24)
                post.likes--
                binding.likesCount.text = PostService.getStringCount(post.likes)
            }
            post.likedByMe = !post.likedByMe
        }
        binding.sharesIcon.setOnClickListener {
            post.shares++
            binding.sharesCount.text = PostService.getStringCount(post.shares)
        }
    }

    private fun ActivityMainBinding.render(post: Post) {
        postAuthor.text = post.author
        postDate.text = post.date
        postContent.text = post.message
        likesCount.text = PostService.getStringCount(post.likes)
        sharesCount.text = PostService.getStringCount(post.shares)
        viewsCount.text = PostService.getStringCount(post.views)
    }
}