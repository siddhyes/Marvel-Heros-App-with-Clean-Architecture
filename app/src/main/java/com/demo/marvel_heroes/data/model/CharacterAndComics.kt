package com.demo.marvel_heroes.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.demo.marvel_heroes.data.local.entity.ComicCharacterEntity
import com.demo.marvel_heroes.data.local.entity.ComicsEntity

/**
 * An intermediate representation to retrieve ComicCharacter and Comics combined
 * as they're separate entities in the database.
 */
data class CharacterAndComics(
    @Embedded
    val character: ComicCharacterEntity,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "characterId"
    )
    val comic: ComicsEntity
)
