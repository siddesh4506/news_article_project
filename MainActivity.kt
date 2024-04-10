package com.example.articlesdemo

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()
    }

    fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Data>>{
            override fun onResponse(
                call: Call<List<Data>>,
                response: Response<List<Data>>
            ) {
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply{
                        myAdapter = MyAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = myAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}

