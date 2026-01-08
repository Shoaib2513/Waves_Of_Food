package com.example.wavesoffood

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wavesoffood.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding : ActivityChooseLocationBinding by lazy{
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val locatioinList = arrayOf("Jaipur","Odisha","Delhi","Hydrabad","Mumbai","Noida")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locatioinList)
        val autoCompleteTextView = binding.listOfLocatioin
        autoCompleteTextView.setAdapter(adapter)

    }
}