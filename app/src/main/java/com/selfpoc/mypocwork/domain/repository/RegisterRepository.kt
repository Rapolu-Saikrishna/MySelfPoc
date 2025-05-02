package com.selfpoc.mypocwork.domain.repository

import com.selfpoc.mypocwork.domain.model.RegisterRequest
import com.selfpoc.mypocwork.domain.model.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    fun register(request: RegisterRequest): Flow<Result<RegisterResponse>>
}