package com.demo.marvel_heroes.ui.detail

import com.demo.marvel_heroes.data.model.CharacterAndComics

/**
 * Sealed class to represent UI states in [CharacterDetailScreen]
 */
sealed interface CharacterDetailsScreenUiState {
    data object Initial : CharacterDetailsScreenUiState
    data object Loading : CharacterDetailsScreenUiState
    data class Success(val characterAndComic: CharacterAndComics) : CharacterDetailsScreenUiState
    data class Error(val msg: String) : CharacterDetailsScreenUiState
}
