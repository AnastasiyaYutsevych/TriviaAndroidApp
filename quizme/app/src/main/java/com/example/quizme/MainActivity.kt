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
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickedA= false
        clickedB = false
        clickedC= false
        clickedD = false
        quiz1.put("category", listOf("Geography"))
        quiz1.put("type", listOf("multiple"))
        quiz1.put("difficulty", listOf("medium"))
        quiz1.put("correct_answer", listOf("Malaysia"))
        quiz1.put("question", listOf("Kuala Lumpur is the capital of which country?"))
        quiz1.put("incorrect_answers", listOf<String>("Indonesia", "Singapore", "Thailand"))
        quiz2.put("category", listOf("General Knowledge"))
        quiz2.put("type", listOf("multiple"))
        quiz2.put("difficulty", listOf("medium"))
        quiz2.put("correct_answer", listOf("$12.7 Billion"))
        quiz2.put("question", listOf("In 2013 how much money was lost by Nigerian scams"))
        quiz2.put("incorrect_answers", listOf<String>("$95 Million", "$956 Million", "$2.7 Billion"))
        quiz3.put("category", listOf("General Knowledge"))
        quiz3.put("type", listOf("multiple"))
        quiz3.put("difficulty", listOf("medium"))
        quiz3.put("correct_answer", listOf("A falsehood"))
        quiz3.put("question", listOf("A factiod is what?"))
        quiz3.put("incorrect_answers", listOf<String>("Useless Trivia", "A tiny fact", "A scientific figure"))
        exampleMap.put("results", quizzes)
        buttonA = findViewById(R.id.optionA);
        buttonB = findViewById(R.id.optionB);
        buttonC = findViewById(R.id.optionC);
        buttonD = findViewById(R.id.optionD);
        var arr = exampleMap.get("results")
        var quiz= arr?.get(Random.nextInt(0,3))
        if (quiz != null) {
            setQuestion(quiz)
            setButtons(quiz)
        }

    }
    var exampleMap = HashMap<String,List<HashMap<String, List<String>>>>()
    var quiz1 = HashMap<String,List<String>>()
    var quiz2 = HashMap<String,List<String>>()
    var quiz3 = HashMap<String,List<String>>()
    var quizzes = listOf<HashMap<String,List<String>>>(quiz1,quiz2,quiz3)
    var right_answer:String?= null
    lateinit var buttonA:Button
    lateinit var buttonB:Button
    lateinit var buttonC:Button
    lateinit var buttonD:Button
    var clickedA=false
    var clickedB= false
    var clickedC = false
    var clickedD= false
    var prev: String = "Amazon River"
    var url: String = "https://www.wikipedia.org/wiki/$prev"

    //assigns the question from the quiz to TextView
    fun setQuestion(quiz: HashMap<String, List<String>>){
        var question = quiz.get("question")?.get(0)
        var text:TextView = findViewById(R.id.q)
        text.text = question
    }

    //shuffles and assigns various answers to buttons
    fun setButtons(quiz: HashMap<String, List<String>>){
        var answers = quiz["incorrect_answers"]?.toMutableList()
        if (answers != null) {
            quiz["correct_answer"]?.get(0)?.let { answers.add(it)
                right_answer = it}
        }
        if (answers != null) {
            answers.shuffle()
            buttonA.text = answers.get(0)
            buttonB.text  = answers.get(1)
            buttonC.text = answers.get(2)
            buttonD.text = answers.get(3)
        }
    }

    //returns a Button that has a right answer
    fun find_rightAnswer(): Button{
        if(buttonA.text ==right_answer ) return buttonA
        else if(buttonB.text ==right_answer ) return buttonB
        else if(buttonC.text ==right_answer ) return buttonC
        return buttonD
    }

    fun answeredA(view: View){
            buttonA.setTextSize(17F)
            buttonA.setShadowLayer(17F, 5F, 5F, Color.BLACK)
            clickedA = true
    }
    fun answeredB(view:View){
        buttonB.setTextSize(17F)
        buttonB.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedB = true
    }
    fun answeredC(view:View){
        buttonC.setTextSize(17F)
        buttonC.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedC= true
    }
    fun answeredD(view:View){
        buttonD.setTextSize(17F)
        buttonD.setShadowLayer(17F,5F,5F,Color.BLACK)
        clickedD
    }
    fun showRightAnswer(view:View){
        find_rightAnswer().setTextColor(Color.GREEN)
    }

    //checks what button was clicked earlie and identifies if the answer is right or wrong
    fun submit(view: View){
        var correct_button: Button = find_rightAnswer()
        if(clickedA){
            if (buttonA === correct_button) buttonA.setTextColor(Color.GREEN)
            else {
                buttonA.setTextColor(Color.RED)
                correct_button.setTextColor(Color.GREEN)
            }
        }
        else if (clickedB){
            if (buttonB === correct_button) buttonB.setTextColor(Color.GREEN)
            else {
                buttonB.setTextColor(Color.RED)
                correct_button.setTextColor(Color.GREEN)
            }
        }
        else if (clickedC){
            if (buttonC === correct_button) buttonC.setTextColor(Color.GREEN)
            else {
                buttonC.setTextColor(Color.RED)
                correct_button.setTextColor(Color.GREEN)
            }
        }
        else if (clickedD){
            if (buttonD === correct_button) buttonD.setTextColor(Color.GREEN)
            else {
                buttonD.setTextColor(Color.RED)
                correct_button.setTextColor(Color.GREEN)
            }
        }



    }

    fun openWiki(view: View){
        val openWikipedia = Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(openWikipedia)
    }




}
