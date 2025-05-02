package com.selfpoc.mypocwork.domain.usecase

import com.selfpoc.mypocwork.domain.model.LoginRequest
import com.poc.mynewsapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    operator fun invoke(request: LoginRequest) = repository.login(request)
}