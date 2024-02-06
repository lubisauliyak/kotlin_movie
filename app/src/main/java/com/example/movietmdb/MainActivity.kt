package com.example.movietmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.movietmdb.data.APIService
import com.example.movietmdb.data.ResultsItem
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coroutineExceptionHandler =
            CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }

        val todos = listOf<ResultsItem>(
            ResultsItem(title = "Miles Films", voteAverage = 10.1),
            ResultsItem(title = "Rapi Films", voteAverage = 10.2),
            ResultsItem(title = "Starvision Plus", voteAverage = 10.3),
            ResultsItem(title = "Visinema Pictures", voteAverage = 10.4),
        )

        val rvTodos = findViewById<RecyclerView>(R.id.rv_todo)
        rvTodos.adapter = MovieListAdapter().apply {
            setNewData(todos)
        }

        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            val resp = retrofitService().getTodoList("entertainment")

            if (resp.isSuccessful) {
                val newTodoData = resp.body()?.results
                rvTodos.adapter = MovieListAdapter().apply {
                    setNewData(newTodoData.orEmpty())
                }
            }
        }
    }

    fun retrofitService(): APIService {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org")
            .build()
            .create(APIService::class.java)
    }
}