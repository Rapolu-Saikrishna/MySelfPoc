package com.selfpoc.mypocwork.domain.repository

import com.selfpoc.mypocwork.domain.model.LoginRequest
import com.selfpoc.mypocwork.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(request: LoginRequest): Flow<Result<LoginResponse>>
}