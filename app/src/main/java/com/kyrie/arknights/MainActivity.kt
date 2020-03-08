package com.kyrie.arknights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyrie.arknights.adapter.DataAdapter
import com.kyrie.arknights.adapter.TagAdapter
import com.kyrie.arknights.manager.DbManager
import com.kyrie.arknights.manager.SearchTagManager
import com.kyrie.arknights.model.*
import com.kyrie.arknights.ui.FlowLayoutManager
import com.tencent.mars.xlog.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,SearchTagManager.SearchListener{
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        SearchTagManager.registerListener(this)
    }

    private fun initView() {
        rv_affix.layoutManager = FlowLayoutManager(this, true)
        rv_aptitude.layoutManager = FlowLayoutManager(this, true)
        rv_category.layoutManager = FlowLayoutManager(this, true)
        rv_position.layoutManager = FlowLayoutManager(this, true)
        rv_data.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val affixList = DbManager.queryAffix()
        affixList?.let { rv_affix.adapter = TagAdapter(this, it.toList()) }
        val aptitudeList = DbManager.queryAptitude()
        aptitudeList?.let { rv_aptitude.adapter = TagAdapter(this, it.toList()) }
        val categoryList = DbManager.queryCategory()
        categoryList?.let { rv_category.adapter = TagAdapter(this, it.toList()) }
        val positionList = DbManager.queryPosition()
        positionList?.let { rv_position.adapter = TagAdapter(this, it.toList()) }
        //目前没有性别
/*        val genderList = DbManager.queryGender()
        genderList?.let { rv_affix.adapter = TagAdapter(this, it.toList()) }*/
    }

    override fun onSearchSuccess(searchResultList: List<SearchResult>) {
        rv_data.adapter = DataAdapter(this, searchResultList)
    }

    fun clearClick(view: View) {
        initView()
        SearchTagManager.clear()
    }
}
