package com.selfpoc.mypocwork.data.repository

import com.selfpoc.mypocwork.data.remote.ApiService
import com.selfpoc.mypocwork.domain.model.NewsDetail
import com.selfpoc.mypocwork.domain.repository.NewsDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class NewsDetailRepositoryImpl(private val api: ApiService) : NewsDetailRepository {
    override fun getNewsDetail(id: String): Flow<Result<NewsDetail>> = flow {
        emit(Result.success(api.getNewsDetail(id)))
    }.catch {
        emit(Result.failure(it))
    }
}