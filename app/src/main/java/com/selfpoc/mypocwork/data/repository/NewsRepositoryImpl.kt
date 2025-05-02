package com.selfpoc.mypocwork.data.repository

import com.selfpoc.mypocwork.data.remote.ApiService
import com.selfpoc.mypocwork.domain.model.NewsArticle
import com.selfpoc.mypocwork.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(private val api: ApiService) : NewsRepository {
    override fun getNewsArticles(): Flow<Result<List<NewsArticle>>> = flow {
        emit(Result.success(api.getNewsArticles()))
    }.catch {
        emit(Result.failure(it))
    }
}