package com.mitron.mathquiz

import android.app.Application

class MathQuizApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }


    companion object {
        private var instance: MathQuizApplication? = null

        fun getInstance(): MathQuizApplication {
            return instance as MathQuizApplication
        }
    }
}

