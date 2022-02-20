package com.wafflestudio.assignment3skeleton.repository

import com.wafflestudio.assignment3skeleton.db.MemberDao
import com.wafflestudio.assignment3skeleton.model.Lecture
import com.wafflestudio.assignment3skeleton.model.Member
import com.wafflestudio.assignment3skeleton.network.MemberService
import kotlinx.coroutines.flow.Flow
import timber.log.Timber


// TODO
class MemberRepository constructor(
    private val memberDao: MemberDao,
    private val memberService: MemberService
    ) {

    // TODO : Complete MemberRepository

    fun getMembers() = memberDao.getAllMember()

    suspend fun getAllMembers() : List<Member> {
        val data = memberService.getAllMembers()
        val data_member = data.body
        for (member : Member in data_member) memberDao.insertAllMembers(member)
        return data_member
    }

    suspend fun getLectures(int : Int) : List<Lecture>? {
        val lecture = memberService.getLectures(int)
        val lecture_data = lecture.body.lectures
        return lecture_data
    }

    companion object {
        @Volatile
        private var INSTANCE: MemberRepository? = null

        @JvmStatic
        fun getInstance(memberDao: MemberDao, memberService: MemberService) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MemberRepository(memberDao, memberService).also { INSTANCE = it }
            }
    }

}
