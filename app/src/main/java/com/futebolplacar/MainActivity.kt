package com.futebolplacar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.futebolplacar.adMob.BannerAdMob
import com.futebolplacar.adMob.CondicionalAdmob
import com.futebolplacar.adMob.loadInterstitial
import com.futebolplacar.adMob.removeInterstitial
import com.futebolplacar.adMob.timerAd
import com.futebolplacar.compose.PoliticPrivac
import com.futebolplacar.compose.ArtilhariaCompose
import com.futebolplacar.compose.ClassificacaoGeralCompose
import com.futebolplacar.compose.ColumnavegationCompose
import com.futebolplacar.compose.NavegationBar
import com.futebolplacar.compose.RodadasCompose
import com.futebolplacar.compose.SelectCampeonato
import com.futebolplacar.compose.TopBar
import com.futebolplacar.ui.theme.FutebolPlacarTheme
import com.futebolplacar.viewModel.ViewModelFut
import com.google.android.gms.ads.MobileAds

var countInterstitial by mutableStateOf(0)
var checkTimerAd  by mutableStateOf(false)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        loadInterstitial(this)
        timerAd()
        setContent {

            FutebolPlacarTheme {

                MobileAds.initialize(this){}

                val viewModel by viewModels<ViewModelFut>()

                val navController = rememberNavController()

                val context = LocalContext.current


                CondicionalAdmob()

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier

                    .fillMaxSize(),
                ) {
                    Box(modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFF092B0B), Color(0xFF195E1B)),
                                startX = 0f,
                                endX = 1000f
                            )
                        )
                        .fillMaxSize()
                        .fillMaxSize(),

                        contentAlignment = Alignment.TopStart,

                        ) {

                        Column {

                                TopBar(viewModel, navController)


                            Box(modifier = Modifier.fillMaxSize() ){

                                val interactionSource = remember { MutableInteractionSource() }
                                Column(modifier = Modifier
                                    .clickable(
                                        interactionSource = interactionSource,
                                        indication = null
                                    ) { Armazem.columView = false }
                                    .padding(
                                        bottom = 130.dp
                                    )) {
                                    if(!Armazem.selectCampeonato) {
                                        NavegationBar(navController, viewModel)
                                    }

                                    MyAppNavHost(navController, viewModel)
                                }
                                if (Armazem.columView){
                                    Box(modifier = Modifier.padding(start = 20.dp)){
                                        ColumnavegationCompose(navController, context)

                                    }
                                }
                                Box(modifier = Modifier
                                    .heightIn(max = 400.dp)
                                    .padding(top = 40.dp)
                                    .align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                ) {
                                    BannerAdMob()
                                }
                            }
                        }
                    }

                }

            }

        }

    }

    override fun onDestroy() {
        removeInterstitial()
        super.onDestroy()

    }

}

@Composable
fun MyAppNavHost(
    navController: NavHostController,
    viewModel: ViewModelFut,
    startDestination: String = "selectCampeonato"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("classificacaoGeralCompose") {
            ClassificacaoGeralCompose(viewModel)
        }

        composable("rodadasCompose") { RodadasCompose(viewModel) }

        composable("artilhariaCompose") {ArtilhariaCompose(viewModel)}

        composable("PoliticPrivac") {PoliticPrivac(viewModel)}

        composable("selectCampeonato") {SelectCampeonato(viewModel, navController)}

    }
}

