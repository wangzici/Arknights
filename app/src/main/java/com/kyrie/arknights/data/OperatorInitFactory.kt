package com.kyrie.arknights.data

import com.kyrie.arknights.manager.DbManager
import com.kyrie.arknights.model.*
import com.tencent.mars.xlog.Log

class OperatorInitFactory {
    companion object {
        fun initialize() {
            val operator1 = Operator()
            operator1.star = 4
            operator1.name = "角峰"
            operator1.imgSmall = -1
            operator1.position = Position.MELEE
            operator1.aptitude = Aptitude.SENIOR
            operator1.category = Category.DEFENDER
            operator1.affixList = listOf(Affix.DEFENSE)
            val operator2 = Operator()
            operator2.name = "火神2"
            operator2.star = 5
            operator2.imgSmall = -1
            operator2.aptitude = Aptitude.SENIOR
            operator2.category = Category.DEFENDER
            operator2.affixList = listOf(Affix.DEFENSE, Affix.SURVIVAL, Affix.DPS)
            operator2.position = Position.RANGED
            DbManager.insert(listOf(operator1, operator2))
            Log.i("wzt","save success")

        }
    }
}