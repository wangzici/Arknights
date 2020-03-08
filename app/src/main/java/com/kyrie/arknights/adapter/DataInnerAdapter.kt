package com.kyrie.arknights.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.arknights.model.Operator
import com.kyrie.arknights.model.SearchResult

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
class DataInnerAdapter(private val context: Context, private val operatorList: List<Operator>) : RecyclerView.Adapter<DataInnerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(context))
    }

    override fun getItemCount(): Int {
        return operatorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val operator = operatorList[position]
        holder.textView.text = operator.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView as TextView
    }
}