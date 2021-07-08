package com.example.animeapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        //Instaciando Retrofit
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.movieList.observe(this, { name ->



            Log.d(
                TAG, "onCreate: ${
                    name.forEach {
                        println(it)
                    }
                }"
            )
        })

        viewModel.errorMessage.observe(this, {
            Log.e(TAG, "onCreate: $it")
            Toast.makeText(this, "Error: $it", Toast.LENGTH_LONG).show()
        })

        viewModel.loading.observe(this, {
            //Se coloca codigo de animacion aqui
            if (it){

            }else{

            }
        })

        viewModel.getAllAnimes()
    }

}

