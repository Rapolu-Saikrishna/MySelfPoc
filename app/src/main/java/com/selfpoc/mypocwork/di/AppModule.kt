package com.selfpoc.mypocwork.di

import com.selfpoc.mypocwork.data.remote.ApiService
import com.selfpoc.mypocwork.data.repository.AuthRepositoryImpl
import com.selfpoc.mypocwork.data.repository.NewsDetailRepositoryImpl
import com.selfpoc.mypocwork.data.repository.NewsRepositoryImpl
import com.selfpoc.mypocwork.data.repository.RegisterRepositoryImpl
import com.poc.mynewsapp.domain.repository.AuthRepository
import com.selfpoc.mypocwork.domain.repository.NewsDetailRepository
import com.selfpoc.mypocwork.domain.repository.NewsRepository
import com.selfpoc.mypocwork.domain.repository.RegisterRepository
import com.selfpoc.mypocwork.domain.usecase.GetNewsArticlesUseCase
import com.selfpoc.mypocwork.domain.usecase.GetNewsDetailUseCase
import com.selfpoc.mypocwork.domain.usecase.LoginUseCase
import com.selfpoc.mypocwork.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): ApiService = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/") // Replace with your actual base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(api: ApiService): AuthRepository = AuthRepositoryImpl(api)

    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase = LoginUseCase(repository)

    @Provides
    @Singleton
    fun provideRegisterRepository(api: ApiService): RegisterRepository =
        RegisterRepositoryImpl(api)

    @Provides
    fun provideRegisterUseCase(repository: RegisterRepository): RegisterUseCase =
        RegisterUseCase(repository)


    @Provides
    @Singleton
    fun provideNewsRepository(api: ApiService): NewsRepository = NewsRepositoryImpl(api)

    @Provides
    fun provideNewsUseCase(repository: NewsRepository): GetNewsArticlesUseCase =
        GetNewsArticlesUseCase(repository)

    @Provides
    @Singleton
    fun provideNewsDetailRepository(api: ApiService): NewsDetailRepository =
        NewsDetailRepositoryImpl(api)

    @Provides
    fun provideNewsDetailUseCase(repository: NewsDetailRepository): GetNewsDetailUseCase =
        GetNewsDetailUseCase(repository)
}