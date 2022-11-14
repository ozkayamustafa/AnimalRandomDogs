package com.mustafa.animalrandomdogs.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.animalrandomdogs.model.DogsModel
import com.mustafa.animalrandomdogs.repository.DogsRepository
import com.mustafa.animalrandomdogs.repository.IDogs
import com.mustafa.animalrandomdogs.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel
    @Inject
    constructor(
        private val repo:IDogs
    ) : ViewModel() {


        private val _dogData = MutableLiveData<DogsModel>()
        val dogsLive:LiveData<DogsModel>
                get() = _dogData

        private  val _error = MutableLiveData<String>()
        val errorLive :LiveData<String>
                get() = _error

    init {
        getDogsData()
    }
    fun getDogsData(){
            viewModelScope.launch {
                val result = repo.getDogs()
                when(result){
                    is Resource.Success->{
                        val data = result.data
                        data?.let {
                            _dogData.value = it[0]
                        }
                    }
                    is Resource.Error->{
                        _error.value = "Veri gelmedi hata oluştu"
                    }
                }
            }
    }


}