package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.Adapter.MySharePreference
import com.example.movieapp.databinding.ActivityAddBinding
import com.example.movieapp.models.User

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreference.init(this)
        binding.btnAdd.setOnClickListener {
            var name = binding.edtName.text.toString()
            var actor = binding.edtAuthors.text.toString()
            var info = binding.edtAbout.text.toString()
            var date = binding.edtData.text.toString()

            var list = MySharePreference.obektString

            if (name!=""&&actor!=""&&info!=""&&date!=""){
                list.add(User(name, actor, date, info))
                MySharePreference.obektString = list
                Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Ma`lumot kam", Toast.LENGTH_SHORT).show()
            }

        }

    }
}