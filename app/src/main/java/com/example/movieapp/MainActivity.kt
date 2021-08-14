package com.example.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.Adapter.MyAdapter
import com.example.movieapp.Adapter.MySharePreference
import com.example.movieapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreference.init(this)
        var list = MySharePreference.obektString
        myAdapter = MyAdapter(this, list)
        myAdapter.notifyDataSetChanged()
        binding.tv.adapter = myAdapter
        myAdapter.notifyDataSetChanged()

        add_button.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }
    }


    override fun onResume() {
        MySharePreference.init(this)
        var list = MySharePreference.obektString
        myAdapter = MyAdapter(this, list)
        myAdapter.notifyDataSetChanged()
        binding.tv.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
        super.onResume()
    }

}