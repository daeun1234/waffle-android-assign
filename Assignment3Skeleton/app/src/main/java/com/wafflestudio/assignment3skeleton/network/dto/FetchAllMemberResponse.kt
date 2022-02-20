package com.wafflestudio.assignment3skeleton.network.dto

import androidx.room.ColumnInfo
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.wafflestudio.assignment3skeleton.model.Lecture
import com.wafflestudio.assignment3skeleton.model.Member

// Use if you need it
data class FetchAllMemberResponse(
    @Json(name = "statusCode")
    val statusCode: Int,
    @Json(name = "body")
    val body: List<Member>
)
