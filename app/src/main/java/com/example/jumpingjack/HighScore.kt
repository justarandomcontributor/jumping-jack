package com.example.jumpingjack

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_high_score.*

class HighScore : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val shared = "sharedPrefs"
    private var who = "Name"
    private var highscore: String = "Score"
    private var tempScore = 0
    private var tempName = ""
    private var backToast: Toast? = null

    private lateinit var highscoredisplay: TextView

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        sharedPreferences = getSharedPreferences(shared, Context.MODE_PRIVATE)

        backToast = makeText(this.baseContext, "Press back again to exit.", Toast.LENGTH_SHORT)
        val intent = intent
        val flag = intent.getBooleanExtra("flag_for_saving", false)
        loadData()
        highscoredisplay = findViewById(R.id.highscore_diaplay)
        val nameInput: View = findViewById(R.id.name_input)
        val saveButton: View = findViewById(R.id.save_button)
        val backButton: View = findViewById(R.id.back)

        saveButton.setOnClickListener { saveData() }
        if (flag) {
            highscoredisplay.text = "A new highscore!\n$tempScore"
            nameInput.visibility = VISIBLE
            saveButton.visibility = VISIBLE
        } else highscoredisplay.text = "Name: $tempName\nScore: $tempScore"

        backButton.setOnClickListener { goBackToMain() }

    }


    @SuppressLint("SetTextI18n")
    fun saveData() {
        val editor = sharedPreferences.edit()
        var temp = name_input.editText?.text.toString()
        if (temp == "") {
            temp = "Anonymous"
        }
        editor.putString(who, temp)
        editor.apply()
        highscoredisplay.text = "Name: $temp \nScore: $tempScore"
        backToast?.show()
        closeKeyboard()
    }

    private fun loadData() {
        tempName = sharedPreferences.getString(who, "Anonymous")!!
        tempScore = sharedPreferences.getInt(highscore, 0)
    }

    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun goBackToMain() {
        backToast?.cancel()
        this.finish()
    }
}
