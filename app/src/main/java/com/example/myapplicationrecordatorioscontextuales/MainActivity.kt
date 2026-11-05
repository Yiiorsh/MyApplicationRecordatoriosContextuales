
package com.example.myapplicationrecordatorioscontextuales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationrecordatorioscontextuales.ui.theme.MyApplicationRecordatoriosContextualesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationRecordatoriosContextualesTheme {
                PantallaRecordatorios()
            }
        }
    }
}

// Pantalla principal de nuestra aplicación
@Composable
fun PantallaRecordatorios() {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(
                text = "Mis Recordatorios",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Total: ${recordatoriosSimulados.size} recordatorios",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Pendientes: ${recordatoriosPendientes.size} | " +
                        "Prioridad alta: ${recordatoriosAltaPrioridad.size}",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de recordatorios simulados
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = recordatoriosSimulados,
                    key = { it.id }
                ) { recordatorio ->
                    TarjetaRecordatorio(recordatorio)
                }
            }
        }
    }
}

// Tarjeta que muestra los datos de cada recordatorio
@Composable
fun TarjetaRecordatorio(recordatorio: Recordatorio) {

    val colorCategoria = when (
        coloresCategorias[recordatorio.categoria]
    ) {
        "Azul" -> Color(0xFF1565C0)
        "Verde" -> Color(0xFF2E7D32)
        "Naranja" -> Color(0xFFEF6C00)
        else -> Color.Gray
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = recordatorio.titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Categoría: ${recordatorio.categoria.nombre}",
                color = colorCategoria
            )

            Text(
                text = "Prioridad: ${recordatorio.prioridad.nombre}"
            )

            Text(
                text = "Estado: ${recordatorio.estado.nombre}"
            )
        }
    }
}

// Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun VistaPreviaRecordatorios() {
    MyApplicationRecordatoriosContextualesTheme {
        PantallaRecordatorios()
    }
}
