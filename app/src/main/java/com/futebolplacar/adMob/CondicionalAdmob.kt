package com.futebolplacar.adMob

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.futebolplacar.checkTimerAd
import com.futebolplacar.countInterstitial

@Composable
fun CondicionalAdmob(){
    val context = LocalContext.current
    LaunchedEffect(countInterstitial){
        if (checkTimerAd && countInterstitial > 6){
            countInterstitial = 0
            checkTimerAd = false
            showInterstitial(context){}

        }
    }
}

fun timerAd() {
    val interval = 7 * 60 * 1000L //  (7 minuts)

    val handler = Handler(Looper.getMainLooper())
    val runnable = object : Runnable {
        override fun run() {
            checkTimerAd = true
            handler.postDelayed(this, interval)
        }
    }

    handler.post(runnable)
}