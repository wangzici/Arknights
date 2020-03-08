package com.kyrie.arknights.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.arknights.manager.SearchTagManager
import com.kyrie.arknights.model.Tag
import com.tencent.mars.xlog.Log

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
class TagAdapter(private val context: Context, private val tagList: List<Tag>) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    companion object{
        private const val TAG = "TagAdapter"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CheckBox(context))
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tag = tagList[position]
        holder.setText(tagList[position].name)
        holder.radioButton.setOnCheckedChangeListener { _, isChecked ->
            Log.i(TAG, "onBindViewHolder : click ${tag.name}")
            if (isChecked) {
                SearchTagManager.addTag(tagList[position])
            } else {
                SearchTagManager.removeTag(tagList[position])
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val radioButton:CheckBox = itemView as CheckBox
        fun setText(string: String){
            radioButton.text = string
        }
    }
}