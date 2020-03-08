package com.kyrie.arknights.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyrie.arknights.R
import com.kyrie.arknights.model.SearchResult
import com.kyrie.arknights.ui.FlowLayoutManager
import kotlinx.android.synthetic.main.layout_data_parent.view.*

/**
 * Created by Kyrie
 * Date: 2020/3/8
 *
 */
class DataAdapter(private val context: Context, private val searchResultList: List<SearchResult>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_data_parent, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchResultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val searchResult = searchResultList[position]
        holder.tvTitle.text = searchResult.query.toString()
        holder.rvOperator.adapter = DataInnerAdapter(context, searchResult.operatorList)
        holder.rvOperator.layoutManager = FlowLayoutManager(context, true)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvOperator: RecyclerView = itemView.rv_operator
        val tvTitle: TextView = itemView.tv_title
    }
}