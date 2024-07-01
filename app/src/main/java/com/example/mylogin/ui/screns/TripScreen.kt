package com.example.mylogin.ui.screns

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.database.AppDatabase
import com.example.mylogin.models.Trip
import com.example.mylogin.models.TripType

@Composable
fun TripScreen(navController: NavHostController) {
    val list = listOf(
        Trip(1, "Egito", "12/12/2022", "05/01/2023", 6999.90),
        Trip(2, "França", "08/12/2021", "02/01/2022", 4999.90, TripType.BUSINESS),
        Trip(3, "Suiça", "18/12/2020", "03/01/2021", 9999.90, TripType.BUSINESS),
        Trip(4, "Grécia", "18/12/2020", "03/01/2021", 8999.90, TripType.BUSINESS),
        Trip(5, "Brasil", "18/12/2020", "03/01/2021", 499.90)
    )
    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate("tripForm")
        }) {
            Icon(
                imageVector = Icons.Default.AddCircle, contentDescription = ""
            )
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn {
                items(items = list) {
                    TripCard(it)
                }
            }
        }
    }
}

@Composable
fun TripCard(trip: Trip) {
    val context = LocalContext.current
    ElevatedCard(elevation = CardDefaults.cardElevation(
        defaultElevation = 2.dp
    ), modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 6.dp)
        .clickable {
            Toast
                .makeText(context, "Produto: ${trip.source}", Toast.LENGTH_SHORT)
                .show()
        }) {
        Column(modifier = Modifier.padding(15.dp)) {
            Row {
                Column {
                    Row {
                        var imageVector = Icons.Outlined.Face
                        if (trip.type == TripType.BUSINESS) {
                            imageVector = Icons.Outlined.Email
                        }
                        Icon(imageVector, contentDescription = "", modifier = Modifier.size(40.dp))
                        Text(
                            text = trip.source,
                            modifier = Modifier.padding(6.dp),
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 20.sp,
                        )
                    }
                }
                Column {
                    Row {
                        Text(
                            text = "R$ ${trip.budget}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            textAlign = TextAlign.Right,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Row {
                        Text(
                            text = "${trip.startDate} - ${trip.endDate}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Right,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun TripScreen() {
    TripScreen(rememberNavController())
}
