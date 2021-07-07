package com.example.animeapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animeapi.api.MyRetrofitBuilder
import com.example.animeapi.model.Anime
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainViewModel : ViewModel() {
    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<String>>()
    var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllAnimes() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = MyRetrofitBuilder.apiService.getAnimes()
            withContext(Main) {
                if (response.isSuccessful) {
                    movieList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}