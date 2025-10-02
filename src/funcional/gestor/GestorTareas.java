package funcional.gestor;

import funcional.modelo.Tarea;
import funcional.operaciones.OperacionesTarea;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor principal de tareas usando paradigma funcional
 * Paradigma: Funcional
 */
public class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    /**
     * Agrega una nueva tarea
     */
    public void agregarTarea(String descripcion) {
        tareas = OperacionesTarea.agregar(tareas, descripcion);
        System.out.println("✓ Tarea agregada: " + descripcion);
    }

    /**
     * Elimina una tarea por ID
     */
    public void eliminarTarea(int id) {
        tareas = OperacionesTarea.eliminar(tareas, id);
        System.out.println("✓ Tarea eliminada (ID: " + id + ")");
    }

    /**
     * Cambia el estado de una tarea (completar/descompletar)
     */
    public void cambiarEstadoTarea(int id) {
        tareas = OperacionesTarea.cambiarEstado(tareas, id);
        System.out.println("✓ Estado cambiado (ID: " + id + ")");
    }

    /**
     * Muestra todas las tareas
     */
    public void mostrarTodas() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   TODAS LAS TAREAS (FUNCIONAL) ║");
        System.out.println("╚════════════════════════════════╝");

        if (tareas.isEmpty()) {
            System.out.println("  No hay tareas");
        } else {
            tareas.forEach(t -> System.out.println("  " + t));
        }
        mostrarEstadisticas();
    }

    /**
     * Muestra solo las tareas activas
     */
    public void mostrarActivas() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║   TAREAS ACTIVAS (FUNCIONAL)   ║");
        System.out.println("╚════════════════════════════════╝");

        List<Tarea> activas = OperacionesTarea.obtenerActivas(tareas);
        if (activas.isEmpty()) {
            System.out.println("  No hay tareas activas");
        } else {
            activas.forEach(t -> System.out.println("  " + t));
        }
    }

    /**
     * Muestra solo las tareas completadas
     */
    public void mostrarCompletadas() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║  TAREAS COMPLETADAS (FUNCIONAL)║");
        System.out.println("╚════════════════════════════════╝");

        List<Tarea> completadas = OperacionesTarea.obtenerCompletadas(tareas);
        if (completadas.isEmpty()) {
            System.out.println("  No hay tareas completadas");
        } else {
            completadas.forEach(t -> System.out.println("  " + t));
        }
    }

    /**
     * Muestra estadísticas de las tareas
     */
    private void mostrarEstadisticas() {
        long total = tareas.size();
        long activas = OperacionesTarea.contarActivas(tareas);
        long completadas = OperacionesTarea.contarCompletadas(tareas);

        System.out.println("\n  📊 Total: " + total +
                " | Activas: " + activas +
                " | Completadas: " + completadas);
    }
}