package com.mitron.mathquiz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mitron.mathquiz.R
import com.mitron.mathquiz.data.QuestionModel
import kotlinx.android.synthetic.main.question_page_single_item.view.*

class QuestionsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val questionsList by lazy {
        ArrayList<QuestionModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return QuestionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.question_page_single_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return questionsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val viewholder = holder as QuestionsViewHolder
        val item = questionsList.get(position)
        viewholder.questionHindi.text = item.question_hindi
        viewholder.questionsEnglish.text = item.question_english
        viewholder.optionA.text = item.option_a
        viewholder.optionB.text = item.option_b
        viewholder.optionC.text = item.option_c
        viewholder.optionD.text = item.option_d
        Glide.with(viewholder.itemView.context)
            .load(item.question_media)
            .fitCenter()
            .into(viewholder.imageview)
        viewholder.aContainer.setOnClickListener(View.OnClickListener {
            showAnswers(it, viewholder, item)
        })
        viewholder.bContainer.setOnClickListener(View.OnClickListener {
            showAnswers(it, viewholder, item)
        })
        viewholder.cContainer.setOnClickListener(View.OnClickListener {
            showAnswers(it, viewholder, item)
        })
        viewholder.dContainer.setOnClickListener(View.OnClickListener {
            showAnswers(it, viewholder, item)
        })
    }

    fun showAnswers(selectedView: View, holder: QuestionsViewHolder, item: QuestionModel) {
        selectedView.setBackgroundColor(
            selectedView.resources.getColor(
                R.color.wrong_answer_color
            )
        )
        holder.aContainer.isClickable = false;
        holder.bContainer.isClickable = false;
        holder.cContainer.isClickable = false;
        holder.dContainer.isClickable = false;
        when (item.answer) {
            "a" -> (holder.optionA.parent as View).setBackgroundColor(
                selectedView.resources.getColor(
                    R.color.right_answer_color
                )
            )
            "b" -> (holder.optionB.parent as View).setBackgroundColor(
                selectedView.resources.getColor(
                    R.color.right_answer_color
                )
            )
            "c" -> (holder.optionC.parent as View).setBackgroundColor(
                selectedView.resources.getColor(
                    R.color.right_answer_color
                )
            )
            "d" -> (holder.optionD.parent as View).setBackgroundColor(
                selectedView.resources.getColor(
                    R.color.right_answer_color
                )
            )
        }

    }


    inner class QuestionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questionsEnglish = view.question_english
        val questionHindi = view.question_hindi
        val optionA = view.option_a
        val optionB = view.option_b
        val optionC = view.option_c
        val optionD = view.option_d
        val aContainer = view.option_a_container
        val bContainer = view.option_b_container
        val cContainer = view.option_c_container
        val dContainer = view.option_d_container
        val imageview = view.question_media
    }

    fun updateQuestionsList(list: List<QuestionModel>) {
        questionsList.addAll(list)
        notifyDataSetChanged()
    }
}