package com.kyrie.arknights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kyrie.arknights.manager.DbManager
import com.kyrie.arknights.manager.SearchTagManager
import com.kyrie.arknights.model.*
import com.tencent.mars.xlog.Log

class MainActivity : AppCompatActivity() {
    var count = 0
    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buttonOnClick(view: View) {
        val category = Category(Category.DEFENDER, "重装")
        val position = Position(Position.MELEE, "近战")
        if (count == 0) {
            val result = SearchTagManager.addTag(category)
            Log.i(TAG, "buttonOnClick : ${result.size}")
        } else if (count == 1) {
            val result = SearchTagManager.addTag(position)
            Log.i(TAG, "buttonOnClick : ${result.size}")
        } else {
            val result = SearchTagManager.removeTag(position)
            Log.i(TAG, "buttonOnClick : ${result.size}")
        }
        count++

    }
}
