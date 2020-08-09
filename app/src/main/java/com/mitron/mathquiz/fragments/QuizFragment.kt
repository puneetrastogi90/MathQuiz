package com.mitron.mathquiz.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.covid.covidapp.base.BaseFragment
import com.mitron.mathquiz.R
import com.mitron.mathquiz.Utils.Utils
import com.mitron.mathquiz.adapter.QuestionsAdapter
import com.mitron.mathquiz.viewmodels.MathQuizViewModel
import kotlinx.android.synthetic.main.fragment_quiz.*


class QuizFragment : BaseFragment() {

    val viewModel: MathQuizViewModel by lazy {
        ViewModelProvider(this).get(MathQuizViewModel::class.java)
    }

    val snapHelper: PagerSnapHelper by lazy {
        PagerSnapHelper()
    }

    val adapter: QuestionsAdapter by lazy {
        QuestionsAdapter()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizFragment()
    }

    override fun defineLayoutResources(): Int {
        return R.layout.fragment_quiz
    }

    override fun initializeComponent(view: View) {
        setUpRecyclerView()
        viewModel.fetchQuestions()
        viewModel.questionsLiveData.observe(viewLifecycleOwner, Observer {
            adapter.updateQuestionsList(it.questions)
        })
    }

    private fun setUpRecyclerView() {
        questions_recyeclerview.adapter = adapter
        questions_recyeclerview.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        snapHelper.attachToRecyclerView(questions_recyeclerview)
    }
}
