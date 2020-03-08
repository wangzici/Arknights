package com.kyrie.arknights.data

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.kyrie.arknights.manager.DbManager
import com.kyrie.arknights.model.*
import com.tencent.mars.xlog.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.StringBuilder

class DatabaseInitFactory {
    companion object {
        private const val TAG = "DatabaseInitFactory"

        fun initialize(application: Application) {

            val affixList = Gson().fromJson<List<Affix>>(getJsonFromAssets(application, "affix.json"))
            DbManager.insertTag(affixList)
            Log.i(TAG, "initialize : Affix success")
            val categoryList = Gson().fromJson<List<Category>>(getJsonFromAssets(application, "category.json"))
            DbManager.insertTag(categoryList)
            Log.i(TAG, "initialize : Category success")
            val aptitudeList = Gson().fromJson<List<Aptitude>>(getJsonFromAssets(application, "aptitude.json"))
            DbManager.insertTag(aptitudeList)
            Log.i(TAG, "initialize : Aptitude success")
            val genderList = Gson().fromJson<List<Gender>>(getJsonFromAssets(application, "gender.json"))
            DbManager.insertTag(genderList)
            Log.i(TAG, "initialize : Gender success")
            val positionList = Gson().fromJson<List<Position>>(getJsonFromAssets(application, "position.json"))
            DbManager.insertTag(positionList)
            Log.i(TAG, "initialize : Position success")

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

        private fun getJsonFromAssets(context: Context, fileName: String): String {
            val stringBuilder = StringBuilder()
            try {
                //获取assets资源管理器
                val assetManager = context.assets
                //通过管理器打开文件并读取
                val bf = BufferedReader(InputStreamReader(assetManager.open(fileName)))
                while(true){
                    val line = bf.readLine()
                    if (line != null) {
                        stringBuilder.append(line)
                        continue
                    }
                    break
                }
            } catch (e : IOException) {
                e.printStackTrace()
            }
            return stringBuilder.toString()
        }
    }
}