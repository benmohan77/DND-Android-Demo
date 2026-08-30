package com.bmohan.dnd_demo.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.bmohan.dnd_demo.data.service.Open5eAPIService
import com.bmohan.dnd_demo.ui.model.Spell
import javax.inject.Inject

class SpellRepository @Inject constructor(val service: Open5eAPIService) {
    fun getSpellsPaged(): Pager<Int, Spell> {
        return Pager(config = PagingConfig(pageSize = 50, prefetchDistance = 100, initialLoadSize = 150), pagingSourceFactory = {
            SpellPagingSource(service)
        })
    }
}