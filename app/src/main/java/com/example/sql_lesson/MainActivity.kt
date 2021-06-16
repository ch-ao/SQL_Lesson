package com.example.sql_lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.sql_lesson.databinding.ActivityMainBinding
import com.example.sql_lesson.db.MyDbManager

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickSave(view: View){
        binding.tvTest.text = ""
        myDbManager.openDb()
        myDbManager.insertToDb(binding.edTitle.text.toString(),binding.edContent.text.toString())
        val dataList = myDbManager.readDbData()
        for (item in dataList){
            binding.tvTest.append(item)
            binding.tvTest.append("\n")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}