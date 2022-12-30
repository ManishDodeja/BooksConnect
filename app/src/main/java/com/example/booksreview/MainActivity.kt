package com.example.booksreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var user_txt:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_txt=findViewById(R.id.username_txt1)
        password=findViewById(R.id.password_txt1)
    }

    fun LogIN(v: View){
        val db = DBHelper(this, null)
        val cursor = db.getUser()
        cursor!!.moveToFirst()
        while(cursor.moveToNext()){
            val username=cursor.getString(2)
            val pass=cursor.getString(3)
            if(username==user_txt.text.toString()) {
                if(pass==password.text.toString()) {
                    val intent = Intent(this, BookList::class.java)
                    intent.putExtra("username",username)
                    startActivity(intent)
                }
            }
        }
        cursor.close()
        user_txt.text.clear()
        password.text.clear()

    }


    override fun onRestart() {
        finish()
        super.onRestart()
    }

    fun SignUP(v: View){
        val intent= Intent(this,SignUpScreen::class.java)
        startActivity(intent)
    }
}