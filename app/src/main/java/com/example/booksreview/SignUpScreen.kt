package com.example.booksreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignUpScreen : AppCompatActivity() {
    lateinit var name :EditText
    lateinit var username :EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)
        name=findViewById(R.id.name_txt)
        username=findViewById(R.id.username_txt)
        password=findViewById(R.id.password_txt)
    }

    fun Register(v: View){
        val db1 = DBHelper( this, null)

        val name1 = name.text.toString()
        val username1 = username.text.toString()
        val password1=password.text.toString()

        db1.addUser(name1, username1,password1)
        Toast.makeText(this, "$username1, $password1  added to database", Toast.LENGTH_LONG).show()
        name.text.clear()
        username.text.clear()
        password.text.clear()

    }
}