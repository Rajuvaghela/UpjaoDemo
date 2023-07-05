package com.example.upjaodemo.roomdb


import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomDb::class], version = 1)
abstract class RoomDatabase2 : RoomDatabase() {
    abstract fun roomDao(): RoomDao

    companion object {
        @Volatile
        private var instance: RoomDatabase2? = null

        fun getInstance(context: Context): RoomDatabase2 {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RoomDatabase2 {
            return Room.databaseBuilder(context, RoomDatabase2::class.java, "room-database")
                .build()
        }
    }
}

