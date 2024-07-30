package com.example.myviews

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.ListViewbtn.setOnClickListener {
            var intent= Intent(this,ListViewActivity::class.java)
            startActivity(intent)
        }


        binding.SpinnerViewbtn.setOnClickListener {
            var intent= Intent(this,SpinnerViewActivity::class.java)
            startActivity(intent)
        }

        binding.ListBaseAdapter.setOnClickListener {
            var intent= Intent(this,ListBaseAdapterActivity::class.java)
            startActivity(intent)

        }




    }
}