package com.sreeram.fetchrewardsapp.data.repository

import com.sreeram.fetchrewardsapp.data.api.ApiService
import com.sreeram.fetchrewardsapp.data.model.Item
import com.sreeram.fetchrewardsapp.domain.repository.FetchRepository
import javax.inject.Inject


class FetchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : FetchRepository {
    override suspend fun fetchItems(): List<Item> {
        return apiService.getItems()
    }
}