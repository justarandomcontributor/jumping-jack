package com.example.jumpingjack

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val shared = "sharedPrefs"
    var who = "Name"
    var highscore: String = "Score"
    var temp_score = 0
    var temp_name = ""

    private var point = 0
    lateinit var score: TextView
    lateinit var timer: TextView

    lateinit var start: Button

    lateinit var image: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView
    lateinit var image4: ImageView
    lateinit var image5: ImageView
    lateinit var image6: ImageView
    lateinit var image7: ImageView
    lateinit var image8: ImageView
    lateinit var image9: ImageView
    lateinit var image10: ImageView
    lateinit var image11: ImageView
    lateinit var image12: ImageView
    lateinit var image13: ImageView
    lateinit var image14: ImageView
    lateinit var image15: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(shared, Context.MODE_PRIVATE)

        start = findViewById(R.id.start)
        score = findViewById(R.id.Score)
        timer = findViewById(R.id.Timer)

        image = findViewById(R.id.image_random)
        image2 = findViewById(R.id.image_random2)
        image3 = findViewById(R.id.image_random3)
        image4 = findViewById(R.id.image_random4)
        image5 = findViewById(R.id.image_random5)
        image6 = findViewById(R.id.image_random6)
        image7 = findViewById(R.id.image_random7)
        image8 = findViewById(R.id.image_random8)
        image9 = findViewById(R.id.image_random9)
        image10 = findViewById(R.id.image_random10)
        image11 = findViewById(R.id.image_random11)
        image12 = findViewById(R.id.image_random12)
        image13 = findViewById(R.id.image_random13)
        image14 = findViewById(R.id.image_random14)
        image15 = findViewById(R.id.image_random15)

        image.setOnClickListener { update() }
        image2.setOnClickListener { update() }
        image3.setOnClickListener { update() }
        image4.setOnClickListener { update() }
        image5.setOnClickListener { update() }
        image6.setOnClickListener { update() }
        image7.setOnClickListener { update() }
        image8.setOnClickListener { update() }
        image9.setOnClickListener { update() }
        image10.setOnClickListener { update() }
        image11.setOnClickListener { update() }
        image12.setOnClickListener { update() }
        image13.setOnClickListener { update() }
        image14.setOnClickListener { update() }
        image15.setOnClickListener { update() }

        start.setOnClickListener { play() }

    }

    private fun play() {
        this.point = 0

        score.visibility = View.VISIBLE
        timer.visibility = View.VISIBLE
        this.score.text = "Score: $point"

        start.visibility = View.GONE
        var random = (0..14).random()

        score = findViewById(R.id.Score)
        this.timer = findViewById(R.id.Timer)

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var temp = millisUntilFinished / 1000
                timer.text = "Game Starts in: $temp"
            }

            override fun onFinish() {

                object : CountDownTimer(60000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {

                        when (random) {
                            0 -> image.visibility = View.GONE
                            1 -> image2.visibility = View.GONE
                            2 -> image3.visibility = View.GONE
                            3 -> image4.visibility = View.GONE
                            4 -> image5.visibility = View.GONE
                            5 -> image6.visibility = View.GONE
                            6 -> image7.visibility = View.GONE
                            7 -> image8.visibility = View.GONE
                            8 -> image9.visibility = View.GONE
                            9 -> image10.visibility = View.GONE
                            10 -> image11.visibility = View.GONE
                            11 -> image12.visibility = View.GONE
                            12 -> image13.visibility = View.GONE
                            13 -> image14.visibility = View.GONE
                            14 -> image15.visibility = View.GONE
                        }
                        var temp = millisUntilFinished / 1000
                        timer.text = ("Time Remaining: $temp")

                        random = (0..15).random()

                        when (random) {
                            0 -> image.visibility = View.VISIBLE
                            1 -> image2.visibility = View.VISIBLE
                            2 -> image3.visibility = View.VISIBLE
                            3 -> image4.visibility = View.VISIBLE
                            4 -> image5.visibility = View.VISIBLE
                            5 -> image6.visibility = View.VISIBLE
                            6 -> image7.visibility = View.VISIBLE
                            7 -> image8.visibility = View.VISIBLE
                            8 -> image9.visibility = View.VISIBLE
                            9 -> image10.visibility = View.VISIBLE
                            10 -> image11.visibility = View.VISIBLE
                            11 -> image12.visibility = View.VISIBLE
                            12 -> image13.visibility = View.VISIBLE
                            13 -> image14.visibility = View.VISIBLE
                            14 -> image15.visibility = View.VISIBLE
                        }
                    }

                    override fun onFinish() {
                        timer.text = "Timeout!"

                        when (random) {
                            0 -> image.visibility = View.GONE
                            1 -> image2.visibility = View.GONE
                            2 -> image3.visibility = View.GONE
                            3 -> image4.visibility = View.GONE
                            4 -> image5.visibility = View.GONE
                            5 -> image6.visibility = View.GONE
                            6 -> image7.visibility = View.GONE
                            7 -> image8.visibility = View.GONE
                            8 -> image9.visibility = View.GONE
                            9 -> image10.visibility = View.GONE
                            10 -> image11.visibility = View.GONE
                            11 -> image12.visibility = View.GONE
                            12 -> image13.visibility = View.GONE
                            13 -> image14.visibility = View.GONE
                            14 -> image15.visibility = View.GONE
                        }
                        savescore()
                        start.visibility = View.VISIBLE
                    }
                }.start()

            }
        }.start()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean // Handle item selection
    {
        return when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, AboutAuthor::class.java)
                startActivity(intent)
                true
            }
            R.id.exit -> {
                finish()
                true
            }
            R.id.high_score -> {
                val intent = Intent(this, HighScore::class.java)
                startActivity(intent)
                true
            }
            else -> {
                (super.onOptionsItemSelected(item))
            }
        }
    }

    private fun update() {
        point += 1
        score.text = ("Score: $point")
    }

    fun loadData() {
        temp_name = sharedPreferences.getString(who, "Anonymous")!!
        temp_score = sharedPreferences.getInt(highscore, 0)
    }

    fun saveData() {
        val editor = sharedPreferences.edit()
        editor.putInt(highscore, point)
        editor.apply()
    }

    private fun savescore() {
        loadData()
        if ((temp_score) < point) {
            saveData()
            val intent = Intent(this, HighScore::class.java)
            intent.putExtra("flag_for_saving", true)
            startActivity(intent)
        }
    }

}
