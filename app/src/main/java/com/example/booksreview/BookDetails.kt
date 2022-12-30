package com.example.booksreview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import org.w3c.dom.Comment
import org.w3c.dom.Text

class BookDetails : AppCompatActivity() {
    data class comment_class(val comment: String, val rate:Int, val user:String)
    lateinit var book_name:TextView
    lateinit var author_name:TextView
    lateinit var book_img:ImageView
    lateinit var db:DBHelper
    lateinit var dataOfBook1:ArrayList<comment_class>
    lateinit var dataOfBook2:ArrayList<comment_class>
    lateinit var dataOfBook3:ArrayList<comment_class>
    lateinit var dataOfBook4:ArrayList<comment_class>
    lateinit var dataOfBook5:ArrayList<comment_class>
    lateinit var dataOfBook6:ArrayList<comment_class>
    lateinit var dataOfBook7:ArrayList<comment_class>
    lateinit var dataOfBook8:ArrayList<comment_class>
    lateinit var dataOfBook9:ArrayList<comment_class>
    lateinit var username:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        book_name=findViewById(R.id.textView4)
        author_name=findViewById(R.id.textView5)
        book_img=findViewById(R.id.imageView)

        book_name.text=intent.getStringExtra("book_name")
        author_name.text=intent.getStringExtra("author_name")
        val resImg:Int=intent!!.getIntExtra("book_pic",1)
        book_img.setImageResource(resImg)
        username=intent.getStringExtra("username").toString()




        dataOfBook1= arrayListOf<comment_class>()
        dataOfBook2=arrayListOf<comment_class>()
        dataOfBook3=arrayListOf<comment_class>()
        dataOfBook4=arrayListOf<comment_class>()
        dataOfBook5=arrayListOf<comment_class>()
        dataOfBook6=arrayListOf<comment_class>()
        dataOfBook7=arrayListOf<comment_class>()
        dataOfBook8=arrayListOf<comment_class>()
        dataOfBook9=arrayListOf<comment_class>()
        getCommentsFromDB()
    }

     fun getCommentsFromDB(){

        val listView:ListView=findViewById(R.id.listview)
        if(book_name.text=="The Subtle art of not giving a fuck"){
            if(!username.equals("manish11")) {
                dataOfBook1.add(comment_class("amazing book", 4, "manish11"))
                dataOfBook1.add(comment_class("great", 5, "manish11"))
                val adapter= comment_Adapter(this, R.layout.commentrow,dataOfBook1)
                listView.adapter = adapter
            }
            val adapter = comment_Adapter(this, R.layout.commentrow, dataOfBook1)
            listView.adapter = adapter
        }
        else if(book_name.text=="And the mountain is echoed"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook2)
            listView.adapter=adapter
        }
        else if(book_name.text=="Atomic Habits"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook3)
            listView.adapter=adapter
        }
        else if(book_name.text=="40 Rules of Love"){
            if(!username.equals("manish11")) {
                dataOfBook4.add(comment_class("worth reading", 5, "manish11"))
                val adapter = comment_Adapter(this, R.layout.commentrow, dataOfBook4)
                listView.adapter = adapter
            }
            val adapter = comment_Adapter(this, R.layout.commentrow, dataOfBook4)
            listView.adapter = adapter

        }
        else if(book_name.text=="The broken Wings"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook5)
            listView.adapter=adapter
        }
        else if(book_name.text=="Thousand splendid suns"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook6)
            listView.adapter=adapter
        }
        else if(book_name.text=="Every thing is fucked"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook7)
            listView.adapter=adapter
        }
        else if(book_name.text=="The power of positive thinking"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook8)
            listView.adapter=adapter
        }
        else if(book_name.text=="Rich dad poor dad"){
            val adapter=comment_Adapter(this, R.layout.commentrow,dataOfBook9)
            listView.adapter=adapter
        }
    }



    fun addComment(v:View){
        val cmnt:EditText=findViewById(R.id.cmnt_txt)
        val rate: RatingBar=findViewById(R.id.ratingBar9)
        val username: String? = intent.getStringExtra("username")
        if(book_name.text=="The Subtle art of not giving a fuck"){
            dataOfBook1.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()

        }
        else if(book_name.text=="And the mountain is echoed"){
            dataOfBook2.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="Atomic Habits"){
            dataOfBook3.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="40 Rules of Love"){
            dataOfBook4.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="The broken Wings"){
            dataOfBook5.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="Thousand splendid suns"){
            dataOfBook6.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="Every thing is fucked"){
            dataOfBook7.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="The power of positive thinking"){
            dataOfBook1.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }
        else if(book_name.text=="Rich dad poor dad"){
            dataOfBook1.add(comment_class(cmnt.text.toString(),rate.rating.toInt(),username.toString()))
            cmnt.text.clear()
            rate.rating = 0F
            getCommentsFromDB()
        }



        //db.addComment(cmnt.text.toString(),5,book_name.text.toString(),"Manish")

    }


    class comment_Adapter(context:Context, resource:Int, objects:ArrayList<comment_class>):
        ArrayAdapter<comment_class>(context, resource,objects){
            val res=resource
            val data=objects
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view=LayoutInflater.from(context).inflate(res,parent,false)

                val user_name=view.findViewById<TextView>(R.id.user_txt)
                user_name.text=data[position].user.toString()

                val comment_txt=view.findViewById<TextView>(R.id.comment_txt)
                comment_txt.text=data[position].comment.toString()

                val rate=view.findViewById<RatingBar>(R.id.ratingBar2)
                rate.rating=data[position].rate.toFloat()

                return view
            }
        }
}