package com.selfpoc.mypocwork.domain.usecase

import com.selfpoc.mypocwork.domain.repository.NewsDetailRepository

class GetNewsDetailUseCase(private val repository: NewsDetailRepository) {
    operator fun invoke(id: String) = repository.getNewsDetail(id)
}