package com.application.vietlotteryfour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Details>

    private lateinit var imageId : Array<Int>
    private lateinit var heading : Array<String>
    private lateinit var briefNews : Array<String>

    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    private var btnS : TextView? = null
    private var exit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo)
        heading = arrayOf(
            getString(R.string.m1),
            getString(R.string.m2),
            getString(R.string.m3),
            getString(R.string.m4),
            getString(R.string.m5)
        )
        briefNews = arrayOf(
            getString(R.string.m01),
            getString(R.string.m02),
            getString(R.string.m03),
            getString(R.string.m04),
            getString(R.string.m05)
        )
        newRecyclerView = findViewById(R.id.recyclerItems)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Details>()
        getUserdata()

        btnS = findViewById(R.id.btnS)
        btnS?.setOnClickListener{
            val intent = Intent(this, BotSheet::class.java)
            startActivity(intent)
        }

        //init actionbar
        loadCards()

        //add page change listener
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                //change title of actionbar
                var title = myModelList[position].title
            }
            override fun onPageSelected(position: Int) {
            }
            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        //add items/data to list+

        myModelList.add(MyModel(
            "Chọn một xổ số để tham gia",
            R.string.m10,
            R.drawable.lotto))
        myModelList.add(MyModel(
            "Chọn số của bạn",
            R.string.m11,
            R.drawable.lotto))
        myModelList.add(MyModel(
            "Mua vé",
            R.string.m12,
            R.drawable.lotto))
        myModelList.add(MyModel(
            "Kiểm tra số của bạn",
            R.string.m13,
            R.drawable.lotto))
        myModelList.add(MyModel(
            "Nhận giải thưởng của bạn",
            R.string.m14,
            R.drawable.lotto))
        myModelList.add(MyModel(
            "Đại lý vé số là gì?",
            R.string.m15,
            R.drawable.lotto))

        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        // set default padding
        viewPager.setPadding(100,0,100,0)
    }

private fun getUserdata() {

    for(i in imageId.indices){

        val news = Details(imageId[i], heading[i],briefNews[i])
        newArrayList.add(news)
    }
    val adapter = MyAdapter2(newArrayList)
    newRecyclerView.adapter = adapter
}

    override fun onBackPressed() {
        if (exit==0){
            exit = 1
            Toast.makeText(this,"BẤM ĐÔI ĐỂ Thoát", Toast.LENGTH_SHORT).show()
        }else{
            super.finishAffinity()
        }
    }
}