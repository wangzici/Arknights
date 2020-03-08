package com.kyrie.arknights.manager

import com.kyrie.arknights.model.*
import java.lang.ref.WeakReference

/**
 * Created by Kyrie
 * Date: 2020/3/7
 *
 */
object SearchTagManager {
    private var searchResultList: MutableList<SearchResult> = ArrayList()
    private var searchListener : WeakReference<SearchListener>? = null

    fun addTag(tag: Tag) {
        val newSearchResultList: MutableList<SearchResult> = ArrayList()
        searchResultList.forEach {
            if(it.operatorList.isNotEmpty()) newSearchResultList.add(it)
            val searchResult = SearchResult.newInstance(it)
            when (tag) {
                is Affix -> searchResult.query.affix.add(tag.id)
                is Aptitude -> {
                    //之前已经选择过新手，再选择资深干员则不用再合并搜索
                    if (searchResult.query.aptitude > 0) return@forEach
                    searchResult.query.aptitude = tag.id
                }
                is Category -> {
                    if (searchResult.query.category > 0) return@forEach
                    searchResult.query.category = tag.id
                }
                is Gender -> {
                    if (searchResult.query.gender > 0) return@forEach
                    searchResult.query.gender = tag.id
                }
                is Position -> {
                    if (searchResult.query.position > 0) return@forEach
                    searchResult.query.position = tag.id}

            }
            DbManager.searchTag(searchResult)?.let { list ->
                searchResult.operatorList = list
            }
            newSearchResultList.add(searchResult)
        }
        searchResultList = newSearchResultList
        val query = Query()
        when (tag) {
            is Affix -> query.affix.add(tag.id)
            is Aptitude -> query.aptitude = tag.id
            is Category -> query.category = tag.id
            is Gender -> query.gender = tag.id
            is Position -> query.position = tag.id
        }
        val searchResult = SearchResult(query)
        DbManager.searchTag(searchResult)?.let { list ->
            searchResult.operatorList = list
        }
        if (searchResult.operatorList.isNotEmpty()) {
            searchResultList.add(searchResult)
        }
        searchListener?.get()?.onSearchSuccess(searchResultList)
    }

    fun removeTag(tag: Tag) {
        for (index in searchResultList.size - 1 downTo 0) {
            val searchResult = searchResultList[index]

            val needDelete = when (tag) {
                is Affix -> searchResult.query.affix.contains(tag.id)
                is Aptitude -> searchResult.query.aptitude == tag.id
                is Category -> searchResult.query.category == tag.id
                is Gender -> searchResult.query.gender == tag.id
                is Position -> searchResult.query.position == tag.id
                else -> false
            }
            if (needDelete) {
                searchResultList.removeAt(index)
            }
        }
        searchListener?.get()?.onSearchSuccess(searchResultList)
    }

    fun clear() {
        searchResultList = ArrayList()
    }

    fun registerListener(searchListener: SearchListener) {
        this.searchListener = WeakReference(searchListener)
    }

    interface SearchListener{
        fun onSearchSuccess(searchResultList: List<SearchResult>)
    }
}