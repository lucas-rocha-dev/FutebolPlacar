package com.futebolplacar.viewModel



import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futebolplacar.Armazem
import com.futebolplacar.datasource.Artilharia
import com.futebolplacar.datasource.ClassificacaoGeralA
import com.futebolplacar.datasource.RodadasA
import com.futebolplacar.firestore.getArtilharia
import com.futebolplacar.firestore.getClassificacaoGeral
import com.futebolplacar.firestore.getRodadaAtual
import com.futebolplacar.firestore.getRodadas
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

    private val _carregandoServe = MutableStateFlow(false)
    val carregandoServe = _carregandoServe.asStateFlow()




    fun setCarregandoServe(contextExec: String){
        when(contextExec) {
            "selectCampeonato" -> {
                _carregandoServe.value = true
                Armazem.selectCampeonato = true
            }
            "classificacaoGeralCompose" -> {
                _carregandoServe.value = false
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

    fun setJogosDaRodada(jogosDaRodada:  MutableList<RodadasA>){
        _jogosDaRodada.value = jogosDaRodada
    }
    fun setArtilharia(artilharia: Artilharia){
        _artilharia.value = artilharia
    }
    fun setNrodada(nRodada: Int){
        _nRodada.value = nRodada
    }


    fun setFirestore(
        jogosRodadaRef: String,
        classificacaoRef: String,
        artilhariaRef: String,
        rodadaRef: String,
        viewModel: ViewModelFut
    ) = viewModelScope.launch {
        try {
            val db = FirebaseFirestore.getInstance()
            val docRefRodadas = db.collection(jogosRodadaRef)
            val docRefClassificacaoGeral = db.collection(classificacaoRef)
            val docRefArtilharia = db.collection(artilhariaRef)
            val docRefRodadaAtual = db.collection(rodadaRef)

            getRodadas(docRefRodadas, viewModel)
            getClassificacaoGeral(docRefClassificacaoGeral, viewModel)
            getArtilharia(docRefArtilharia, viewModel)
            getRodadaAtual(docRefRodadaAtual, viewModel)

        } catch (exception: Exception) {
            Log.e("setFirestore", "Erro durante a execução: ${exception.message}", exception)
        }
    }

}

