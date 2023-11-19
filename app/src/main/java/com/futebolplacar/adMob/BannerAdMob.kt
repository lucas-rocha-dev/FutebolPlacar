package com.futebolplacar.adMob

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAdMob(){
    Box(modifier = Modifier
        .height(101.dp))

    {
        //ca-app-pub-3348435305370965/1753908718 id real
        //ca-app-pub-3940256099942544/6300978111 id for  test

        val adIdBanner = "ca-app-pub-3348435305370965/1753908718"

        val adWidth = LocalConfiguration.current.screenWidthDp
        val adHeight = 100
        AndroidView(
            factory = {context->
                val adView = AdView(context)
                adView.setAdSize(AdSize(adWidth , adHeight))
                adView.apply {
                    adUnitId = adIdBanner
                    loadAd(AdRequest.Builder().build())
                }

            })
    }
}