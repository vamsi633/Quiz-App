package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start:Button=findViewById(R.id.start)
        val ed:EditText=findViewById(R.id.ed)


        start.setOnClickListener {

            if(ed.text.isEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent=Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(constants.USER_NAME,ed.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}