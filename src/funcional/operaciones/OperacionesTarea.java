package funcional.operaciones;

import funcional.modelo.Tarea;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Funciones puras para manipular tareas
 * Paradigma: Funcional
 */
public class OperacionesTarea {

    /**
     * Agrega una nueva tarea a la lista (función pura)
     * @param tareas Lista actual de tareas
     * @param descripcion Descripción de la nueva tarea
     * @return Nueva lista con la tarea agregada
     */
    public static List<Tarea> agregar(List<Tarea> tareas, String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            return tareas;
        }

        int nuevoId = tareas.stream()
                .mapToInt(Tarea::getId)
                .max()
                .orElse(0) + 1;

        Tarea nueva = new Tarea(nuevoId, descripcion.trim(), false);

        return Stream.concat(tareas.stream(), Stream.of(nueva))
                .collect(Collectors.toList());
    }

    /**
     * Elimina una tarea por ID (función pura)
     * @param tareas Lista actual de tareas
     * @param id ID de la tarea a eliminar
     * @return Nueva lista sin la tarea eliminada
     */
    public static List<Tarea> eliminar(List<Tarea> tareas, int id) {
        return tareas.stream()
                .filter(t -> t.getId() != id)
                .collect(Collectors.toList());
    }

    /**
     * Cambia el estado de una tarea (completada/no completada)
     * @param tareas Lista actual de tareas
     * @param id ID de la tarea a modificar
     * @return Nueva lista con el estado modificado
     */
    public static List<Tarea> cambiarEstado(List<Tarea> tareas, int id) {
        return tareas.stream()
                .map(t -> t.getId() == id ? t.conEstado(!t.isCompletada()) : t)
                .collect(Collectors.toList());
    }

    /**
     * Filtra solo las tareas activas
     */
    public static List<Tarea> obtenerActivas(List<Tarea> tareas) {
        return tareas.stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    /**
     * Filtra solo las tareas completadas
     */
    public static List<Tarea> obtenerCompletadas(List<Tarea> tareas) {
        return tareas.stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    /**
     * Cuenta las tareas activas
     */
    public static long contarActivas(List<Tarea> tareas) {
        return tareas.stream()
                .filter(t -> !t.isCompletada())
                .count();
    }

    /**
     * Cuenta las tareas completadas
     */
    public static long contarCompletadas(List<Tarea> tareas) {
        return tareas.stream()
                .filter(Tarea::isCompletada)
                .count();
    }
}