package com.example.jumpingjack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AboutAuthor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_author)
        val backButton: View = findViewById(R.id.back)
        backButton.setOnClickListener { goBackToMain() }
    }

    private fun goBackToMain() {
        this.finish()
    }
}
