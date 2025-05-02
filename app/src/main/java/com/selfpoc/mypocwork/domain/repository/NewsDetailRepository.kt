package com.selfpoc.mypocwork.domain.repository

import com.selfpoc.mypocwork.domain.model.NewsDetail
import kotlinx.coroutines.flow.Flow

interface NewsDetailRepository {
    fun getNewsDetail(id: String): Flow<Result<NewsDetail>>
}