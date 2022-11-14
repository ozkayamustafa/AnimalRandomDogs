package com.mustafa.animalrandomdogs.di

import com.mustafa.animalrandomdogs.repository.DogsRepository
import com.mustafa.animalrandomdogs.repository.IDogs
import com.mustafa.animalrandomdogs.service.DogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModul {

    @Singleton
    @Provides
    fun providesRepo(api:DogService):IDogs{
        return DogsRepository(api)
    }

    @Singleton
    @Provides
    fun providesRetrofit():DogService{
        return Retrofit.Builder()
            .baseUrl("https://api.thedogapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogService::class.java)
    }

}