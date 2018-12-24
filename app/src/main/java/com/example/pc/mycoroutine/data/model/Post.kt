package com.example.pc.mycoroutine.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Post")
class Post(@ColumnInfo val userId: Int,
           @PrimaryKey @ColumnInfo val id: Int,
           @ColumnInfo val title: String,
           @ColumnInfo val body: String)