package com.example.app10days

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app10days.model.DeutschlandMotor
import com.example.app10days.dataSource.DeutschlandMotorRepository
import com.example.app10days.ui.theme.App10daysTheme

@Composable
fun CheckboxItem(label: String, selected: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .height(dimensionResource(R.dimen.checkbox_height))
            .selectable(
                selected = selected,
                onClick = { onCheckedChange(!selected) }
            )
            .padding(horizontal = dimensionResource(R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = selected,
            onCheckedChange = { onCheckedChange(it) },
            modifier = Modifier
                .size(dimensionResource(R.dimen.checkbox_height))
                .padding(end = dimensionResource(R.dimen.padding_small))
        )

        Text(
            text = label,
            style = MaterialTheme.typography.displaySmall,
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun MarcaVehiculo(marca: Int, modelo: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = stringResource(marca),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(modelo),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun Image(image: Int, expanded: Boolean, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Image(

            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = dimensionResource(R.dimen.image_corner),
                        bottomEnd = dimensionResource(R.dimen.image_corner)
                    )
                )
                .rotate(
                    animateFloatAsState(
                        targetValue = if (expanded) 360f else 0f,
                        animationSpec = tween(durationMillis = 1000), label = ""
                    ).value
                )
        )
    }
}

@Composable
fun Information(info: Int, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {
        Text(
            text = stringResource(info),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun ItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = stringResource(R.string.sentence_item_button),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {

            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                tint = Color.White,
                contentDescription = stringResource(R.string.expand_button_content_description)
            )
        }
    }
}


@Composable
fun Vehiculo(vehiculo: DeutschlandMotor, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            MarcaVehiculo(vehiculo.marca, vehiculo.modelo)
            Image(vehiculo.image, expanded)
            ItemButton(expanded = expanded, onClick = { expanded = !expanded })
        }
        if (expanded) {
            Information(vehiculo.potencia)
            Information(vehiculo.precio)
        }
    }
}

@Composable
fun MostrarVehiculos(
    vehiculosAudi: Boolean,
    vehiculosBMW: Boolean,
    todosVehiculos: Boolean,
    it: PaddingValues
) {
    if (vehiculosAudi) {
        if (vehiculosBMW || todosVehiculos) {
            TodosLosVehiculos(it)
        } else {
            TodosLosAudis(it)
        }
    }

    if (vehiculosBMW) {
        if (vehiculosAudi || todosVehiculos) {
            TodosLosVehiculos(it)
        } else {
            TodosLosBMWS(it)
        }
    }

    if (todosVehiculos) {
        if (vehiculosBMW || vehiculosAudi) {
            TodosLosVehiculos(it)
        } else {
            TodosLosVehiculos(it)
        }
    }
}

@Composable
private fun TodosLosAudis(it: PaddingValues) {
    val repository = DeutschlandMotorRepository()
    val vehiculos = repository.getVehiculos()
    LazyColumn(contentPadding = it) {
        items(vehiculos.filter { it.marca == R.string.audi }) {
            Vehiculo(
                vehiculo = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun TodosLosBMWS(it: PaddingValues) {
    val repository = DeutschlandMotorRepository()
    val vehiculos = repository.getVehiculos()
    LazyColumn(contentPadding = it) {
        items(vehiculos.filter { it.marca == R.string.bmw }) {
            Vehiculo(
                vehiculo = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun TodosLosVehiculos(it: PaddingValues) {
    val repository = DeutschlandMotorRepository()
    val vehiculos = repository.getVehiculos()
    LazyColumn(contentPadding = it) {
        items(vehiculos) {
            Vehiculo(
                vehiculo = it,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.icono_deutschland),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.padding_large))
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary)
    )
}


@Preview
@Composable
fun App10dayPreview() {
    App10daysTheme(darkTheme = false) {
        App()
    }
}

@Preview
@Composable
fun App10dayDarkPreview() {
    App10daysTheme(darkTheme = true) {
        App()
    }
}