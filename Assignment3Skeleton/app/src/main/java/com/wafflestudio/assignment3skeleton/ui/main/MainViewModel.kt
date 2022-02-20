package com.wafflestudio.assignment3skeleton.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wafflestudio.assignment3skeleton.App
import com.wafflestudio.assignment3skeleton.db.MemberDatabase
import com.wafflestudio.assignment3skeleton.model.Member
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import kotlinx.coroutines.flow.Flow

// TODO
class MainViewModel constructor(application: Application) : AndroidViewModel(application) {
    private val memberRepository by lazy { (application as App).memberRepository }

    // TODO : Complete MainViewModel

    private val _memberList = MutableLiveData<List<Member>>()
    val memberList: LiveData<List<Member>> = _memberList

    fun observeMember() = memberRepository.getMembers()

    fun fetchMemberList() {
        viewModelScope.launch {
            try {
                val data = memberRepository.getAllMembers()
                _memberList.value = data
            } catch (e : IOException) {
                Timber.e(e)
            }
        }
    }
}
