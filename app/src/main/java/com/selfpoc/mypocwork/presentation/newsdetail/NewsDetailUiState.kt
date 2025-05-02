package com.selfpoc.mypocwork.presentation.newsdetail

import com.selfpoc.mypocwork.domain.model.NewsDetail

data class NewsDetailUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val detail: NewsDetail? = null
)
