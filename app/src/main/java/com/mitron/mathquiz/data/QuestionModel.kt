package com.mitron.mathquiz.data

data class QuestionModel(
    val answer: String,
    val explanation: String,
    val explanation_media: String,
    val explanation_video: Any,
    val has_latex: Boolean,
    val id: Int,
    val option_a: String,
    val option_b: String,
    val option_c: String,
    val option_d: String,
    val question_english: String,
    val question_hindi: String,
    val question_media: String
)