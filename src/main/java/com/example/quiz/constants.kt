package com.example.quiz

object constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getquestion():ArrayList<Question>{
        val questionlist=ArrayList<Question>()

        val que1=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_argentina,"Argentina","Australia","Armenia","Austria",1
        )

        questionlist.add(que1)

        val que2=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_australia,"USA","Australia","New zeland","Austria",2
        )

        questionlist.add(que2)

        val que3=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_belgium,"Germany","France","Belgium","Austria",3
        )

        questionlist.add(que3)

        val que4=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_brazil,"Bangladesh","Brazil","Armenia","Austria",2
        )

        questionlist.add(que4)

        val que5=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_denmark,"Scotland","Sweden","Switzerland","Denmark",4
        )

        questionlist.add(que5)

        val que6=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_fiji,"England","Fizi","Armenia","Sudan",2
        )

        questionlist.add(que6)

        val que7=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_germany,"Germany","China","Belgium","Spain",1
        )

        questionlist.add(que7)

        val que8=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_india,"Italy","USA","India","Srilanka",3
        )

        questionlist.add(que8)

        val que9=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_kuwait,"Saudi Arabia","Israel","UAE","Kuwait",4
        )

        questionlist.add(que9)

        val que10=Question(
            1,"what country does this flag belong to ?",
            R.drawable.ic_flag_of_new_zealand,"USA","New Zeland","Australia","UAE",2
        )

        questionlist.add(que10)

        return questionlist
    }
}