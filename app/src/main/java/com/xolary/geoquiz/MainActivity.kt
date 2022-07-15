package com.xolary.geoquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Инициализация переменных
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
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

        //Прослушка на нажатие кнопки "true"
        trueButton.setOnClickListener { view: View ->
            var toast = Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            )
            toast.show()

        }

        //Прослушка на нажатие кнопки "false"
        falseButton.setOnClickListener { view: View ->
            var toast = Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}