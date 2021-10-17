package com.wafflestudio.assignment3skeleton.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wafflestudio.assignment3skeleton.model.Member
import kotlinx.coroutines.flow.Flow

// TODO
@Dao
interface MemberDao {

    // TODO : Complete Dao interface

    @Query("SELECT * FROM member_table")
    fun getAllMember(): LiveData<List<Member>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMembers(member: Member)


/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMember(member: Member)

     */
}
