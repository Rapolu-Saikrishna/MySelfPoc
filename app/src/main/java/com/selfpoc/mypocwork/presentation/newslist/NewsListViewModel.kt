package com.selfpoc.mypocwork.presentation.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selfpoc.mypocwork.domain.usecase.GetNewsArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsArticlesUseCase: GetNewsArticlesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsListUiState())
    val uiState: StateFlow<NewsListUiState> = _uiState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _uiState.value = NewsListUiState(isLoading = true)
            getNewsArticlesUseCase().collect { result ->
                result.onSuccess {
                    _uiState.value = NewsListUiState(articles = it)
                }.onFailure {
                    _uiState.value = NewsListUiState(error = it.message)
                }
            }
        }
    }
}