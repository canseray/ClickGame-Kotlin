package com.example.clickgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score: Int = 0

    var imageArray = ArrayList<ImageView>()

    var handler : Handler = Handler()
    var runnable : Runnable = Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        hideImages()

        imageArray = arrayListOf(but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,but11,but12,but13,but14,but15,but16)

        object : CountDownTimer(30000, 1000) {
            override fun onFinish() {
                timeText.text = "Time is off"

                handler.removeCallbacks(runnable)

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

            }

            override fun onTick(p0: Long) {
                timeText.text = "Time: " + p0 / 1000
            }
        }.start()

    }






    fun hideImages(){

        runnable = object  : Runnable {
            override fun run() {
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(8-0)
                imageArray[index].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }

    handler.post(runnable)

    }





    fun increateScore (view: View){

        score++

        scoreText.text = "Score: " + score

    }


}
