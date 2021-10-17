package com.wafflestudio.assignment3skeleton.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.wafflestudio.assignment3skeleton.databinding.ActivityDetailBinding
import com.wafflestudio.assignment3skeleton.databinding.ActivityMainBinding
import com.wafflestudio.assignment3skeleton.ui.main.MemberAdapter
import timber.log.Timber
import timber.log.Timber.Forest.d

// TODO
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var lectureAdapter: LectureAdapter
    private lateinit var lectureLayoutManager: LinearLayoutManager

    //추가
    private lateinit var binding2: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO : Complete Detail Activity

        binding2 = ActivityMainBinding.inflate(layoutInflater)

        var id = intent.getIntExtra("id",3)
        var name = intent.getStringExtra("name")

        lectureAdapter = LectureAdapter()
        lectureLayoutManager = LinearLayoutManager(this)
        binding.recyclerViewLecture.apply {
            adapter = lectureAdapter
            layoutManager = lectureLayoutManager
        }

        viewModel.getLectureList(id+1)


        viewModel.lectureList.observe(this) {
            binding.textMemberName.text = name
            lectureAdapter.setLectures(it)
        }




    }
}
