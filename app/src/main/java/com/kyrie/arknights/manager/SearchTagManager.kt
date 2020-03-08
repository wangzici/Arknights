package com.kyrie.arknights.manager

import com.kyrie.arknights.model.*

/**
 * Created by Kyrie
 * Date: 2020/3/7
 *
 */
object SearchTagManager {
    private val searchResultList: MutableList<SearchResult> = ArrayList()

    fun addTag(tag: Tag): MutableList<SearchResult> {
        searchResultList.forEach {
            val searchResult = SearchResult.newInstance(it)
            when (tag) {
                is Affix -> searchResult.query.affix.add(tag.id)
                is Aptitude -> searchResult.query.aptitude = tag.id
                is Category -> searchResult.query.category = tag.id
                is Gender -> searchResult.query.gender = tag.id
                is Position -> searchResult.query.position = tag.id
            }
            DbManager.searchTag(searchResult)?.let { list ->
                searchResult.operatorList = list
            }
            searchResultList.add(searchResult)
        }
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
        searchResultList.add(searchResult)
        return searchResultList
    }

    fun removeTag(tag: Tag): MutableList<SearchResult> {
        for (index in searchResultList.size -1 downTo 0){
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
        return searchResultList
    }
}