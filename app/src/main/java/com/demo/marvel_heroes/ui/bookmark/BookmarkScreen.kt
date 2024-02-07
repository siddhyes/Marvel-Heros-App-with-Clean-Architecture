package com.demo.marvel_heroes.ui.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.demo.marvel_heroes.R
import com.demo.marvel_heroes.data.local.entity.ComicCharacterEntity
import com.demo.marvel_heroes.ui.components.ComicCharactersGridView
import com.demo.marvel_heroes.ui.components.TopAppBarWithBackButton

@Composable
fun BookmarkRoute(
    bookmarkViewModel: BookmarkViewModel = hiltViewModel(),
    onCharacterClick: (ComicCharacterEntity) -> Unit,
    onBackClick: () -> Unit,
) {
    val bookmarkedCharacters by bookmarkViewModel.bookmarkedCharacters.collectAsState()

    LaunchedEffect(key1 = Unit) {
        bookmarkViewModel.getAllBookmarkedCharacters()
    }

    BookmarkScreen(
        characters = bookmarkedCharacters,
        onCharacterClick = onCharacterClick,
        onBackClick = onBackClick
    )
}

@Composable
fun BookmarkScreen(
    characters: List<ComicCharacterEntity>,
    onCharacterClick: (ComicCharacterEntity) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarWithBackButton(
                title = stringResource(R.string.bookmark),
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ComicCharactersGridView(
                characters = characters,
                onClick = onCharacterClick
            )
        }
    }
}
