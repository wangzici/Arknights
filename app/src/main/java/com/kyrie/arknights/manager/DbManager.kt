package com.kyrie.arknights.manager

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.kyrie.arknights.data.DatabaseInitFactory
import com.kyrie.arknights.model.*
import com.litesuits.orm.LiteOrm
import com.litesuits.orm.db.DataBaseConfig
import com.litesuits.orm.db.assit.QueryBuilder
import com.litesuits.orm.db.assit.SQLiteHelper
import java.util.ArrayList

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
object DbManager{
    private const val TAG = "DbManager"
    private var application: Application? = null
    private var liteOrm: LiteOrm? = null
    private val onUpdateListener = object  : SQLiteHelper.OnUpdateListener{
        override fun onCreate(db: SQLiteDatabase?) {
            Log.i(TAG, "onCreate")
            application?.let { Handler(Looper.getMainLooper()).postDelayed({ DatabaseInitFactory.initialize(it) }, 500) }
        }

        override fun onUpdate(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            Log.i(TAG, "oldVersion = $oldVersion;newVersion = $newVersion")
            //清空数据库
            db?.execSQL("DROP TABLE IF EXISTS operator")
            db?.execSQL("DROP TABLE IF EXISTS affix")
            db?.execSQL("DROP TABLE IF EXISTS aptitude")
            db?.execSQL("DROP TABLE IF EXISTS category")
            db?.execSQL("DROP TABLE IF EXISTS gender")
            db?.execSQL("DROP TABLE IF EXISTS position")
            application?.let { Handler(Looper.getMainLooper()).postDelayed({ DatabaseInitFactory.initialize(it) }, 500) }
        }
    }
    fun init(application: Application) {
        this.application = application
        val dataBaseConfig = DataBaseConfig(application, "arknights", true, 1, onUpdateListener)
        liteOrm = LiteOrm.newCascadeInstance(dataBaseConfig)
    }

    fun searchTag(searchResult: SearchResult): ArrayList<Operator>? {
        val queryBuilder = QueryBuilder(Operator::class.java)
        var hasPre = false
/*        searchResult.query.affix.forEach {
            queryBuilder.whereIn("affix", it)
            hasPre = true
        }*/
        if (searchResult.query.aptitude > 0) {
            checkWhereAppend(queryBuilder, hasPre)
            hasPre = true
            queryBuilder.whereEquals("aptitude", searchResult.query.aptitude)
        }
        if (searchResult.query.category > 0) {
            checkWhereAppend(queryBuilder, hasPre)
            hasPre = true
            queryBuilder.whereEquals("category", searchResult.query.category)
        }
        if (searchResult.query.gender > 0) {
            checkWhereAppend(queryBuilder, hasPre)
            hasPre = true
            queryBuilder.whereEquals("gender", searchResult.query.gender)
        }
        if (searchResult.query.position > 0) {
            checkWhereAppend(queryBuilder, hasPre)
            hasPre = true
            queryBuilder.whereEquals("position", searchResult.query.position)
        }
        if (searchResult.query.star > 0) {
            checkWhereAppend(queryBuilder, hasPre)
            hasPre = true
            queryBuilder.whereEquals("star", searchResult.query.star)
        }
        return liteOrm?.query(queryBuilder)
    }

    private fun checkWhereAppend(queryBuilder: QueryBuilder<Operator>, hasPre: Boolean) {
        if (hasPre) {
            queryBuilder.whereAppendAnd()
        }
    }

    fun insert(operator: Operator) {
        liteOrm?.insert(operator)
    }

    fun insert(operatorList: List<Operator>) {
        liteOrm?.insert(operatorList)
    }

    fun insertTag(tagList: List<Tag>) {
        liteOrm?.insert(tagList)
    }

    fun queryAll() : ArrayList<Operator>?{
        return liteOrm?.query(Operator::class.java)
    }

    fun queryAptitude(): ArrayList<Aptitude>? {
        return liteOrm?.query(Aptitude::class.java)
    }

    fun queryCategory(): ArrayList<Category>? {
        return liteOrm?.query(Category::class.java)
    }

    fun queryGender(): ArrayList<Gender>? {
        return liteOrm?.query(Gender::class.java)
    }

    fun queryPosition(): ArrayList<Position>? {
        return liteOrm?.query(Position::class.java)
    }

    fun queryAffix(): ArrayList<Affix>? {
        return liteOrm?.query(Affix::class.java)
    }
}