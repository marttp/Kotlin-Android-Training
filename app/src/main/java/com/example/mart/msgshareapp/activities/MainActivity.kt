package com.example.mart.msgshareapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mart.msgshareapp.R
import com.example.mart.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast1.setOnClickListener{
            //Code
            Log.i("MainActivity","Button was clicked!")
            showToast(resources.getString(R.string.btn_click_message),Toast.LENGTH_LONG)
            //Move it to Extension
            //Toast.makeText(this,"Button was clicked",Toast.LENGTH_SHORT).show()
        }

        sendIntent.setOnClickListener {
            var message: String = editText.text.toString()
//            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text1",message)
            startActivity(intent)
        }

        inplicitIntent.setOnClickListener {
            var message: String = editText.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Select application : "))
        }

        btnRecyclerViewDemo.setOnClickListener{
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent);
        }
    }
}
