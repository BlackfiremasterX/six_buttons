package com.example.six_buttons

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlin.random.Random
import kotlin.random.nextInt

class Main : AppCompatActivity() {

    private var soundPool: SoundPool? = null
    private var soundId1: Int = 0
    private var soundId2: Int = 0
    private var soundId3: Int = 0
    private var soundId4: Int = 0
    private var soundId5: Int = 0
    private var soundId6: Int = 0
    var SoundBuffer = Random.nextInt(1..6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<ImageView>(R.id.v_sound_one).setOnClickListener { playSound(1) }
        findViewById<ImageView>(R.id.v_sound_two).setOnClickListener { playSound(2) }
        findViewById<ImageView>(R.id.v_sound_three).setOnClickListener { playSound(3) }
        findViewById<ImageView>(R.id.v_sound_four).setOnClickListener { playSound(4) }
        findViewById<ImageView>(R.id.v_sound_five).setOnClickListener { playSound(5) }
        findViewById<ImageView>(R.id.v_sound_six).setOnClickListener { playSound(6) }

        soundPool = SoundPool(30, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.avto, 1)
        soundId2 = soundPool!!.load(baseContext, R.raw.baraban, 1)
        soundId3 = soundPool!!.load(baseContext, R.raw.magick_one, 1)
        soundId4 = soundPool!!.load(baseContext, R.raw.magick_two, 1)
        soundId5 = soundPool!!.load(baseContext, R.raw.ride_shell, 1)
        soundId6 = soundPool!!.load(baseContext, R.raw.baraban_two_q, 1)


    }

    fun playSound(sound: Int) {
        var soundId = 0
        if (sound != 0) {
            SoundBuffer = sound
        }
        when (SoundBuffer) {
            1 -> soundId = soundId1
            2 -> soundId = soundId2
            3 -> soundId = soundId3
            4 -> soundId = soundId4
            5 -> soundId = soundId5
            6 -> soundId = soundId6
            else -> print("Error!")
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)


    }
}