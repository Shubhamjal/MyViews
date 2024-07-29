package com.example.myviews

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviews.databinding.ActivitySpinnerViewBinding

class SpinnerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivitySpinnerViewBinding  //Activity binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=ActivitySpinnerViewBinding.inflate(layoutInflater)   //implementing
        setContentView(binding.root)

        setContentView(R.layout.activity_spinner_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.Spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selectedItem=binding.Spinner.selectedItem as String
                Toast.makeText(this@SpinnerViewActivity,"@selectedItem",Toast.LENGTH_SHORT).show()

                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.FabBtn2.setOnClickListener{
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.activity_addbtndialog)

        }
    }
}