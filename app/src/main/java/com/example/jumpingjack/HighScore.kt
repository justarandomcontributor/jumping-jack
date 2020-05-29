package com.example.jumpingjack

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_high_score.*

class HighScore : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    val shared = "sharedPrefs"
    var who = "Name"
    var highscore: String = "Score"
    var temp_score = 0
    var temp_name = ""


    lateinit var highscore_display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        sharedPreferences = getSharedPreferences(shared, Context.MODE_PRIVATE)

        val intent = intent
        val flag = intent.getBooleanExtra("flag_for_saving", false)
        loadData()
        highscore_display = findViewById(R.id.highscore_diaplay)
        val name_input: View = findViewById(R.id.name_input)
        val save_button: View = findViewById(R.id.save_button)
        val back_button: View = findViewById(R.id.back)

        save_button.setOnClickListener { saveData() }
        if (flag) {
            highscore_display.text = "A new highscore!\n$temp_score"
            name_input.visibility = VISIBLE
            save_button.visibility = VISIBLE
        } else {
            highscore_display.text = "Name: $temp_name\nScore: $temp_score"
        }

        back_button.setOnClickListener { go_back_to_main() }

    }


    fun saveData() {
        val editor = sharedPreferences.edit()
        var temp = name_input.editText?.text.toString()
        if (temp == "") {
            temp = "Anonymous"
        }
        editor.putString(who, temp)
        editor.apply()
        highscore_display.text = "Name: $temp \nScore: $temp_score"
        closeKeyboard()
    }

    fun loadData() {
        temp_name = sharedPreferences.getString(who, "Anonymous")!!
        temp_score = sharedPreferences.getInt(highscore, 0)
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun go_back_to_main() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
