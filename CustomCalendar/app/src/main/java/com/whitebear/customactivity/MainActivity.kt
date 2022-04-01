package com.whitebear.customactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import java.time.Month

class MainActivity : AppCompatActivity() {
    private lateinit var monthAdapter: MonthAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }
    fun setListener(){
        initCalendar()
    }
    fun initCalendar(){
        var date = arrayListOf<String>("2022년 04월 01일","2021년 03월 28일","2021년 04월 09일","2021년 04월 18일")

        monthAdapter = MonthAdapter(this, date)
        findViewById<RecyclerView>(R.id.customCalendar).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = monthAdapter
            scrollToPosition(Int.MAX_VALUE/2)
        }
        val snap = PagerSnapHelper()
        if(findViewById<RecyclerView>(R.id.customCalendar).onFlingListener == null){
            snap.attachToRecyclerView(findViewById<RecyclerView>(R.id.customCalendar))
        }
    }
}