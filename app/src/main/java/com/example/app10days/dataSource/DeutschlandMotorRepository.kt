package com.example.app10days.dataSource

import android.util.Log
import com.example.app10days.model.DeutschlandMotor
import com.google.firebase.firestore.FirebaseFirestore

class DeutschlandMotorRepository {

    private val TAG = "DataSource"

    private val COLECCION_VEHICULOS = "vehiculos"
    private val CAMPO_MARCA = "marca"
    private val CAMPO_MODELO = "modelo"
    private val CAMPO_POTENCIA = "potencia"
    private val CAMPO_PRECIO = "precio"
    private val CAMPO_IMAGEN = "imagen"

    private val db = FirebaseFirestore.getInstance()

    private val vehiculos = db.collection(COLECCION_VEHICULOS)

    fun getVehiculos(setLista: (List<DeutschlandMotor>) -> Unit) {

        val listaVehiculos = mutableListOf<DeutschlandMotor>()

        vehiculos.get().addOnSuccessListener { documents ->

            for (document in documents) {
                val marca = document.getString(CAMPO_MARCA) ?: ""
                val modelo = document.getString(CAMPO_MODELO) ?: ""
                val potencia = document.getString(CAMPO_POTENCIA) ?: ""
                val precio = document.getString(CAMPO_PRECIO) ?: ""
                val imagen = document.getString(CAMPO_IMAGEN) ?: ""

                val vehiculo = DeutschlandMotor(marca, modelo, potencia, precio, imagen)
                listaVehiculos.add(vehiculo)

                Log.i(TAG, "------> VEHÍCULO: $modelo")
            }

            setLista(listaVehiculos)
        }.addOnFailureListener { e ->
            Log.e(TAG, "Error al obtener datos de Firestore: ${e.message}", e)
        }
    }

}