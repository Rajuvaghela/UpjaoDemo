package com.example.upjaodemo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.upjaodemo.R
import com.example.upjaodemo.roomdb.RoomDatabase2
import com.example.upjaodemo.roomdb.RoomDao
import com.example.upjaodemo.roomdb.RoomDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddRecord2 : AppCompatActivity() {
    private lateinit var roomDatabase2: RoomDatabase2
    private lateinit var roomDao: RoomDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_record)
        roomDatabase2 = RoomDatabase2.getInstance(this)

        // Access the DAO
        roomDao = roomDatabase2.roomDao()

        // Create a new room object
        val room = RoomDb(
            firstName = "John",
            lastName = "Doe",
            phoneNumber = "1234567890",
            location = "New York"
        )

        // Insert the room into the database
        insertRoom(room)

        // Retrieve all rooms from the database
        getAllRooms()

    }
    private fun insertRoom(room: RoomDb) {
        GlobalScope.launch(Dispatchers.IO) {
            roomDao.insert(room)
        }
    }

    private fun getAllRooms() {
        GlobalScope.launch(Dispatchers.IO) {
            val rooms = roomDao.getAllRooms()
            withContext(Dispatchers.Main) {
                Log.e("data",rooms.toString())
                // Handle the retrieved rooms on the main thread
                // e.g., update UI or perform any necessary operations
            }
        }
    }
}