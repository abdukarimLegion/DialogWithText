package com.naa.uz.dialogwithtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.naa.uz.dialogwithtext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            val beginTransaction = supportFragmentManager.beginTransaction()

            val newInstance = CustomTextFragmentDialog.newInstance("Dialog!", "Dialog")

            newInstance.show(supportFragmentManager, "dialog")

            newInstance.setOnClick(object : CustomTextFragmentDialog.OnClick{
                override fun onClick(str: String) {
                    Toast.makeText(this@MainActivity, "$str", Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}