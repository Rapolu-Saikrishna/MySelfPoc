package com.selfpoc.mypocwork.domain.usecase

import com.selfpoc.mypocwork.domain.repository.NewsRepository

class GetNewsArticlesUseCase(private val repository: NewsRepository) {
    operator fun invoke() = repository.getNewsArticles()
}