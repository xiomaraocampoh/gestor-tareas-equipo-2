package ParadigmaOOP.Controller;


import ParadigmaOOP.Modelo.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TareaController {

    private final List<Tarea> tareas = new ArrayList<>();
    private long siguienteId = 1;

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(this.tareas);
    }

    public Tarea guardar(Tarea tarea) {
        tarea.setId(siguienteId++);
        this.tareas.add(tarea);
        return tarea;
    }


    public Optional<Tarea> buscarPorId(Long id) {
        for (Tarea t : this.tareas) {
            if (Objects.equals(t.getId(), id)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Optional<Tarea> actualizar(Long id, Tarea datosNuevos) {
        Optional<Tarea> tareaExistente = buscarPorId(id);
        if (tareaExistente.isPresent()) {
            Tarea tareaParaActualizar = tareaExistente.get();
            tareaParaActualizar.setNombre(datosNuevos.getNombre());
            return Optional.of(tareaParaActualizar);
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        return this.tareas.removeIf(tarea -> Objects.equals(tarea.getId(), id));
    }
}
