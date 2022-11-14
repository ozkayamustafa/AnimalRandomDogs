package com.mustafa.animalrandomdogs.service

import com.mustafa.animalrandomdogs.model.DogsModel
import retrofit2.http.GET

interface DogService {

    @GET("/v1/images/search")
    suspend fun getDogs():List<DogsModel>
}