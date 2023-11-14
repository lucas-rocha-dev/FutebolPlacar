package com.futebolplacar.datasource

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


fun TesteDB() {

    val db = FirebaseFirestore.getInstance()

    db.collection("classificacao_geral")
        .get()
        .addOnSuccessListener { querySnapshot  ->
            val listaDocumentos = mutableListOf<DocumentSnapshot>()
            for (document in querySnapshot .documents) {
                // Adiciona cada DocumentSnapshot à lista
                listaDocumentos.add(document)
            }
            Log.d("TesteDB", listaDocumentos[0].data.toString())

            if (querySnapshot  != null){


                Log.d("TesteDB", "Sucesso $querySnapshot ") // Usando Log.d para mensagens de debug
            } else {
                Log.d("TesteDB", "Documento não encontrado")
            }
        }
        .addOnFailureListener {e ->
            Log.e("TesteDB", "Ocorreu um erro: $e") // Usando Log.e para mensagens de erro

        }

}


