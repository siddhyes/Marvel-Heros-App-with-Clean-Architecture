package com.demo.marvel_heroes.utility

import com.demo.marvel_heroes.data.local.entity.Thumbnail

object CharacterUtility {
    fun getCharacterUrl(thumbnail: Thumbnail): String {
        return buildString {
            append(thumbnail.path.replace("http", "https"))
            append(".")
            append(thumbnail.extension)
        }
    }
}
