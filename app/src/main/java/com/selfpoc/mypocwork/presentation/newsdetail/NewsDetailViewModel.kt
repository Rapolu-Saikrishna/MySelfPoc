package com.selfpoc.mypocwork.presentation.newsdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selfpoc.mypocwork.domain.usecase.GetNewsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val getNewsDetailUseCase: GetNewsDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsDetailUiState())
    val uiState: StateFlow<NewsDetailUiState> = _uiState

    init {
        val articleId = savedStateHandle["id"] ?: ""
        fetchDetail(articleId)
    }

    private fun fetchDetail(id: String) {
        viewModelScope.launch {
            _uiState.value = NewsDetailUiState(isLoading = true)
            getNewsDetailUseCase(id).collect { result ->
                result.onSuccess {
                    _uiState.value = NewsDetailUiState(detail = it)
                }.onFailure {
                    _uiState.value = NewsDetailUiState(error = it.message)
                }
            }
        }
    }
}