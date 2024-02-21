package com.example.app10days.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.app10days.R


val AbrilFatface = FontFamily(
    Font(R.font.abrilfatface_regular, FontWeight.Normal)
)

val Kanit = FontFamily(
    Font(R.font.kanit_light, FontWeight.Normal),
    Font(R.font.kanit_extrabold, FontWeight.Normal)
)
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = AbrilFatface,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Kanit,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 35.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Kanit,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 20.sp
    )
)