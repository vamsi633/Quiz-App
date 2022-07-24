package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

//data class

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mcurrentposition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private  var mselectedoptionposition:Int=0
    private var musername:String?=null
    private var mcorrectanswers:Int=0;

    private var progressbar:ProgressBar?=null
    private var tvprogress:TextView?=null

    private var tvquestion:TextView?=null
    private var image:ImageView?=null

    private var tvopt1:TextView?=null
    private var tvopt2:TextView?=null
    private var tvopt3:TextView?=null
    private var tvopt4:TextView?=null

    private var submit:Button?=null


    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        musername=intent.getStringExtra(constants.USER_NAME)

        progressbar=findViewById(R.id.progressbar)
        tvprogress=findViewById(R.id.tvprogress)

        tvquestion=findViewById(R.id.tvquestion)
        image=findViewById(R.id.image)

        tvopt1=findViewById(R.id.tvopt1)
        tvopt2=findViewById(R.id.tvopt2)
        tvopt3=findViewById(R.id.tvopt3)
        tvopt4=findViewById(R.id.tvopt4)

        submit=findViewById(R.id.submit)

        tvopt1?.setOnClickListener (this)
        tvopt2?.setOnClickListener (this)
        tvopt3?.setOnClickListener (this)
        tvopt4?.setOnClickListener (this)
        submit?.setOnClickListener(this)

        mQuestionsList = constants.getquestion()

        setQuestion()
      //  defaultoptionview()
    }

    private fun setQuestion() {
        defaultoptionview()
        val question: Question = mQuestionsList!![mcurrentposition - 1]
        progressbar?.progress = mcurrentposition
        tvprogress?.text = "$mcurrentposition/${progressbar?.max}"
        tvquestion?.text = question!!.question

        image?.setImageResource(question.image)
        tvopt1?.text = question.optionone
        tvopt2?.text = question.optiontwo
        tvopt3?.text = question.optionthree
        tvopt4?.text = question.optionfour

        if(mcurrentposition==mQuestionsList!!.size){
            submit?.text="FINISH"
        }else{
            submit?.text="SUBMIT"
        }
    }

    private fun defaultoptionview(){

        val options=ArrayList<TextView>()

        tvopt1?.let {
            options.add(0,it)
        }
        tvopt2?.let {
            options.add(1,it)
        }
        tvopt3?.let {
            options.add(2,it)
        }
        tvopt4?.let {
            options.add(3,it)
        }


        for(i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(this,R.drawable.default_option_borer_bg)

        }
    }

    private fun selectedoptionView(tv:TextView,selectedoptionnum:Int){

        defaultoptionview()

        mselectedoptionposition=selectedoptionnum

        tv.setTextColor(Color.parseColor("#363a43"))

        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.select_option_border)


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvopt1->{
                tvopt1?.let {
                    selectedoptionView(it,1)
                }
            }
            R.id.tvopt2->{
                tvopt2?.let {
                    selectedoptionView(it,2)
                }
            }
            R.id.tvopt3->{
                tvopt3?.let {
                    selectedoptionView(it,3)
                }
            }
            R.id.tvopt4->{
                tvopt4?.let {
                    selectedoptionView(it,4)
                }
            }
            R.id.submit->{
           if(mselectedoptionposition==0){
               mcurrentposition++

               when{
                   mcurrentposition<=mQuestionsList!!.size->{
                       setQuestion()
                   }else->{
                      // Toast.makeText(this,"You made it to the end",Toast.LENGTH_SHORT).show()
                       val intent= Intent(this,ResultActivity::class.java)
                   intent.putExtra(constants.USER_NAME,musername)
                   intent.putExtra(constants.CORRECT_ANSWERS,mcorrectanswers)
                   intent.putExtra(constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                   startActivity(intent)
                   finish()

                   }
               }
           }else{
               val question=mQuestionsList?.get(mcurrentposition-1)
               if(question!!.correctanswer!=mselectedoptionposition){
                   answerView(mselectedoptionposition,R.drawable.wrong_option_borer_bg)
               }else{
                   mcorrectanswers++
               }
               answerView(question.correctanswer,R.drawable.correct_option_borer_bg)

               if(mcurrentposition==mQuestionsList!!.size){
                   submit?.text="FINISH"
               }else{
                   submit?.text="GO TO NEXT QUESTION"
               }
               mselectedoptionposition=0
           }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvopt1?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvopt2?.background=ContextCompat.getDrawable(this,drawableView)
            }
           3->{
                tvopt3?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvopt4?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}