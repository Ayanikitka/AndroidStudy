package com.example.androidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.androidstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.data.observe(this) { post ->
            binding.render(post)
        }
        binding.likesIcon.setOnClickListener {
            viewModel.onLikeClicked()
        }
        binding.sharesIcon.setOnClickListener {
            viewModel.onShareClicked()
        }

    }

    private fun ActivityMainBinding.render(post: Post) {
        postAuthor.text = post.author
        postDate.text = post.date
        postContent.text = post.message
        likesCount.text = PostService.getStringCount(post.likes)
        sharesCount.text = PostService.getStringCount(post.shares)
        viewsCount.text = PostService.getStringCount(post.views)
        likesIcon.setImageResource(getLikesIconImageResId(post.likedByMe))
    }

    private fun getLikesIconImageResId(liked: Boolean): Int =
        if (liked) R.drawable.ic_baseline_thumb_up_alt_red_24
        else R.drawable.ic_baseline_thumb_up_alt_24

}