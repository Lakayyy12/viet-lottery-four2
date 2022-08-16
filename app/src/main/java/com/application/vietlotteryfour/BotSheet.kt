package com.application.vietlotteryfour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.application.vietlotteryfour.Navigator.Companion.replaceFragment

class BotSheet : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_sheet)
        replaceFragment(GuideFragment(), supportFragmentManager)
    }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
