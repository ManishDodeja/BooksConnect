package com.example.booksreview

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object{
        // here we have defined variables for our database
        // below is variable for database name
        private const val DATABASE_NAME = "BooksReview"
        // below is the variable for database version
        private const val DATABASE_VERSION = 1


        // below is the variable for table name
        const val TABLE_NAME = "USER"
        // below is the variable for id column
        const val ID_COL = "id"
        // below is the variable for name column
        const val NAME_COl = "name"
        // below is the variable for age column
        const val USERNAME_COL = "username"
        const val PASS_COL ="pass"




        //the 2nd table name which will be linked with user table
        const val TABLE_NAME2="REVIEW_TABLE"
        //variable for ID columns
        const val ID_COL2="id"
        //variable for comments column
        const val COMMENTS="comments"
        //variable for rating the app
        const val RATE ="rate"
        //variable for id in table 2 fk from user table
        const val USERNAME="USERNAME"
        //variable for id in table 2 fk from book table
        const val BOOK="BOOKNAME"


        //Table 3
        const val TABLE_NAME3="Books_Table"
        const val ID_COL3="id"
        const val BookName="book"
    }

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        val userTable = ("CREATE TABLE $TABLE_NAME ($ID_COL INTEGER PRIMARY KEY AUTOINCREMENT, $NAME_COl TEXT,$USERNAME_COL TEXT,$PASS_COL TEXT)")
        val reviewTable =("CREATE TABLE $TABLE_NAME2 ($ID_COL2 INTEGER PRIMARY KEY AUTOINCREMENT, $COMMENTS TEXT, $RATE INTEGER, $USERNAME TEXT, $BOOK TEXT , FOREIGN KEY($USERNAME) REFERENCES $TABLE_NAME($USERNAME_COL), FOREIGN KEY($BOOK) REFERENCES $TABLE_NAME3($BookName))")
        val bookTable =("CREATE TABLE $TABLE_NAME3 ($ID_COL3 INTEGER PRIMARY KEY AUTOINCREMENT,$BookName TEXT)")
        db.execSQL(userTable)
        db.execSQL(bookTable)
        db.execSQL(reviewTable)
        AddBooksToDB()
    }
    private fun AddBooksToDB(){
        //val db = DBHelper(this, null)
        addBook("The Subtle art of not giving a fuck")
        addBook("And the mountain is echoed")
        addBook("Atomic Habits")
        addBook("40 Rules of Love")
        addBook("The broken Wings")
        addBook("Thousand splendid suns")
        addBook("Every thing is fucked")
        addBook("The power of positive thinking")
        addBook("Rich dad poor dad")
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
        onCreate(db)
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME3")
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addUser(name : String, username : String,password:String){
        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(USERNAME_COL, username)
        values.put(PASS_COL, password)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    // below method is to get
    // all data from our database
    fun getUser(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }


    fun addComment(comments: String, Rate:Int, book_name: String, user:String){
        val cv=ContentValues()
        cv.put(COMMENTS,comments)
        cv.put(RATE, Rate)
        cv.put(BOOK, book_name)
        cv.put(USERNAME,user)
        val db =this.writableDatabase
        db.insert(TABLE_NAME2,null,cv)
        db.close()
    }

    fun getComment(book_name: String): Cursor?{
        val db = this.readableDatabase
        //db.query("sku_table", columns, "owner=?", new String[] { owner }, null, null, null
        //return db.query(TABLE_NAME2, arrayOf(COMMENTS, RATE, USERNAME_COL), BookName, arrayOf(book_name),null,null, null)
        return db.rawQuery("Select * from $TABLE_NAME2",null)
    }

    fun addBook(book_name: String){
        val cv=ContentValues()
        cv.put(BookName,book_name)
        val db =this.writableDatabase
        db.insert(TABLE_NAME3,null,cv)
        db.close()
    }
}
