package com.example.timezoneconverter

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.OffsetDateTime
import java.time.ZoneId
import java.util.*

class LocationMapper {


    companion object MapLocationToTimeZone {

        private lateinit var resultTimeZone: String

        fun getTimeZoneInfo(lat: Double, long: Double): TimeZone? {

            try {
                resultTimeZone = TimeZoneMap.latLngToTimezoneString(lat, long)
                return TimeZone.getTimeZone(resultTimeZone)

            } catch (e: Exception) {
                Log.d("getTimeZone", e.toString())
                Log.d("getTimeZone", "Return default time zone until fix the exception")
                return TimeZone.getDefault()
            }

        }

        fun getTimeZone(lat: Double, long: Double): String {

            try {
                resultTimeZone = TimeZoneMap.latLngToTimezoneString(lat, long)
                return TimeZone.getTimeZone(resultTimeZone).id

            } catch (e: Exception) {
                Log.d("getTimeZone", e.toString())
                return e.toString()
            }

        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getOffset(): String {

            try {
                val zone = ZoneId.of(resultTimeZone)
                val offsetToday = OffsetDateTime.now(zone)
                    .getOffset()
                return offsetToday.toString()

            } catch (e: Exception) {

                Log.d("getOffset", e.toString())
                return e.toString()
            }

        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getOffset(lat: Double, long: Double): String {

            try {
                resultTimeZone = TimeZoneMap.latLngToTimezoneString(lat, long)
                val zone = ZoneId.of(resultTimeZone)
                val offsetToday = OffsetDateTime.now(zone)
                    .getOffset()
                return offsetToday.toString()
            } catch (e: Exception) {

                Log.d("getOffset", e.toString())
                return e.toString()
            }

        }
    }


}