package com.example.upjaodemo.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.upjaodemo.R
import com.example.upjaodemo.adapter.CustomAdapter
import com.example.upjaodemo.viewmodel.ItemsViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val btnAddData = findViewById<AppCompatButton>(R.id.btnAddData)
        btnAddData.setOnClickListener(this)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_foreground, "Item " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnAddData ->{
                Log.e("dsadsadasdsads","asdsadsa")
                val intent = Intent(this, AddRecord2::class.java)
               // intent.putExtra("key", value)
                startActivity(intent)
            }
        }
    }
}
