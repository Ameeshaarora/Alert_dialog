package com.ameesha.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    //variable declaration
    var etName: EditText? = null
    var etHeight: EditText? = null
    var etRollNo: EditText? = null
    var btnValidate: Button? = null
    var btnalert : Button ?= null
    var btnSimpleListAlertDialog : Button ?= null
    var btnCheckboxListAlertDialog : Button ?= null
    var btnCustomDialog : Button ?= null

    var simpleList = arrayOf("Black", "Blue", "Red", "Green")
    override fun
            onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initialization
        etName = findViewById(R.id.etName)
        etHeight = findViewById(R.id.etHeight)
        etRollNo = findViewById(R.id.etRollno)
        btnValidate = findViewById(R.id.btnvalidate)
        btnalert = findViewById(R.id.btnalert)
        btnSimpleListAlertDialog = findViewById(R.id.btnSimpleListAlertDialog)
        btnCheckboxListAlertDialog = findViewById(R.id.btnCheckboxListAlertDialog)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)
        //operation perform

        btnValidate?.setOnClickListener(View.OnClickListener { })
        btnValidate?.setOnClickListener {
            if (etName?.text.toString().isNullOrEmpty()) {
                etName?.error = "Enter your name"
            } else if (etRollNo?.text?.toString().isNullOrEmpty()) {
                etRollNo?.error = "Enter your rollno"
            } else if (etHeight?.text?.toString().isNullOrEmpty()) {
                etHeight?.error = "Enter your height"
            } else {
                Toast.makeText(
                    this,
                    "Validation completed",
                    Toast.LENGTH_SHORT
                ).show()
                //toast short length - 2 seconds and long = 3.5 seconds
                //Intent - source class, destination class
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        btnalert?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is simple list alert")
                .setMessage("This is simple list alert message")
                .setPositiveButton("ok"){_,_->
                    Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()

                }

                }
        btnSimpleListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("This is simple list alert")
                //.setMessage("This is simple list alert message")
                .setItems(simpleList, {_, position->
                    Toast.makeText(this, "Clicked Item ${simpleList[position]}", Toast.LENGTH_SHORT).show()
                })
                .show()
        }

        btnCheckboxListAlertDialog?.setOnClickListener {
            AlertDialog.Builder(this)
                .setMultiChoiceItems(simpleList,booleanArray, {_, position, isChecked->
                    Toast.makeText(this, "position $position isChecked $isChecked", Toast.LENGTH_LONG).show()
                    System.out.println("position $position isChecked $isChecked")
                })
                .setPositiveButton("Ok", {_,_->
                    var selectedColor = ""
                    for(i in 0..booleanArray.size-1){
                        if(booleanArray[i] == true){
                            selectedColor = selectedColor+ simpleList[i] +" "
                        }
                    }
                    tvSelectedColors?.setText(selectedColor)
                })
                .show()
        }

        btnCustomDialog?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.custom_dialog_layout)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.show()
            var btnGetName : Button = dialog.findViewById(R.id.btnGetName)
            var etname : EditText = dialog.findViewById(R.id.etName)

            btnGetName.setOnClickListener {
                if(etname.text.toString().isNullOrEmpty()){
                    etname.error = "Enter your name"
                }else{
                    btnCustomDialog?.setText(etname.text.toString())
                    dialog.dismiss()

                }
            }

        }

        }
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(this, " on Start Called", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "on resume called", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "on Pause called", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "on stop called", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {

        super.onDestroy()
        Toast.makeText(this, "on Destroy called", Toast.LENGTH_SHORT).show()
    }

    //functions
}