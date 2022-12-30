package com.example.booksreview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class BookList : AppCompatActivity() {

    data class Books(val bookpic: Int, val bookname: String, val authorName: String)
    lateinit var listView:ListView
    lateinit var data:Array<Books>
    lateinit var dataOfBook1:ArrayList<BookDetails.comment_class>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)
        listView=findViewById(R.id.listview)
        AddBooks()
        //getComments()
        eventOnClick()
    }

    fun getComments(){
        var username: String? = intent.getStringExtra("username")
        dataOfBook1=ArrayList<BookDetails.comment_class>()
        dataOfBook1.add(BookDetails.comment_class("amazing book",4,username.toString()))
        dataOfBook1.add(BookDetails.comment_class("great",5,username.toString()))
    }



    fun eventOnClick(){
        var username: String? = intent.getStringExtra("username")
        val intent: Intent =Intent(this, BookDetails::class.java)
        listView.setOnItemClickListener{adapterView, view, i,l->
            if(data[i].bookname=="The Subtle art of not giving a fuck"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                //intent.putExtra("comments",dataOfBook1)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()

            }
            else if(data[i].bookname=="And the mountain is echoed"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="Atomic Habits"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="40 Rules of Love"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="The broken Wings"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="Thousand splendid suns"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
               // bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="Every thing is fucked"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="The power of positive thinking"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }
            else if(data[i].bookname=="Rich dad poor dad"){
                intent.putExtra("book_name",data[i].bookname)
                intent.putExtra("author_name",data[i].authorName)
                intent.putExtra("book_pic",data[i].bookpic)
                intent.putExtra("username", username)
                startActivity(intent)
                //bookDetails.getCommentsFromDB()
            }

        }
    }



    private fun AddBooks() {
         data = arrayOf(
            Books(R.drawable.thesubtleart, "The Subtle art of not giving a fuck", "Mark Manson"),
            Books(
                R.drawable.andthemountainsechoed,
                "And the mountain is echoed",
                "Khaled Hosseini"
            ),
            Books(R.drawable.atomichabits, "Atomic Habits", "James Clear"),
            Books(R.drawable.fortyrulesoflove, "40 Rules of Love", "Elif Shafak"),
            Books(R.drawable.thebrokenwings, "The broken Wings", "Kahlil Gibran"),
            Books(R.drawable.thousandsplendidsuns, "Thousand splendid suns", "Khaled Hosseini"),
            Books(R.drawable.everythingisfucked, "Every thing is fucked", "Mark Manson"),
            Books(
                R.drawable.thepowerofpositivethinking,
                "The power of positive thinking",
                "Norman Vincent Peale"
            ),
            Books(R.drawable.richdadpoordad, "Rich dad poor dad", "Robert kiyosaki"),
        )
        val adapter = BooksAdapter(this, R.layout.row, data)
        listView.adapter = adapter
    }


    class BooksAdapter(context: Context, resource: Int, objects: Array<out Books>) :
        ArrayAdapter<Books>(context, resource, objects){
        private val cont= context
        private val res =resource
        private val data=objects
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = LayoutInflater.from(cont).inflate(res, parent, false)

            val book_pic: ImageView = view.findViewById(R.id.book_pic)
            book_pic.setImageResource(data[position].bookpic)

            val book_name: TextView = view.findViewById(R.id.book_name)
            book_name.text = data[position].bookname

            val author: TextView = view.findViewById(R.id.author_name)
            author.text = data[position].authorName
            return view
        }
    }



}