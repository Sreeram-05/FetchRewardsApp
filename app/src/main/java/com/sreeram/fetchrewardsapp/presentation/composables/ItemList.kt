package com.sreeram.fetchrewardsapp.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sreeram.fetchrewardsapp.data.model.Item
import com.sreeram.fetchrewardsapp.presentation.theme.FetchRewardsAppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemList(items: List<Item>) {
    val groupedItems = items.groupBy { it.listId }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        groupedItems.forEach { (listId, itemList) ->
            stickyHeader {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "List ID: $listId",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            items(itemList) { item ->
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Item",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.name ?: "",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            item {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, name = "Loading Indicator")
@Composable
fun LoadingIndicatorPreview() {
    FetchRewardsAppTheme {
        LoadingIndicator()
    }
}

@Preview(showBackground = true, name = "Error State")
@Composable
fun ErrorStatePreview() {
    FetchRewardsAppTheme {
        ErrorState(error = "Network error")
    }
}

@Preview(showBackground = true, name = "Empty State")
@Composable
fun EmptyStatePreview() {
    FetchRewardsAppTheme {
        EmptyState()
    }
}

@Preview(showBackground = true, name = "Item List")
@Composable
fun ItemListPreview() {
    val mockItems = listOf(
        Item(1, 1, "Item 1"),
        Item(2, 1, "Item 2"),
        Item(3, 2, "Item 3")
    )
    FetchRewardsAppTheme {
        ItemList(items = mockItems)
    }
}