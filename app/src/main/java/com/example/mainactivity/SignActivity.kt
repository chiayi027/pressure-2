package com.example.mainactivity

import User
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

private lateinit var btn_submit:ImageButton
private lateinit var btn_date:ImageButton
private lateinit var sex:RadioGroup
private lateinit var account:TextView
private lateinit var password:TextView
private lateinit var check_pwd:TextView
private lateinit var name:TextView
private lateinit var age:TextView
class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        btn_submit=findViewById<ImageButton>(R.id.btn_submit)
        sex = findViewById<RadioGroup>(R.id.sexy)
        btn_date=findViewById<ImageButton>(R.id.btn_date)
        age=findViewById<TextView>(R.id.age)
        name=findViewById<TextView>(R.id.name)
        account=findViewById<TextView>(R.id.sign_account)
        password=findViewById<TextView>(R.id.sign_password)
        check_pwd=findViewById<TextView>(R.id.checkpwd)

        val db = Room.databaseBuilder(this, AppDatabase::class.java,"test.db").build()
        btn_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    val format = "${setDateFormat(year, month, day)}"
                    age.text = format
                }
            }, year, month, day).show()
        }

        btn_submit.setOnClickListener {

            val name = name.text.toString()
            val birthday = age.text.toString()
            val sexy = sex.checkedRadioButtonId.toString()
            val account = account.text.toString()
            val password = password.text.toString()
            val check_pwd = check_pwd.text.toString()
            GlobalScope.launch {
                val rowid = db.userDao().insert(User(name = name,account=account, age = birthday, sex = sexy, password=password,check_pwd=check_pwd ,mTime = LocalDateTime.now()))
                if(rowid > 0){
                    Snackbar.make(it, "新增成功！$rowid", Snackbar.LENGTH_LONG).show()
                }
            }
            //val b = Bundle()
            /*with(getPreferences(MODE_PRIVATE).edit()){
                putString("sex",sex.findViewById<RadioButton>
                    (sex.checkedRadioButtonId).text.toString())
                    putString("na",name.getText().toString())
                    putString("ag",age.getText().toString())
                    putString("sign_acc", account.getText().toString())
                    putString("sign_pwd", password.getText().toString())
                    putString("check_pwd",check_pwd.getText().toString())
                    apply()
            }
            //setResult(RESULT_OK, Intent().putExtras(b))
            finish()*/
        }

    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

}