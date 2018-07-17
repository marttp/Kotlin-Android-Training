package com.example.mart.msgshareapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.mart.msgshareapp.adapters.HobbiesAdapter
import com.example.mart.msgshareapp.R
import com.example.mart.msgshareapp.models.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

//import android.support.v7.widget.StaggeredGridLayoutManager

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        //Refactoring Code : Move it into method
        setupRecyclerView()

    }

    private fun setupRecyclerView(){
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter
    }
}
