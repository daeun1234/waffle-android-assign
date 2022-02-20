package com.wafflestudio.assignment3skeleton.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.assignment3skeleton.databinding.ItemMemberIosBinding
import com.wafflestudio.assignment3skeleton.databinding.ItemMemberWaffleBinding
import com.wafflestudio.assignment3skeleton.model.Member
import com.wafflestudio.assignment3skeleton.ui.detail.LectureAdapter
import timber.log.Timber
import java.lang.IllegalStateException

// TODO
class MemberAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var members : List<Member> = listOf()

    inner class MemberWaffleViewHolder(val binding: ItemMemberWaffleBinding) : RecyclerView.ViewHolder(binding.root)
    inner class MemberIosViewHolder(val binding: ItemMemberIosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            VIEW_TYPE_WAFFLE -> {
                val binding = ItemMemberWaffleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MemberWaffleViewHolder(binding)
            }
            VIEW_TYPE_IOS -> {
                val binding = ItemMemberIosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MemberIosViewHolder(binding)
            }
            else -> throw IllegalStateException("viewType must be 0 or 1")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = members[position]
        val name = data.name
        holder.itemView.setOnClickListener() {
            itemClickListener.onClick(it,position, name)
        }
        when (holder) {
            is MemberWaffleViewHolder -> {
                holder.binding.apply {
                    textName.text = data.name
                }
            }
            is MemberIosViewHolder -> {
                holder.binding.apply {
                    textName.text = data.name
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if(members[position].team == "waffle") VIEW_TYPE_WAFFLE else VIEW_TYPE_IOS
    }

    override fun getItemCount() = members.size

    fun setMembers(members: List<Member>) {
        this.members = members
        this.notifyDataSetChanged()
    }

    companion object  {
        const val VIEW_TYPE_WAFFLE = 1
        const val VIEW_TYPE_IOS = 0
    }


    interface OnItemClickListener {
        fun onClick(v: View, position: Int, name:String) {
        }
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

}
