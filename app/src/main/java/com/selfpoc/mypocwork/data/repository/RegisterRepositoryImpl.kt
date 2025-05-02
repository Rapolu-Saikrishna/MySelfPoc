package com.selfpoc.mypocwork.data.repository

import com.selfpoc.mypocwork.data.remote.ApiService
import com.selfpoc.mypocwork.domain.model.RegisterRequest
import com.selfpoc.mypocwork.domain.model.RegisterResponse
import com.selfpoc.mypocwork.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class RegisterRepositoryImpl(private val api: ApiService) : RegisterRepository {
    override fun register(request: RegisterRequest): Flow<Result<RegisterResponse>> = flow {
        val response = api.register(request)
        emit(Result.success(response))
    }.catch {
        emit(Result.failure(it))
    }
}