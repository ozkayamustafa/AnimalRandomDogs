package com.mustafa.animalrandomdogs.repository

import com.mustafa.animalrandomdogs.model.DogsModel
import com.mustafa.animalrandomdogs.util.Resource

interface IDogs {
    suspend fun getDogs():Resource<List<DogsModel>>
}