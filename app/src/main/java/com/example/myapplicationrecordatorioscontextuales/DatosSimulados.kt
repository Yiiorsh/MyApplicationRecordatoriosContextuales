
package com.example.myapplicationrecordatorioscontextuales

// Lista de recordatorios simulados
val recordatoriosSimulados: List<Recordatorio> = listOf(
    Recordatorio(
        id = 1,
        titulo = "Estudiar Kotlin",
        categoria = Categoria.Estudios,
        prioridad = Prioridad.Alta,
        estado = EstadoRecordatorio.Pendiente,
        descripcion = "Repasar los fundamentos de Kotlin"
    ),
    Recordatorio(
        id = 2,
        titulo = "Revisar correos",
        categoria = Categoria.Trabajo,
        prioridad = Prioridad.Media,
        estado = EstadoRecordatorio.Pendiente
    ),
    Recordatorio(
        id = 3,
        titulo = "Comprar materiales",
        categoria = Categoria.Personal,
        prioridad = Prioridad.Baja,
        estado = EstadoRecordatorio.Completado
    ),
    Recordatorio(
        id = 4,
        titulo = "Terminar actividad de Android",
        categoria = Categoria.Estudios,
        prioridad = Prioridad.Alta,
        estado = EstadoRecordatorio.Pendiente
    )
)

// Set: obtiene las categorías sin repetirlas
val categoriasUnicas: Set<Categoria> =
    recordatoriosSimulados.map { it.categoria }.toSet()

// Map: asigna un color a cada categoría
val coloresCategorias: Map<Categoria, String> = mapOf(
    Categoria.Estudios to "Azul",
    Categoria.Trabajo to "Verde",
    Categoria.Personal to "Naranja"
)

// Filtrar recordatorios pendientes
val recordatoriosPendientes: List<Recordatorio> =
    recordatoriosSimulados.filter {
        it.estado == EstadoRecordatorio.Pendiente
    }

// Filtrar recordatorios de prioridad alta
val recordatoriosAltaPrioridad: List<Recordatorio> =
    recordatoriosSimulados.filter {
        it.prioridad == Prioridad.Alta
    }
