package com.example.movieapp

import RvModels.Position
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.Adapter.MySharePreference
import com.example.movieapp.databinding.ActivityAboutBinding
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        MySharePreference.init(this)
        var list = MySharePreference.obektString
        val position = Position.position

        text_name_title.text = list[position].name

        binding.name.text = "Movie Name: ${list[position].name}"
        binding.about.text = "About movie: ${list[position].info}"
        binding.actor.text = "Movie Authors: ${list[position].actor}"
        binding.date.text = "Date:  "+list[position].date

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}