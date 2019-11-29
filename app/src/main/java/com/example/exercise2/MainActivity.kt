package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<View>(R.id.CalcButton)

        btn.setOnClickListener() {
            try {
                val weight : Double = EnterWeight.text.toString().toDouble()
                val height : Double = EnterHeight.text.toString().toDouble()
                var status : String
                val bmi : Double = weight / (height * height)

                if (bmi  < 18.5){
                    imageView.setImageResource(R.drawable.under)
                    status = "Under"
                }
                else if (bmi <= 24.9){
                    imageView.setImageResource(R.drawable.normal)
                    status = "Normal"
                }
                else {
                    imageView.setImageResource(R.drawable.over)
                    status = "Over"
                }
                BMI.text = "%.2f (%s)".format(bmi, status)
            }catch (ex:Exception) {
                val toast : Toast =  Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0 , 0)
                toast.show()
            }

        }

        val reset = findViewById<View>(R.id.ResetButton)

        reset.setOnClickListener(){
            EnterWeight.text.clear()
            EnterHeight.text.clear()
            BMI.text = null
            imageView.setImageResource(R.drawable.empty)
        }
    }
}
