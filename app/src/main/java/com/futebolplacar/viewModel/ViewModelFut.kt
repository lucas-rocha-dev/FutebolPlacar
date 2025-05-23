package com.futebolplacar.viewModel



import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futebolplacar.Armazem
import com.futebolplacar.datasource.Artilharia
import com.futebolplacar.datasource.ClassificacaoGeralA
import com.futebolplacar.datasource.RodadasA
import com.futebolplacar.firestore.getArtilharia
import com.futebolplacar.firestore.getClassificacaoGeral
import com.futebolplacar.firestore.getRodadaAtual
import com.futebolplacar.firestore.getRodadaById
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelFut: ViewModel() {
    private val _nameWindow = MutableStateFlow(" ")
    val nameWindow = _nameWindow.asStateFlow()

    private val _campeonato = MutableStateFlow("")
    val campeonato = _campeonato.asStateFlow()

    private val _classificacaoGeral = MutableStateFlow<MutableList<ClassificacaoGeralA>>(mutableListOf())
    val classificacaoGeral = _classificacaoGeral.asStateFlow()


    private val _jogosDaRodada = MutableStateFlow<MutableList<RodadasA>>(mutableListOf())
    val jogosDaRodada = _jogosDaRodada.asStateFlow()


    private val _artilharia = MutableStateFlow(Artilharia())
    val artilharia = _artilharia.asStateFlow()


    private val _nRodada = MutableStateFlow(1)
    val nRodada = _nRodada.asStateFlow()

    private val _colorSelectGeral = MutableStateFlow(mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B)))
    val colorSelectGeral = _colorSelectGeral.asStateFlow()
    private val _colorSelectRodadas = MutableStateFlow(mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B)))
    val colorSelectRodadas = _colorSelectRodadas.asStateFlow()
    private val _colorSelectArtilheiros = MutableStateFlow(mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B)))
    val colorSelectArtilheiros = _colorSelectArtilheiros.asStateFlow()



    fun setConfigView(contextExec: String){
        when(contextExec) {
            "selectCampeonato" -> {
                Armazem.selectCampeonato = true

            }
            "classificacaoGeralCompose" -> {
                Armazem.selectCampeonato = false

            }

        }

    }

    fun setCampeonatoAtual(campeonato: String){
        _campeonato.value = campeonato
    }

    fun setNameWindow(name: String){
        _nameWindow.value = name
    }

    fun setClassificacaoGeral(classificacaoGeral:  MutableList<ClassificacaoGeralA>){
        _classificacaoGeral.value = classificacaoGeral
    }

    fun setJogosDaRodada(jogosDaRodadaView:  MutableList<RodadasA>){
        _jogosDaRodada.value = jogosDaRodadaView
    }
    fun setArtilharia(artilharia: Artilharia){
        _artilharia.value = artilharia
    }
    fun setNrodada(nRodada: Int){
        _nRodada.value = nRodada
    }


    fun setFirestore(viewModel: ViewModelFut,
                     request: String
    ) = viewModelScope.launch {
        try {
            var jogosRodadaRef = ""
            var classificacaoRef = ""
            var artilhariaRef= ""
            var rodadaRef= ""

            when(campeonato.value){
                "Brasileiro A" -> {
                    jogosRodadaRef = "jogos_rodada"
                    classificacaoRef = "classificacao_geral"
                    artilhariaRef = "artilharia"
                    rodadaRef= "rodada_atual"


                }
                "Brasileiro B" -> {
                    jogosRodadaRef = "jogos_rodada_b"
                    classificacaoRef = "classificacao_geral_b"
                    artilhariaRef = "artilharia_b"
                    rodadaRef= "rodada_atual_b"
                }
                "La Liga" -> {
                    jogosRodadaRef = "jogos_rodada_la_liga"
                    classificacaoRef = "classificacao_geral_la_liga"
                    artilhariaRef = "artilharia_la_liga"
                    rodadaRef= "rodada_atual_la_liga"
                }
                "Premier" -> {
                    jogosRodadaRef = "jogos_rodada_premier"
                    classificacaoRef = "classificacao_geral_premier"
                    artilhariaRef = "artilharia_premier"
                    rodadaRef= "rodada_atual_premier"
                }
                else -> {
                    Log.e("campeonato atual", "Erro durante a execução")
                }
            }

            val db = FirebaseFirestore.getInstance()
            val docRefRodadas = db.collection(jogosRodadaRef)
            val docRefClassificacaoGeral = db.collection(classificacaoRef)
            val docRefArtilharia = db.collection(artilhariaRef)
            val docRefRodadaAtual = db.collection(rodadaRef)

            if(request == "classficicacaoGeral"){
                getClassificacaoGeral(docRefClassificacaoGeral, viewModel)
            }

            if(request == "rodadas"){
                getRodadaAtual(docRefRodadaAtual, viewModel)
                getRodadaById(docRefRodadas, viewModel)

            }

            if(request == "rodadas click"){
                getRodadaById(docRefRodadas, viewModel)

            }



            if(request == "artilharia"){
                getArtilharia(docRefArtilharia, viewModel)
            }



        } catch (exception: Exception) {
            Log.e("setFirestore", "Erro durante a execução: ${exception.message}", exception)
        }
    }

    fun selectColorNav(selecao: String){
        when(selecao){
            "Geral" -> {
                _colorSelectGeral.value = mutableListOf(Color(0xFF138519), Color(0xFF27912E))
                _colorSelectRodadas.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
                _colorSelectArtilheiros.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
            }
            "Rodadas" -> {
                _colorSelectGeral.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
                _colorSelectRodadas.value = mutableListOf(Color(0xFF138519), Color(0xFF27912E))
                _colorSelectArtilheiros.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
            }
            "Artilheiros" -> {
                _colorSelectGeral.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
                _colorSelectRodadas.value = mutableListOf(Color(0xFF092B0B), Color(0xFF092B0B))
                _colorSelectArtilheiros.value = mutableListOf(Color(0xFF138519), Color(0xFF27912E))
            }
        }
    }


}

