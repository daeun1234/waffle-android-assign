package com.wafflestudio.assignment3skeleton.network

import com.squareup.moshi.JsonClass
import com.wafflestudio.assignment3skeleton.model.Lecture
import com.wafflestudio.assignment3skeleton.model.Member
import com.wafflestudio.assignment3skeleton.network.dto.FetchAllMemberResponse
import com.wafflestudio.assignment3skeleton.network.dto.FetchMemberByIdResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

// TODO
interface MemberService {

    // TODO : Complete Service interface
    @GET("/waffle/members")
    suspend fun getAllMembers (): FetchAllMemberResponse

    @GET("/waffle/members/{id}")
    suspend fun getLectures(@Path("id") memberId : Int) : FetchMemberByIdResponse

}
