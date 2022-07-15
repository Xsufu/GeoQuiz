package com.xolary.geoquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Инициализация переменных
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private var currentIndex = 0

    private val questionBlank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Привязка элементов макета к переменным
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_field)

        //Прослушка на нажатие кнопки "true"
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        //Прослушка на нажатие кнопки "false"
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBlank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResID = questionBlank[currentIndex].textResId
        questionTextView.setText(questionTextResID)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBlank[currentIndex].answer

        val messageResId =
            if (userAnswer == correctAnswer)
                R.string.correct_toast
            else
                R.string.incorrect_toast

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}