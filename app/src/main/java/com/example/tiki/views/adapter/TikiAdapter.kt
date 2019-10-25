package com.example.tiki.views.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiki.R
import com.example.tiki.extension.AppExecutors
import com.example.tiki.models.Tiki
import com.example.tiki.utils.RecyclerHolder
import com.example.tiki.utils.ScrollRecyclerAdapter
import kotlinx.android.synthetic.main.item_parent_category.*
import kotlinx.android.synthetic.main.item_parent_keyword.*
import kotlinx.android.synthetic.main.item_parent_service.*
import java.util.*

class TikiAdapter(view: RecyclerView) : ScrollRecyclerAdapter(view) {

    companion object {
        const val TYPE_CATEGORY = 1
        const val TYPE_SERVICE = 2
        const val TYPE_ADVERTISEMENT = 3
        const val TYPE_KEYWORD = 4
        const val TYPE_SIGNIN = 5
        const val TYPE_TIKI_DEAL = 6
    }

    init {
        view.adapter = this
    }

    var tiki: Tiki? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var keyWord: MutableList<String>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getOrderSize(order: Int): Int {
        return super.getOrderSize(order)
    }

    override fun getOrderRealSize(order: Int): Int {
        if ((order == TYPE_ADVERTISEMENT || order == TYPE_SIGNIN
                    || order == TYPE_TIKI_DEAL
                    || order == TYPE_CATEGORY
                    || order == TYPE_SERVICE
                    || order == TYPE_KEYWORD) && tiki == null
        ) return 0
        return super.getOrderRealSize(order)
    }

    override fun getOrders() = TYPE_CATEGORY..TYPE_TIKI_DEAL

    override fun onBindListViewHolder(p0: RecyclerView.ViewHolder, positionInList: Int) {
    }

    override fun onBindSingleViewHolder(p0: RecyclerView.ViewHolder, order: Int) {
        when (p0) {
            is CategoryHolder -> tiki?.apply(p0::bind)
            is ServiceHolder -> tiki?.apply(p0::bind)
            is AdvertisementHolder -> tiki?.apply(p0::bind)
            is KeywordHolder -> keyWord?.apply(p0::bind)
            is SigInHolder -> tiki?.apply(p0::bind)
            is TikiDeal -> tiki?.apply(p0::bind)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int) = when (viewType) {
        TYPE_CATEGORY -> CategoryHolder(p0)
        TYPE_SERVICE -> ServiceHolder(p0)
        TYPE_ADVERTISEMENT -> AdvertisementHolder(p0)
        TYPE_KEYWORD -> KeywordHolder(p0)
        TYPE_SIGNIN -> SigInHolder(p0)
        else -> TikiDeal(p0)
    }

    inner class CategoryHolder(view: ViewGroup) : RecyclerHolder<Tiki>(view, R.layout.item_parent_category) {

        private var mAdapter = CategoryAdapter(rcvCategory)
        override fun bind(item: Tiki) {
            super.bind(item)
            mAdapter.items = item.category
        }
    }

    inner class ServiceHolder(view: ViewGroup) : RecyclerHolder<Tiki>(view, R.layout.item_parent_service) {

        private var mAdapter = ServiceAdapter(rcvService)
        override fun bind(item: Tiki) {
            super.bind(item)
            mAdapter.items = item.service
        }
    }

    inner class SigInHolder(view: ViewGroup) : RecyclerHolder<Tiki>(view, R.layout.item_sigin)

    inner class AdvertisementHolder(view: ViewGroup) : RecyclerHolder<Tiki>(view, R.layout.item_advertisement)

    inner class KeywordHolder(view: ViewGroup) : RecyclerHolder<MutableList<String>>(view, R.layout.item_parent_keyword) {

        private var mAdapter = KeyWordAdapter(rcvKeyword)
        override fun bind(item: MutableList<String>) {
            super.bind(item)
            mAdapter.items = item
            autoSlide(item.size)
        }

        private fun autoSlide(size: Int) {
            var currentPage = 0
            var mTimer: Timer? = null
            mTimer?.cancel()
            mTimer = Timer()
            mTimer.schedule(object : TimerTask() {
                override fun run() {
                    if (currentPage == size - 1) {
                        currentPage = 0
                        AppExecutors.onUI { rcvKeyword.smoothScrollToPosition(0) }
                    } else {
                        AppExecutors.onUI { rcvKeyword.smoothScrollToPosition(currentPage + 1) }
                        currentPage++
                    }
                }
            }, 100, 1000)
        }
    }


    inner class TikiDeal(view: ViewGroup) : RecyclerHolder<Tiki>(view, R.layout.item_tiki_deal)
}

