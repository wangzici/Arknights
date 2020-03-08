package com.kyrie.arknights.model

import java.lang.StringBuilder

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
class Query {
    var affix = ArrayList<Long>()
    var aptitude = -1L
    var category = -1L
    var gender = -1L
    var position = -1L
    var star = -1

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        affix.forEach{
            stringBuilder.append("$it ")
        }
        if (aptitude > 0) {
            stringBuilder.append("$aptitude ")
        }
        if (category > 0) {
            stringBuilder.append("$category ")
        }
        if (gender > 0) {
            stringBuilder.append("$gender ")
        }
        if (position > 0) {
            stringBuilder.append("$position ")
        }
        if (star > 0) {
            stringBuilder.append("$star ")
        }
        return stringBuilder.toString()
    }
}