package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Diet_food1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_food1)

        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back3 = findViewById<ImageButton>(R.id.back3)

        //食物名稱
        val foodname = findViewById<TextView>(R.id.foodname)
        foodname.text = "堅果"
        //營養成分
        val Element = findViewById<TextView>(R.id.Element)
        Element.text = "含有豐富的維生素E、ω－3脂肪酸和抗氧化物"

        //功效
        val effect = findViewById<TextView>(R.id.effect)
        effect.text = "有助於放鬆心情降低壓力水平"

        back3.setOnClickListener {
            finish()
        }
    }
}