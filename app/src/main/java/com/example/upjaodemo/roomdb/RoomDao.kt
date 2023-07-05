package com.example.upjaodemo.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface RoomDao {
    @Insert
    fun insert(room: RoomDb)

    @Query("SELECT * FROM rooms")
    fun getAllRooms(): List<RoomDb>
}
