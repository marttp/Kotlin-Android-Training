package com.example.mart.msgshareapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mart.msgshareapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras

        //If null don't excute below step
        bundle?.let {
            var msg: String? = bundle.getString("text1")
            textIntent.text = msg
        }

    }
}
