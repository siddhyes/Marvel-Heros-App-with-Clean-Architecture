package com.demo.marvel_heroes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.demo.marvel_heroes.data.local.entity.ComicCharacterEntity
import com.demo.marvel_heroes.repository.character.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    val comicCharacters: Flow<PagingData<ComicCharacterEntity>> = characterRepository
        .getAllComicCharacters()
        .cachedIn(viewModelScope)
}
