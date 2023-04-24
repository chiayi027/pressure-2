package com.example.mainactivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        val guess_submit=findViewById<Button>(R.id.guess_submit)
        val back6 = findViewById<Button>(R.id.back6)
        val number=findViewById<TextView>(R.id.number)
        val historyInput=findViewById<TextView>(R.id.history_input)
        val historyResult=findViewById<TextView>(R.id.history_result)
        val game = Game()
        game.generateAnswer();

        guess_submit.setOnClickListener {
            historyInput.setText(number.getText().toString() + "\n" + historyInput.getText());
            historyResult.setText((game.checkAnswer(number.getText().toString()))+"\n"+ historyResult.getText())
            if(game.isWin){
                
            }
        }


        back6.setOnClickListener {
            finish()

        }
    }
}