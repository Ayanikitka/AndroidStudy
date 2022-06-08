package com.example.androidstudy

object PostService {

    public fun getStringCount (count: Int): String {
        return when {
            (count <= 999) -> count.toString()
            (count in 1_000..9_999 && count % 1000 < 100) ->
                (count / 1000).toString() + "K"
            (count in 1_000..9_999 && count % 1000 >= 100) ->
                (count / 1000).toString() + "." + ((count % 1000) / 100).toString() + "K"
            (count in 10_000..999_999) -> (count / 1000).toString() + "K"
            (count >= 1_000_000 && count % 1_000_000 < 100_000) ->
                (count / 1_000_000).toString() + "M"
            else -> (count / 1_000_000).toString() +
                    "." + ((count % 1_000_000) / 100_000).toString() + "M"
        }
    }


}