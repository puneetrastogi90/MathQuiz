package com.mitron.mathquiz.Utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mitron.mathquiz.data.QuestionModel
import com.mitron.mathquiz.data.QuizQuestionsListModel
import java.io.IOException

object Utils {

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    fun getQuestions(context: Context): QuizQuestionsListModel {
        val jsonFileString = getJsonDataFromAsset(context, "questions.json")
        val gson = Gson()
        val quizQuestionsModel = object : TypeToken<QuizQuestionsListModel>() {}.type
        var quizQuestionsListModel: QuizQuestionsListModel =
            gson.fromJson(jsonFileString, quizQuestionsModel)
        return quizQuestionsListModel;
    }


}