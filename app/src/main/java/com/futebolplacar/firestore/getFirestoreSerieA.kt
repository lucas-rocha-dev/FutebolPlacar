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
            val P = document.getString("P") ?: ""
            val J = document.getString("J") ?: ""
            val V = document.getString("V") ?: ""
            val E = document.getString("E") ?: ""
            val D = document.getString("D") ?: ""
            val GP = document.getString("GP") ?: ""
            val GC = document.getString("GC") ?: ""
            val SG = document.getString("SG") ?: ""
            val porcentagem = document.getString("%") ?: ""

            val classificacaoGeral = ClassificacaoGeralA(id, P, J, V, E, D, GP, GC, SG, porcentagem)
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


suspend fun getRodadas(docRef: CollectionReference, viewModel: ViewModelFut){
    val rodadas: List<DocumentSnapshot> = docRef.get().await().documents

    val rodadasObjeto = mutableListOf<RodadasA>()

    for (rodada in rodadas){
        val rodadaId = rodada.id
        val listaJogo = mutableListOf<Jogo>()


        val partidasRef = rodada.reference.collection("partidas")
        val partidas: List<DocumentSnapshot> = partidasRef.get().await().documents

        for (jogos in partidas){

            val jogosObjeto = Jogo(
                n_jogo = jogos.id,
                data_local = jogos.getString("data_local").toString(),
                Time_A = jogos.getString("Time_A").toString(),
                Gols_A = jogos.getString("Gols_A").toString(),
                Time_B =  jogos.getString("Time_B").toString(),
                Gols_B = jogos.getString("Gols_B").toString()
            )
            listaJogo.add(jogosObjeto)

        }
       val rodadas = RodadasA(rodadaId, listaJogo)
       rodadasObjeto.add(rodadas)

    }

    viewModel.setJogosDaRodada(rodadasObjeto)

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

   //Armazem.artilharia = Artilharia(artilhariaObjeto)
    viewModel.setArtilharia(Artilharia(artilhariaObjeto))



}

suspend fun getRodadaAtual(docRef: CollectionReference, viewModel: ViewModelFut) {
    val rodadaAtual: List<DocumentSnapshot> = docRef.get().await().documents
    var n_rodada = ""
    for (rodada in rodadaAtual) {
        val getRodada = rodada.getString("rodada_atual").toString()
        n_rodada = getRodada
    }

    //Armazem.n_rodada = n_rodada.toInt() - 1
    viewModel.setNrodada(n_rodada.toInt() - 1)

    Log.d("getFirestore", "getRodadaAtual executado com sucesso: ${n_rodada}")
}

fun organizeRank(classificacaoGeralList: MutableList<ClassificacaoGeralA>,
                 viwModel: ViewModelFut): MutableList<ClassificacaoGeralA>{
    var newList = classificacaoGeralList
    val campeonato = viwModel.campeonato.value

    when(campeonato){
        "Brasileiro A" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.GP.toInt() }
                .sortedByDescending { it.SG.toInt() }
                .sortedByDescending { it.V.toInt() }
                .sortedByDescending { it.P.toInt() }
                .toMutableList()

            Log.i("campeonato", "Verific 1${campeonato}")


        }
        "Brasileiro B" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.GP.toInt() }
                .sortedByDescending { it.SG.toInt() }
                .sortedByDescending { it.V.toInt() }
                .sortedByDescending { it.P.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 2${campeonato}")

        }
        "La Liga" -> {
            newList = newList
                .asSequence()
                .sortedByDescending { it.V.toInt() }
                .sortedByDescending { it.GP.toInt() }
                .sortedByDescending { it.SG.toInt() }
                .sortedByDescending { it.P.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 3${campeonato}")
        }
        "Premier" ->    {
            newList = newList
                .asSequence()
                .sortedByDescending { it.V.toInt() }
                .sortedByDescending { it.GP.toInt() }
                .sortedByDescending { it.SG.toInt() }
                .sortedByDescending { it.P.toInt() }
                .toMutableList()
            Log.i("campeonato", "Verific 4${campeonato}")
        }
    }

    return newList

}