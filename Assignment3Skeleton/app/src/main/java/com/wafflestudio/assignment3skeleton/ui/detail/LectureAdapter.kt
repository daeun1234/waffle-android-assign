package com.wafflestudio.assignment3skeleton.ui.detail

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.assignment3skeleton.databinding.ActivityDetailBinding
import com.wafflestudio.assignment3skeleton.databinding.ItemLectureBinding
import com.wafflestudio.assignment3skeleton.model.Lecture


// TODO
class LectureAdapter : RecyclerView.Adapter<LectureAdapter.LectureViewHolder>() {
    private var lectures: List<Lecture> = listOf()

    inner class LectureViewHolder(val binding: ItemLectureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val binding = ItemLectureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LectureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val data = lectures[position]
        holder.binding.apply {
            textTitle.text = data.title
            textInstructor.text = data.instructor
            textCredit.text = data.credit.toString()
        }
    }

    override fun getItemCount() = lectures.size

    fun setLectures(lectures : List<Lecture>) {
        this.lectures = lectures
        this.notifyDataSetChanged()
    }
}