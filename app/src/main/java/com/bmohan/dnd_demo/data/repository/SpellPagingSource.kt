package com.bmohan.dnd_demo.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bmohan.dnd_demo.data.service.Open5eAPIService
import com.bmohan.dnd_demo.ui.model.Spell
import com.bmohan.dnd_demo.ui.model.toSpell

class SpellPagingSource(
    val service: Open5eAPIService,
) : PagingSource<Int, Spell>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Spell> {
        val nextPageNumber = params.key ?: 1

        val response = service.getSpells(limit = params.loadSize, page = nextPageNumber)
        return if(response.isSuccessful) {
            LoadResult.Page(data = response.body()!!.results!!.map { it!!.toSpell() }, null, nextKey = nextPageNumber + 1)
        } else {
            LoadResult.Error(Exception(response.errorBody()?.string()))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Spell>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}