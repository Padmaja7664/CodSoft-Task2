package com.example.codsoft_task2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //numbers entered by the user
    var num1=0.0
    var num2=0.0

    //textview to display the result
    lateinit var str:TextView

    //initailly all the operation are set to false
    var addition=false
    var subtract=false
    var divide=false
    var multiply=false
    var remainder=false
    var decimal = false

    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var buttonAdd: Button
    lateinit var buttonSub: Button
    lateinit var buttonMul: Button
    lateinit var buttonDivision: Button
    lateinit var buttonEqual: Button
    lateinit var buttonDel: Button
    lateinit var buttonDot: Button
    lateinit var Remainder: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get the Textview from its id
        str=findViewById(R.id.numId)


        //find all the buttons from its id
        button0 = findViewById(R.id.btn0)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)
        button4 = findViewById(R.id.btn4)
        button5 = findViewById(R.id.btn5)
        button6 = findViewById(R.id.btn6)
        button7 = findViewById(R.id.btn7)
        button8 = findViewById(R.id.btn8)
        button9 = findViewById(R.id.btn9)
        buttonDot = findViewById(R.id.btnDot)
        buttonAdd = findViewById(R.id.btnAdd)
        buttonSub = findViewById(R.id.btnSub)
        buttonMul = findViewById(R.id.btnMul)
        buttonDivision = findViewById(R.id.btnDiv)
        Remainder = findViewById(R.id.btnRem)
        buttonDel = findViewById(R.id.btnClear)
        buttonEqual = findViewById(R.id.btnEqual)

        //get the user input and store it in the form of string

        button0.setOnClickListener {
            str.text=str.text.toString()+"0"
        }
        button1.setOnClickListener {
            str.text=str.text.toString()+"1"
        }
        button2.setOnClickListener {
            str.text=str.text.toString()+"2"
        }
        button3.setOnClickListener {
            str.text=str.text.toString()+"3"
        }
        button4.setOnClickListener {
            str.text=str.text.toString()+"4"
        }
        button5.setOnClickListener {
            str.text=str.text.toString()+"5"
        }
        button6.setOnClickListener {
            str.text=str.text.toString()+"6"
        }
        button7.setOnClickListener {
            str.text=str.text.toString()+"7"
        }
        button8.setOnClickListener {
            str.text=str.text.toString()+"8"
        }
        button9.setOnClickListener {
            str.text=str.text.toString()+"9"
        }


        //when user press the operator button, convert the string into number store it in num1

        buttonAdd.setOnClickListener {
            if (str.text.isNotEmpty()) {
                num1 = str.text.toString().toDouble()
                addition = true
                decimal = false
                str.text = ""
            }
        }

        buttonSub.setOnClickListener {
            if (str.text.isNotEmpty()) {
                num1 = str.text.toString().toDouble()
                subtract = true
                decimal = false
                str.text = ""
            }
            //for negative numbers
            if(str.text.isEmpty()){
                str.text=str.text.toString()+"-"
            }
        }

        buttonMul.setOnClickListener {
            if (str.text.isNotEmpty()) {
                num1 = str.text.toString().toDouble()
                multiply = true
                decimal = false
                str.text = ""
            }
        }

        buttonDivision.setOnClickListener {
            if (str.text.isNotEmpty()) {
                num1 = str.text.toString().toDouble()
                divide = true
                decimal = false
                str.text = ""
            }
        }

        Remainder.setOnClickListener {
            if (str.text.isNotEmpty()) {
                num1 = str.text.toString().toDouble()
                remainder = true
                decimal = false
                str.text = ""
            }
        }


        //when user press the equal button, convert the string into number and store it in num2
        buttonEqual.setOnClickListener {
            if (addition || subtract || divide || remainder || multiply) {
                num2 = str.text.toString().toDouble()
            }

            if (addition) {
                str.text = (num1).toString()+"+"+num2.toString()+"="+(num1 + num2).toString()
                addition = false
            }

            if (subtract) {
                str.text = (num1).toString()+"-"+num2.toString()+"="+(num1 - num2).toString()
                subtract = false
            }

            if (multiply) {
                str.text = (num1).toString()+"*"+num2.toString()+"="+(num1 * num2).toString()
                multiply = false
            }

            if (divide) {
                str.text = (num1).toString()+"/"+num2.toString()+"="+(num1 / num2).toString()
                divide = false
            }

            if (remainder) {
                str.text = (num1).toString()+"%"+num2.toString()+"="+(num1 % num2).toString()
                remainder = false
            }

        }

        //clear all when user press delete button
        buttonDel.setOnClickListener {
            str.text = ""
            num1 = 0.0
            num2 = 0.0
        }


        //check for decimal numbers
         //  if a number is alredy decimal then show a message to user
        buttonDot.setOnClickListener {
            if (!decimal) {
                str.text = str.text.toString() + "."
                decimal = true
            }
            else{
                Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show()
            }
        }


    }
}