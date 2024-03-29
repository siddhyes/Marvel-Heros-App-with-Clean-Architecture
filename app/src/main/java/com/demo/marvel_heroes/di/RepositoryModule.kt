package com.demo.marvel_heroes.di

import com.demo.marvel_heroes.repository.bookmark.BookmarkRepository
import com.demo.marvel_heroes.repository.bookmark.BookmarkRepositoryImpl
import com.demo.marvel_heroes.repository.character.CharacterRepository
import com.demo.marvel_heroes.repository.character.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    abstract fun bindBookmarkRepository(bookmarkRepositoryImpl: BookmarkRepositoryImpl): BookmarkRepository
}
