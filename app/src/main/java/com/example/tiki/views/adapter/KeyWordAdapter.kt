package com.example.tiki.views.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.tiki.R
import com.example.tiki.utils.RecyclerAdapter
import com.example.tiki.utils.RecyclerHolder
import kotlinx.android.synthetic.main.item_keyword.*
import kotlin.collections.ArrayList


class KeyWordAdapter(view: RecyclerView) : RecyclerAdapter<String>(view) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        object : RecyclerHolder<String>(p0, R.layout.item_keyword) {

            override fun bind(item: String) {
                super.bind(item)
                txtName.text = handleKeyword(item)
//                You should return the icon with json
//                so I have to assign the default icon to the app
                when(adapterPosition%2==0){
                    true->txtName.setBackgroundResource(R.drawable.bg_green)
                    else->txtName.setBackgroundResource(R.drawable.bg_blue_pink_1)
                }
            }
        }

    fun handleKeyword(keyword: String): String {
        val value = keyword.trim()
        if (!value.contains(" "))
            return keyword
        val spaces = ArrayList<Int>()
        for (i in 0 until value.length) {
            if (value[i].toInt() == 32) {
                spaces.add(i)
            }
        }
        var min = spaces[0]
        var minIndex = value.length / 2 - spaces[0]
        for (i in 1 until spaces.size) {
            var to = value.length / 2 - spaces[i]
            if (to < 0) to *= -1
            if (minIndex > to) {
                min = spaces[i]
                minIndex = to
            }
        }
        return StringBuffer(value).insert(min, "\n").toString()
    }

}
