package com.blankymunn3.materialfragmenttransform.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blankymunn3.materialfragmenttransform.DiffCallback
import com.blankymunn3.materialfragmenttransform.databinding.RecyclerItemPictureBinding
import com.blankymunn3.materialfragmenttransform.model.BTSModel

class BTSRVAdapter(var list: List<BTSModel> = emptyList()): RecyclerView.Adapter<BTSRVAdapter.ViewHolder>() {
    lateinit var bTSClickListener: BTSClickListener

    interface BTSClickListener {
        fun onClick(uId: Int, cardView: CardView)
    }

    fun onBTSClickListener(btsClickListener: BTSClickListener) {
        this.bTSClickListener = btsClickListener
    }

    fun setData(newData: List<BTSModel>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(this.list, newData))
        this.list = newData
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(val binding: RecyclerItemPictureBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(btsModel: BTSModel) {
            binding.bts = btsModel
            binding.cardViewPicture.transitionName = btsModel.uId.toString()
            binding.ivPicture.setOnClickListener {
                bTSClickListener.onClick(btsModel.uId, binding.cardViewPicture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BTSRVAdapter.ViewHolder = ViewHolder(
        RecyclerItemPictureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BTSRVAdapter.ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}