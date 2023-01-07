package com.example.api_calling.Activity

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api_calling.R
import com.example.api_calling.Api.ApiAdapter
import com.example.api_calling.Api.Apiclient
import com.example.api_calling.Api.Apiinterface
import com.example.apicalling.Retrofit.RetroApiModelItem
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    lateinit var pgsBar: ProgressBar

    //    val Post_Api = "https://reqres.in/api/users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        var RecyclerView = findViewById<RecyclerView>(R.id.rv_view)
        val pgsBar = findViewById<ProgressBar>(R.id.pBar)

        button.setOnClickListener {

            pgsBar.visibility = VISIBLE

            val apiInterface = Apiclient().getRetrofit().create(Apiinterface::class.java)
            apiInterface.getProduct().enqueue(object : Callback<List<RetroApiModelItem>> {
                override fun onResponse(
                    call: Call<List<RetroApiModelItem>>,
                    response: retrofit2.Response<List<RetroApiModelItem>>,
                ) {
                    var list = response.body()!!
                    Log.e("TAG", "onResponse: ${list.size}")
                    Adapter(list)
                    Toast.makeText(this@MainActivity,"su++++++++++++++++++++++",Toast.LENGTH_SHORT).show()
                    pgsBar.visibility = GONE;
                }
                override fun onFailure(call: Call<List<RetroApiModelItem>>, t: Throwable) {
                    Log.e("TAG", "onFailure : ${t.message}")
                }
            })
        }
    }



    fun Adapter(list: List<RetroApiModelItem>) {

        val rvview = findViewById<RecyclerView>(R.id.rv_view)


        val adapter = ApiAdapter(this, list)
        val layoutManager = LinearLayoutManager(this)
        rvview.adapter = adapter
        rvview.layoutManager = layoutManager
    }
}

