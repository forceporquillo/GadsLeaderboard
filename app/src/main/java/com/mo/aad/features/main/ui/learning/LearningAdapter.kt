package com.mo.aad.features.main.ui.learning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mo.aad.R
import com.mo.aad.features.main.data.LearningHoursUser
import kotlinx.android.synthetic.main.layout_item.view.*

class LearningAdapter(val items: List<LearningHoursUser>) : RecyclerView.Adapter<LearningViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningViewHolder {
        return LearningViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.layout_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class LearningViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: LearningHoursUser) = with(itemView) {

        Glide.with(this)
            .load(item.badgeUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(itemView.ivLearning)

        itemView.tvTitle.text = item.name
        itemView.tvDesc.text = "${item.hours} Learning hours,  ${item.country}"
    }
}
