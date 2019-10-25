package com.example.tiki.views.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.example.tiki.R
import com.example.tiki.models.Category
import com.example.tiki.utils.RecyclerAdapter
import com.example.tiki.utils.RecyclerHolder
import kotlinx.android.synthetic.main.item_category.*

class CategoryAdapter(view: RecyclerView) : RecyclerAdapter<Category>(view) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        object : RecyclerHolder<Category>(p0, R.layout.item_category) {

            override fun bind(item: Category) {
                super.bind(item)
                txtName.text=item.category
            }
        }

}
