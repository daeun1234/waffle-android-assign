package com.example.assignment2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Already completed
@Entity(tableName = "todo_table")
data class Todo(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String
) {
    @PrimaryKey(autoGenerate = true) // 주민등록번호 느낌
    var id: Long = 0
}
