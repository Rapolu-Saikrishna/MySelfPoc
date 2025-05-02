package com.selfpoc.mypocwork.domain.repository

import com.selfpoc.mypocwork.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNewsArticles(): Flow<Result<List<NewsArticle>>>
}