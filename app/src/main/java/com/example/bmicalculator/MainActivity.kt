package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.bmicalculator.databinding.ActivityMainBinding
import java.lang.Math.pow
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            doneButton.setOnClickListener() {
                try {
                    val weight = inputWeight.text.toString().toDouble()
                    val height = inputHeight.text.toString().toDouble()

                    val bmi = weight / height.pow(2)

                    if (bmi < 18.5) {
                        imageView.setImageResource(R.drawable.under)
                        textWeight.text = "Underweight. BMI: %.2f".format(bmi)
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        imageView.setImageResource(R.drawable.normal)
                        textWeight.text = "Normal. BMI: %.2f".format(bmi)
                    } else if (bmi > 24.9) {
                        imageView.setImageResource(R.drawable.over)
                        textWeight.text = "Overweight. BMI: %.2f".format(bmi)
                    } else {
                        imageView.setImageResource(R.drawable.empty)
                        textWeight.text = "Default"
                    }
                }
                catch(ex:Exception){
                    val toast: Toast = Toast.makeText(this@MainActivity, "Invalid input", Toast.LENGTH_LONG)

                    toast.setGravity(Gravity.CENTER, 0,0)
                    toast.show()
                }
            }

            resetButton.setOnClickListener() {
                inputWeight.setText("")
                inputHeight.setText("")
                textWeight.setText("")
                imageView.setImageResource(R.drawable.empty)
            }
        }
    }


}
