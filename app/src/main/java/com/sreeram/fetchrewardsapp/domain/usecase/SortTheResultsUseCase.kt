package com.sreeram.fetchrewardsapp.domain.usecase

import com.sreeram.fetchrewardsapp.data.model.Item
import com.sreeram.fetchrewardsapp.data.repository.FetchRepositoryImpl
import javax.inject.Inject

class SortTheResultsUseCase @Inject constructor(
    private val repository: FetchRepositoryImpl
) {
    suspend operator fun invoke(): List<Item> {
        val items = repository.fetchItems()
        return items.filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name.orEmpty() }, { it.id }))
    }
}
