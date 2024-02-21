package com.example.app10days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DeutschlandMotor(
    @StringRes val marca: Int,
    @StringRes val modelo: Int,
    @DrawableRes val  image: Int,
    @StringRes val potencia: Int,
    @StringRes val precio: Int
)
