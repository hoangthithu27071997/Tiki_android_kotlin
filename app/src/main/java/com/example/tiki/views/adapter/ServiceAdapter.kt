package com.example.tiki.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiki.R
import com.example.tiki.models.Service
import com.example.tiki.utils.RecyclerAdapter
import com.example.tiki.utils.RecyclerHolder
import kotlinx.android.synthetic.main.item_service.*

class ServiceAdapter(view: RecyclerView) : RecyclerAdapter<Service>(view) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        object : RecyclerHolder<Service>(p0, R.layout.item_service) {

            override fun bind(item: Service) {
                super.bind(item)
                txtNameService.text=item.service
                ivIcon.setBackgroundResource(item.icon)
            }
        }

}
