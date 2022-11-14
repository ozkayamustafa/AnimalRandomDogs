package com.mustafa.animalrandomdogs.repository

import com.mustafa.animalrandomdogs.model.DogsModel
import com.mustafa.animalrandomdogs.service.DogService
import com.mustafa.animalrandomdogs.util.Resource
import javax.inject.Inject

class DogsRepository
@Inject
constructor(
    private val api:DogService
) :IDogs {
    override suspend fun getDogs(): Resource<List<DogsModel>> {
        val response =  try {
            api.getDogs()
        }catch (e:Exception){
            return  Resource.Error("Hata")
        }
        return Resource.Success(response)
    }
}