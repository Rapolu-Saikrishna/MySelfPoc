package com.selfpoc.mypocwork.data.repository

import com.selfpoc.mypocwork.data.remote.ApiService
import com.selfpoc.mypocwork.domain.model.LoginRequest
import com.selfpoc.mypocwork.domain.model.LoginResponse
import com.poc.mynewsapp.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(private val api: ApiService) : AuthRepository {
    override fun login(request: LoginRequest): Flow<Result<LoginResponse>> = flow {
        val response = api.login(request)
        emit(Result.success(response))
    }.catch { e ->
        emit(Result.failure(e))
    }
}