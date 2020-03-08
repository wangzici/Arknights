package com.kyrie.arknights.model

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
data class SearchResult(var query: Query){
    companion object{
        fun newInstance(searchResult: SearchResult): SearchResult {
            val query = Query()
            query.category = searchResult.query.category
            query.aptitude = searchResult.query.aptitude
            query.gender = searchResult.query.gender
            query.position = searchResult.query.position
            query.affix.addAll(searchResult.query.affix)
            return SearchResult(query)
        }
    }
    var operatorList: MutableList<Operator> = ArrayList()
}