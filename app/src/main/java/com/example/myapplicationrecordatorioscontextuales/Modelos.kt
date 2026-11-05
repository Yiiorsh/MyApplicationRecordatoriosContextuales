
package com.example.myapplicationrecordatorioscontextuales

// Categorías de los recordatorios
sealed class Categoria(val nombre: String) {
    data object Estudios : Categoria("Estudios")
    data object Trabajo : Categoria("Trabajo")
    data object Personal : Categoria("Personal")
}

// Prioridades disponibles
sealed class Prioridad(val nombre: String) {
    data object Alta : Prioridad("Alta")
    data object Media : Prioridad("Media")
    data object Baja : Prioridad("Baja")
}

// Estados de los recordatorios
sealed class EstadoRecordatorio(val nombre: String) {
    data object Pendiente : EstadoRecordatorio("Pendiente")
    data object Completado : EstadoRecordatorio("Completado")
}

// Modelo principal de un recordatorio
data class Recordatorio(
    val id: Int,
    val titulo: String,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio,
    val descripcion: String? = null,
    val ubicacion: String? = null,
    val aviso: String? = null
) {
    init {
        require(id > 0) {
            "El identificador debe ser mayor que cero"
        }

        require(titulo.isNotBlank()) {
            "El título no puede estar vacío"
        }
    }
}
