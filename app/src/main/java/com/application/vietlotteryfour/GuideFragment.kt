package com.application.vietlotteryfour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class GuideFragment : Fragment(), View.OnClickListener {

    private var btn1 : TextView? = null
    private var btn2 : TextView? = null
    private var btn3 : TextView? = null
    private var btn4 : TextView? = null
    private var btn5 : TextView? = null
    private var btn6 : TextView? = null
    private var btn7  : TextView? = null

    private var getView : View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        getView = inflater.inflate(R.layout.fragment_guide, container, false)

        initComponents()
        initListener()
        return getView
    }
    private fun initComponents(){
        btn1 = getView?.findViewById(R.id.btn1)
        btn2 = getView?.findViewById(R.id.btn2)
        btn3 = getView?.findViewById(R.id.btn3)
        btn4 = getView?.findViewById(R.id.btn4)
        btn5 = getView?.findViewById(R.id.btn5)
        btn6 = getView?.findViewById(R.id.btn6)
        btn7 = getView?.findViewById(R.id.btn7)
    }
    private fun initListener(){
        btn1?.setOnClickListener(this)
        btn2?.setOnClickListener(this)
        btn3?.setOnClickListener(this)
        btn4?.setOnClickListener(this)
        btn5?.setOnClickListener(this)
        btn6?.setOnClickListener(this)
        btn7?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn1 ->{Navigator.showContent(context,getString(R.string.g11))}
            R.id.btn2 ->{Navigator.showContent(context,getString(R.string.g22))}
            R.id.btn3 ->{Navigator.showContent(context,getString(R.string.g33))}
            R.id.btn4 ->{Navigator.showContent(context,getString(R.string.g44))}
            R.id.btn5 ->{Navigator.showContent(context,getString(R.string.g55))}
            R.id.btn6 ->{Navigator.showContent(context,getString(R.string.g66))}
            R.id.btn7 ->activity?.onBackPressed()
        }
    }
}