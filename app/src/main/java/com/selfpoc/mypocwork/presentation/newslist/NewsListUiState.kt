package com.selfpoc.mypocwork.presentation.newslist

import com.selfpoc.mypocwork.domain.model.NewsArticle


data class NewsListUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val articles: List<NewsArticle> = emptyList()
)
