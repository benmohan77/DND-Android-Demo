package com.bmohan.dnd_demo.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bmohan.dnd_demo.data.model.ItemResponse
import com.bmohan.dnd_demo.data.service.Open5eAPIService

class ItemPagingSource(
    val service: Open5eAPIService,
): PagingSource<Int, ItemResponse.Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemResponse.Item> {
        val nextPageNumber = params.key ?: 1

        val response = service.getItems(page = nextPageNumber)
        return if(response.isSuccessful) {
            LoadResult.Page(data = response.body()!!.results!!, null, nextKey = nextPageNumber + 1)
        } else {
            LoadResult.Error(Exception(response.errorBody()?.string()))
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ItemResponse.Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}