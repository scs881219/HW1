package com.example.hw1

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.hw1.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            temptransfer(it)
            binding.editTextTextPersonName2.clearFocus()
        }
    }

        private fun temptransfer(view: View){
            var input:Float = binding.editTextTextPersonName2.text.toString().toFloat()

            val formatter = DecimalFormat("#,###.##")

            input = (input - 32) * 5/9

            val output = formatter.format(input)

            binding.textView.text = output.toString()

            //hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

}