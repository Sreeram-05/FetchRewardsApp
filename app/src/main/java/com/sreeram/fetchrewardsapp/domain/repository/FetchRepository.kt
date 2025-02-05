package com.sreeram.fetchrewardsapp.domain.repository

import com.sreeram.fetchrewardsapp.data.model.Item

interface FetchRepository {
    suspend fun fetchItems(): List<Item>
}