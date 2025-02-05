package com.sreeram.fetchrewardsapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Int? = null,
    val listId: Int? = null,
    val name: String? = null
) : Parcelable
