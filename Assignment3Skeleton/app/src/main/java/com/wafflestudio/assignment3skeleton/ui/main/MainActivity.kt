package com.wafflestudio.assignment3skeleton.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.wafflestudio.assignment3skeleton.databinding.ActivityMainBinding
import com.wafflestudio.assignment3skeleton.databinding.ItemMemberIosBinding
import com.wafflestudio.assignment3skeleton.databinding.ItemMemberWaffleBinding
import com.wafflestudio.assignment3skeleton.model.Member
import com.wafflestudio.assignment3skeleton.ui.detail.DetailActivity
import kotlinx.coroutines.launch
import timber.log.Timber

// TODO
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var memberAdapter: MemberAdapter
    private lateinit var memberLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO : Complete MainActivity

        var intent = Intent(this, DetailActivity :: class.java)

        memberAdapter = MemberAdapter()
        memberLayoutManager = LinearLayoutManager(this)
        binding.recyclerViewMember.apply {
            adapter = memberAdapter
            layoutManager = memberLayoutManager
        }

        viewModel.fetchMemberList()

        viewModel.observeMember().observe(this, {
            memberAdapter.setMembers(it)
        })


        memberAdapter.setItemClickListener(object: MemberAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int, name :String) {
                intent.putExtra("id",position)
                intent.putExtra("name", name)
                startActivity(intent)
            }
        })


    }
}
