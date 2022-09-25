package io.jyryuitpro.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    // 이 함수는 액티비티 서브 클래스의 인스턴스가 생성될 때 자동으로 호출된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 이때 이 함수에서는 액티비티가 UI를 화면에 보여주고 처리할 수 있도록 다음 함수를 호출한다.
        // 이 함수는 레이아웃을 인플레이트(inflate)해 화면에 나타낸다.
        // 레이아웃이 인플레이트되면 레이아웃 파일에 있는 각 위젯이 자신의 속성에 정의된 대로 인스턴스로 생성된다.
        // 이 함수를 호출할 때는 인플레이트될 레이아웃의 리소스 ID(resource ID)를 인자로 전달한다
        // (인플레이트는 뷰 계층 구조를 따라 객체로 생성하는 것을 말한다.)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val corretAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == corretAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}