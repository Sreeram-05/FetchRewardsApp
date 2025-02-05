package com.sreeram.fetchrewardsapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sreeram.fetchrewardsapp.data.model.Item
import com.sreeram.fetchrewardsapp.domain.usecase.SortTheResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FetchViewModel @Inject constructor(
    private val sortTheResultsUseCase: SortTheResultsUseCase,
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> get() = _items.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _items.value = sortTheResultsUseCase.invoke()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.localizedMessage
            } finally {
                _loading.value = false
            }
        }
    }
}
