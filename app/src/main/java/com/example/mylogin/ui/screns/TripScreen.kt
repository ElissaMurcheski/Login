package com.example.mylogin.ui.screns

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mylogin.models.Trip

@Composable
fun TripScreen(navController: NavHostController) {
    val list = listOf(
        Trip(1, "Egito", "12/12/2022", "05/01/2023", 6999.90),
        Trip(2, "França", "08/12/2021", "02/01/2022", 4999.90),
        Trip(3, "Suiça", "18/12/2020", "03/01/2021", 9999.90),
        Trip(4, "Grécia", "18/12/2020", "03/01/2021", 8999.90),
        Trip(5, "Brasil", "18/12/2020", "03/01/2021", 499.90)
    )
    val ctx = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(
                    ctx, "Criar novo",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = ""
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn() {
                items(items = list) {
                    TripCard(it)
                }
            }
        }
    }
}

@Composable
fun TripCard(trip: Trip) {
    val ctx = LocalContext.current
    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp
    ),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {
                Toast
                    .makeText(
                        ctx, "Produto: ${trip.source}",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row {
                Text(
                    text = trip.source,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 22.sp,
                )
            }
            Row {
                Text(
                    text = "Inicio ${trip.startDate} - Fim ${trip.endDate}",
                    style = MaterialTheme.typography.bodySmall,
                )
            }

            Row {
                Text(
                    text = "Orçamento R$${trip.budget}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }
}
