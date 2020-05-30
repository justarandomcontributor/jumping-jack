package com.example.jumpingjack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Helper : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helper)

        val backButton: View = findViewById(R.id.back)
        backButton.setOnClickListener { goBackToMain() }
    }

    private fun goBackToMain() {
        this.finish()
    }
}
