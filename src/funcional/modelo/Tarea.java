// ============================================
// ARCHIVO: src/funcional/modelo/Tarea.java
// ============================================
package funcional.modelo;

/**
 * Clase inmutable que representa una tarea
 * Paradigma: Funcional
 */
public class Tarea {
    private final int id;
    private final String descripcion;
    private final boolean completada;

    public Tarea(int id, String descripcion, boolean completada) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    /**
     * Crea una nueva tarea con el estado modificado (inmutabilidad)
     */
    public Tarea conEstado(boolean completada) {
        return new Tarea(this.id, this.descripcion, completada);
    }

    @Override
    public String toString() {
        String check = completada ? "[✓]" : "[ ]";
        return check + " " + id + ". " + descripcion;
    }
}