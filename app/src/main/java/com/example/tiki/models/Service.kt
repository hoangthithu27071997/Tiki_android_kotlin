package com.example.tiki.models

import com.example.tiki.R

class Service(var service: String,
              var icon: Int){

    companion object{
        fun mocks():MutableList<Service>{
            return mutableListOf(
                Service("Vé máy bay", R.drawable.ic_plane),
                Service("Mua bảo hiểm online",R.drawable.ic_plane),
                Service("Mua thẻ điện thoại",R.drawable.ic_plane),
                Service("Thẻ game",R.drawable.ic_plane)
            )
        }
    }
}