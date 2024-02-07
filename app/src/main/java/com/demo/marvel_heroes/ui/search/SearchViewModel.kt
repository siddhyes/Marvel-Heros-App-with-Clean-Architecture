package com.demo.marvel_heroes.ui.search

import androidx.lifecycle.ViewModel
import com.demo.marvel_heroes.repository.character.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")

    fun searchCharacters(name: String) {
        _searchQuery.value = name
    }

    // Perform a live search when user types in search bar
    @OptIn(FlowPreview::class)
    val characters = _searchQuery
        .debounce(500)
        .filter { it.isNotBlank() }
        .map { characterRepository.searchCharacters(it) }
}
