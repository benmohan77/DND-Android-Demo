package com.bmohan.dnd_demo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bmohan.dnd_demo.data.service.Open5eAPIService
import com.bmohan.dnd_demo.ui.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(val service: Open5eAPIService) {

    fun getItemsPaged(): Pager<Int, Item> {
        return Pager(config = PagingConfig(pageSize = 50, prefetchDistance = 25), pagingSourceFactory = {
            ItemPagingSource(service)
        })
    }
}