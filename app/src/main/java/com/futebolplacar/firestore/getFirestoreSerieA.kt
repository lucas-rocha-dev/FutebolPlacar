package com.futebolplacar.firestore

import android.util.Log
import com.futebolplacar.datasource.Artilharia
import com.futebolplacar.datasource.ClassificacaoGeralA
import com.futebolplacar.datasource.Jogo
import com.futebolplacar.datasource.Posicao
import com.futebolplacar.datasource.RodadasA
import com.futebolplacar.viewModel.ViewModelFut
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


suspend fun getClassificacaoGeral(docRef: CollectionReference, viewModel: ViewModelFut) {
    try {
        val documents = docRef.get().await()

        val classificacaoGeralList = mutableListOf<ClassificacaoGeralA>()

        for (document in documents) {
            val id = document.id
            val p = document.getString("P") ?: ""
            val j = document.getString("J") ?: ""
            val v = document.getString("V") ?: ""
            val e = document.getString("E") ?: ""
            val d = document.getString("D") ?: ""
            val gp = document.getString("GP") ?: ""
            val gc = document.getString("GC") ?: ""
            val sg = document.getString("SG") ?: ""
            val porcentagem = document.getString("%") ?: ""

            val classificacaoGeral = ClassificacaoGeralA(id, p, j, v, e, d, gp, gc, sg, porcentagem)
            classificacaoGeralList.add(classificacaoGeral)
        }

        withContext(Dispatchers.Main) {
            val listOrnanizada = organizeRank(classificacaoGeralList, viewModel)
            viewModel.setClassificacaoGeral(listOrnanizada)
            Log.d("getFirestore", "getClassificacaoGeral executado com sucesso!")
        }

    } catch (exception: Exception) {
        withContext(Dispatchers.Main) {
            Log.w("getFirestore", "Erro ao acessar classficacao_geral no firestore", exception)
        }
    }
}


suspend fun getArtilharia(docRef: CollectionReference, viewModel: ViewModelFut){
    val artilharia: List<DocumentSnapshot> = docRef.get().await().documents



    val artilhariaObjeto = mutableListOf<Posicao>()
    for (artilheiros in artilharia){
        val jogador = Posicao(
            rank = artilheiros.id,
            jogador = artilheiros.getString("jogador").toString(),
            time = artilheiros.getString("time").toString(),
            gols = artilheiros.getString("gols").toString()
        )
        artilhariaObjeto.add(jogador)

    }

    viewModel.setArtilharia(Artilharia(artilhariaObjeto))


}

suspend fun getRodadaAtual(docRef: CollectionReference, viewModel: ViewModelFut) {
    val rodadaAtual: List<DocumentSnapshot> = docRef.get().await().documents

    var nRodada = ""
    for (rodada in rodadaAtual) {
        val getRodada = rodada.getString("rodada_atual").toString()
        nRodada = getRodada
    }

    viewModel.setNrodada(nRodada.toInt() - 1)

}

fun organizeRank(classificacaoGeralList: MutableList<ClassificacaoGeralA>,
                 viwModel: ViewModelFut): MutableList<ClassificacaoGeralA>{
    var newList = classificacaoGeralList

    when(val campeonato = viwModel.campeonato.value){
        "Brasileiro A" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.gp.toInt() }
                .sortedByDescending { it.sg.toInt() }
                .sortedByDescending { it.v.toInt() }
                .sortedByDescending { it.p.toInt() }
                .toMutableList()

            Log.i("campeonato", "Verific 1${campeonato}")


        }
        "Brasileiro B" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.gp.toInt() }
                .sortedByDescending { it.sg.toInt() }
                .sortedByDescending { it.v.toInt() }
                .sortedByDescending { it.p.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 2${campeonato}")

        }
        "La Liga" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.v.toInt() }
                .sortedByDescending { it.gp.toInt() }
                .sortedByDescending { it.sg.toInt() }
                .sortedByDescending { it.p.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 3${campeonato}")
        }
        "Premier" ->    {
            newList = newList
                .asSequence()
                .sortedByDescending { it.v.toInt() }
                .sortedByDescending { it.gp.toInt() }
                .sortedByDescending { it.sg.toInt() }
                .sortedByDescending { it.p.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 4${campeonato}")
        }
    }

    return newList

}

suspend fun getRodadaById(docRef: CollectionReference, viewModel: ViewModelFut){
    val rodadaAtual = (viewModel.nRodada.value + 1).toString()
    val doc = docRef.document(rodadaAtual).get().await()

    val rodadasObjeto = mutableListOf<RodadasA>()

        val rodadaId = doc.id
        val listaJogo = mutableListOf<Jogo>()


        val partidasRef = doc.reference.collection("partidas")
        val partidas: List<DocumentSnapshot> = partidasRef.get().await().documents

        for (jogos in partidas){

            val jogosObjeto = Jogo(
                nJogo = jogos.id,
                dataLocal = jogos.getString("data_local").toString(),
                timeA = jogos.getString("Time_A").toString(),
                golsA = jogos.getString("Gols_A").toString(),
                timeB =  jogos.getString("Time_B").toString(),
                golsB = jogos.getString("Gols_B").toString()
            )
            listaJogo.add(jogosObjeto)

        }
        val rodadasGet = RodadasA(rodadaId, listaJogo)
        rodadasObjeto.add(rodadasGet)

    viewModel.setJogosDaRodada(rodadasObjeto)
    Log.i("getRodadaById", "${viewModel.jogosDaRodada.value}")
}