package json

import com.google.gson.Gson

val json = """
     {
        "owner": "John Smith",
        age: 55,
        "books":[
           {
              "id":"444",
              "language":"C",
              "edition":"First",
              "author":"Dennis Ritchie "
           },
           {
              "id":"555",
              "language":"C++",
              "edition":"second",
              "author":" Bjarne Stroustrup "
           }
        ]
     }
 """.trimIndent()

fun main(){
/*    val obj = JSONObject(json)
    println(obj.getString("owner"))

    val books = obj.getJSONArray("books")
    val book = books[1] as JSONObject
    println(book.getString("author"))*/

    val gson = Gson()
    val bookOwner : BookOwner = gson.fromJson(json, BookOwner::class.java)

    println(
        bookOwner.books[1].author
    )

    println(gson.toJson(bookOwner))



}