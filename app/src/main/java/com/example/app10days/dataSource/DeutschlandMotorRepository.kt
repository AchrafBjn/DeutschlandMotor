package com.example.app10days.dataSource

import com.example.app10days.R
import com.example.app10days.model.DeutschlandMotor

class DeutschlandMotorRepository {
    fun getVehiculos(): List<DeutschlandMotor> {
        return listOf(
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rs3,
                image = R.drawable.rs3,
                potencia = R.string.potenciaRs3,
                precio = R.string.precioRs3
            ),
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rs4,
                image = R.drawable.rs4,
                potencia = R.string.potenciaRs4,
                precio = R.string.precioRs4
            ),
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rs5,
                image = R.drawable.rs5,
                potencia = R.string.potenciaRs5,
                precio = R.string.precioRs5
            ),
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rs6,
                image = R.drawable.rs6,
                potencia = R.string.potenciaRs6,
                precio = R.string.precioRs6
            ),
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rs7,
                image = R.drawable.rs7,
                potencia = R.string.potenciaRs7,
                precio = R.string.precioRs7
            ),
            DeutschlandMotor(
                marca = R.string.audi,
                modelo = R.string.rsq8,
                image = R.drawable.rsq8,
                potencia = R.string.potenciaRsq8,
                precio = R.string.precioRsq8
            ),
            DeutschlandMotor(
                marca = R.string.bmw,
                modelo = R.string.m3,
                image = R.drawable.m3,
                potencia = R.string.potenciaM3,
                precio = R.string.precioM3
            ),
            DeutschlandMotor(
                marca = R.string.bmw,
                modelo = R.string.m4,
                image = R.drawable.m4,
                potencia = R.string.potenciaM4,
                precio = R.string.precioM4
            ),
            DeutschlandMotor(
                marca = R.string.bmw,
                modelo = R.string.m5,
                image = R.drawable.m5,
                potencia = R.string.potenciaM5,
                precio = R.string.precioM5
            ),
            DeutschlandMotor(
                marca = R.string.bmw,
                modelo = R.string.m8,
                image = R.drawable.m8,
                potencia = R.string.potenciaM8,
                precio = R.string.precioM8
            )
        )
    }
}