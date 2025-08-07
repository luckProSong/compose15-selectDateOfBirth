package com.example.selectdateofbirth

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class CommonApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
    }
}