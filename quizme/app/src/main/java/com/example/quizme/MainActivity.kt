package com.example.quizme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var prev: String = "Amazon River"
    var url: String = "https://www.wikipedia.org/wiki/$prev"

    fun openWiki(view: View){
        val openWikipedia = Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(openWikipedia)
    }


}
