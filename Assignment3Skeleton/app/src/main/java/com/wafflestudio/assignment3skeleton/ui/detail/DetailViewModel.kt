package com.wafflestudio.assignment3skeleton.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wafflestudio.assignment3skeleton.App
import com.wafflestudio.assignment3skeleton.model.Lecture
import com.wafflestudio.assignment3skeleton.model.Member
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException

// TODO
class DetailViewModel constructor(application: Application) : AndroidViewModel(application) {

    private val memberRepository by lazy { (application as App).memberRepository }

    // TODO : Complete DetailViewModel
    private val _lectureList = MutableLiveData<List<Lecture>>()
    val lectureList : LiveData<List<Lecture>> = _lectureList

    fun getLectureList(int:Int) {
        viewModelScope.launch {
            try {
                val data = memberRepository.getLectures(int)
                _lectureList.value = data
            } catch (e:IOException) {
                Timber.e(e)
            }
        }
    }

}
