package com.mitron.mathquiz.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mitron.mathquiz.MathQuizApplication
import com.mitron.mathquiz.Utils.Utils
import com.mitron.mathquiz.data.QuizQuestionsListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MathQuizViewModel : ViewModel() {
    private val _questionsLiveData = MutableLiveData<QuizQuestionsListModel>()
    val questionsLiveData: LiveData<QuizQuestionsListModel>
        get() = _questionsLiveData

    fun fetchQuestions() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = Utils.getQuestions(MathQuizApplication.getInstance())
            withContext(Dispatchers.Main) {
                _questionsLiveData.value = result
            }
        }

    }
}