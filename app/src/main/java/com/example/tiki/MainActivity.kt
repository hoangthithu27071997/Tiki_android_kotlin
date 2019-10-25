package com.example.tiki

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tiki.datasource.RetroClient
import com.example.tiki.models.Tiki
import com.example.tiki.viewmodels.TikiViewModel
import com.example.tiki.views.adapter.TikiAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: TikiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = TikiAdapter(rcvTiki)
        val mViewModel = ViewModelProviders.of(this).get(TikiViewModel::class.java)
        mViewModel.getDataTiki.observe(this, Observer<Tiki> {
            mAdapter.tiki = it
        })
        val api = RetroClient.apiService
        val call = api.keyWord()
        call.enqueue(object : Callback<MutableList<String>> {
            override fun onResponse(call: Call<MutableList<String>>, response: Response<MutableList<String>>) {
                if (response.isSuccessful) {
                    mAdapter.keyWord = response.body()
                }
            }

            override fun onFailure(call: Call<MutableList<String>>, t: Throwable) {
                Toast.makeText(this@MainActivity, resources.getString(R.string.message_erro_load_key), Toast.LENGTH_LONG).show()
            }
        })
    }
}
