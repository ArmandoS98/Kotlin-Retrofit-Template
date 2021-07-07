package com.example.animeapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.animeapi.api.MyRetrofitBuilder
import com.example.animeapi.model.Anime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.movieList.observe(this, {
            Log.d(TAG, "onCreate: ${it[0]}")
        })

        viewModel.errorMessage.observe(this, {
            Log.e(TAG, "onCreate: $it")
        })

        viewModel.loading.observe(this, {
            Log.d(TAG, "onCreate: $it")
        })

        viewModel.getAllAnimes()

        Log.d(TAG, "onCreate: Llego hasta aqui")
    }

}

