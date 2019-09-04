package com.example.timezoneproject

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.timezoneconverter.LocationMapper

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LocationMapper", LocationMapper.getTimeZone(21.280417, 39.205312))
        Log.d("LocationMapper", LocationMapper.getOffset())
        Log.d("LocationMapper", LocationMapper.getOffset(40.463669, -3.749220))
        Log.d("LocationMapper", LocationMapper.getTimeZoneInfo(-25.274399, 133.775131).toString())
    }
}
