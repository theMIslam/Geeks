package com.example.geeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.geeks.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var sheetBehavior: BottomSheetBehavior<View>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutSheet = findViewById<RelativeLayout>(R.id.bottom_sheet_layout)
        val arrowImg = findViewById<AppCompatImageView>(R.id.arrow_top)
        val uName = findViewById<TextView>(R.id.UserName)
        val pNum = findViewById<TextView>(R.id.PhoneNum)
        sheetBehavior = BottomSheetBehavior.from(layoutSheet)
        binding.phoneNumber.setOnEditorActionListener { view, action, keyEvent ->
            if (action == EditorInfo.IME_ACTION_DONE) {
                // here we will do our Stuff
                //we can also add some more logic here
                if (view.text.length == 10){
                    //we can also the below code here
                }
                sheetBehavior.state = (BottomSheetBehavior.STATE_EXPANDED)
                uName.text = binding.Uname.text.toString()
                pNum.text = binding.phoneNumber.text.toString()
                return@setOnEditorActionListener true
            } else false
        }
        arrowImg.setOnClickListener {
            // we will also add out function here
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            } else {
                sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
            uName.text = binding.Uname.text.toString()
            pNum.text = binding.phoneNumber.text.toString()
        }
        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                arrowImg.rotation = slideOffset * 180
            }

        })
    }
}