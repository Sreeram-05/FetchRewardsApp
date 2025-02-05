package com.sreeram.fetchrewardsapp.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.sreeram.fetchrewardsapp.R
import com.sreeram.fetchrewardsapp.presentation.viewModel.FetchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListDetailScreen(
    viewModel: FetchViewModel = hiltViewModel()
) {
    val items by viewModel.items.collectAsState(emptyList())
    val isLoading by viewModel.isLoading.collectAsState(false)
    val error by viewModel.error.collectAsState(null)

    Scaffold(containerColor = MaterialTheme.colorScheme.surface, topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface),
            title = { Text(stringResource(R.string.sorted_items)) },
            navigationIcon = {})
    }) { padding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            when {
                isLoading -> LoadingIndicator()
                error != null -> error?.let { ErrorState(error = it) }
                items.isEmpty() -> EmptyState()
                else -> ItemList(items = items)
            }
        }
    }
}
