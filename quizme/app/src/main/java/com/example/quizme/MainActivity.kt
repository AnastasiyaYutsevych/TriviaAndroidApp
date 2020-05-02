package com.example.quizme

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickedA= false
        clickedB = false
        clickedC= false
        clickedD = false
    }
    var clickedA=false
    var clickedB= false
    var clickedC = false
    var clickedD= false
    var prev: String = "Amazon River"
    var url: String = "https://www.wikipedia.org/wiki/$prev"
    fun answeredA(view: View){
         var buttonA:Button = findViewById(R.id.optionA);
         buttonA.setTextSize(17F)
         buttonA.setShadowLayer(17F,5F,5F,Color.BLACK)
         clickedA = true
    }
    fun answeredB(view:View){
        var buttonB:Button = findViewById(R.id.optionB);
        buttonB.setTextSize(17F)
        buttonB.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedB = true
    }
    fun answeredC(view:View){
        var buttonC:Button = findViewById(R.id.optionC);
        buttonC.setTextSize(17F)
        buttonC.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedC= true
    }
    fun answeredD(view:View){
        var buttonD:Button = findViewById(R.id.optionD);
        buttonD.setTextSize(17F)
        buttonD.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedD
    }
    fun showRightAnswer(view:View){
        var buttonA:Button = findViewById(R.id.optionA);
        buttonA.setTextColor(Color.GREEN)
    }
    fun submit(view: View){
        var buttonA:Button = findViewById(R.id.optionA);
        var buttonB:Button = findViewById(R.id.optionB);
        var buttonC:Button = findViewById(R.id.optionC);
        var buttonD:Button = findViewById(R.id.optionD);
        if(clickedA){
            buttonA.setTextColor(Color.GREEN)
        }
        else if (clickedB){
            buttonB.setTextColor(Color.RED)
            buttonA.setTextColor(Color.GREEN)
        }
        else if (clickedC){
            buttonC.setTextColor(Color.RED)
            buttonA.setTextColor(Color.GREEN)
        }
        else if (clickedD){
            buttonD.setTextColor(Color.RED)
            buttonA.setTextColor(Color.GREEN)
        }



    }

    fun openWiki(view: View){
        val openWikipedia = Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(openWikipedia)
    }




}
