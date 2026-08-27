package com.bmohan.dnd_demo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bmohan.dnd_demo.data.model.ItemResponse
import com.bmohan.dnd_demo.data.service.Open5eAPIService
import javax.inject.Inject

class ItemRepository @Inject constructor(val service: Open5eAPIService) {

    fun getItemsPaged(): Pager<Int, ItemResponse.Item> {
        return Pager(config = PagingConfig(pageSize = 20), pagingSourceFactory = {
            ItemPagingSource(service)
        })
    }
}