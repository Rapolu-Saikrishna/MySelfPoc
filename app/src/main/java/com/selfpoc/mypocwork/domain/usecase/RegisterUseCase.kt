package com.selfpoc.mypocwork.domain.usecase

import com.selfpoc.mypocwork.domain.model.RegisterRequest
import com.selfpoc.mypocwork.domain.repository.RegisterRepository

class RegisterUseCase(private val repository: RegisterRepository) {
    operator fun invoke(request: RegisterRequest) = repository.register(request)
}