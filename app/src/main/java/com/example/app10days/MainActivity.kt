package com.example.app10days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.app10days.ui.theme.App10daysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App10daysTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        var vehiculosAudi by remember { mutableStateOf(false) }
        var vehiculosBMW by remember { mutableStateOf(false) }
        var todosVehiculos by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CheckboxItem(
                    label = stringResource(R.string.audi),
                    selected = vehiculosAudi,
                    onCheckedChange = { isChecked ->
                        vehiculosAudi = isChecked
                    }
                )
                CheckboxItem(
                    label = stringResource(R.string.bmw),
                    selected = vehiculosBMW,
                    onCheckedChange = { isChecked ->
                        vehiculosBMW = isChecked
                    }
                )
                CheckboxItem(
                    label = stringResource(R.string.todos),
                    selected = todosVehiculos,
                    onCheckedChange = { isChecked ->
                        todosVehiculos = isChecked
                    }
                )
            }
            if (todosVehiculos) {
                vehiculosAudi = false
                vehiculosBMW = false
            }
            MostrarVehiculos(vehiculosAudi, vehiculosBMW, todosVehiculos, it)
        }
    }
}