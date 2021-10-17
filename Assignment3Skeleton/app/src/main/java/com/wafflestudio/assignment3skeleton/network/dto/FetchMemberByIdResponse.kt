package com.wafflestudio.assignment3skeleton.network.dto

import com.squareup.moshi.Json
import com.wafflestudio.assignment3skeleton.model.Lecture
import com.wafflestudio.assignment3skeleton.model.Member

// Use if you need it
data class FetchMemberByIdResponse (
    @Json(name = "statusCode")
    val statusCode: Int,
    @Json(name = "body")
    val body: Member,
    //@Json(name = "lectures")
    //val lectures: List<Lecture>
)
