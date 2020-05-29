package com.example.jumpingjack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AboutAuthor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_author)
        val back_button: View = findViewById(R.id.back)
        back_button.setOnClickListener { go_back_to_main() }
    }

    private fun go_back_to_main() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
