import javax.swing.*;

import ParadigmaOOP.Controller.TareaController;
import ParadigmaOOP.Modelo.Tarea;
import funcional.gestor.GestorTareas;

public class GestorTarea {

    public void Bienvenida(){
        JOptionPane.showMessageDialog(null, "Bienvenido al Gestor de Tareas" +
                "creado con diferentes paradigamas de prgramación");
    }


    public static void demostrarGestionTareas() {

        TareaController gestor = new TareaController();

        System.out.println("Agregando tareas...");
        gestor.guardar(new Tarea(null, "Aprender Java", "Repasar la Programación Orientada a Objetos."));
        gestor.guardar(new Tarea(null, "Hacer la compra", "Comprar leche, pan y huevos."));
        gestor.guardar(new Tarea(null, "Pasear al perro", "Llevarlo al parque nuevo."));

        System.out.println("\nLista de tareas:");
        System.out.println(gestor.obtenerTodas());

        System.out.println("\nActualizando tarea con ID 2...");
        Tarea nuevosDatos = new Tarea(null, "Comprar en el supermercado", "No olvidar el café.");
        gestor.actualizar(2L, nuevosDatos);
        System.out.println(gestor.obtenerTodas());

        System.out.println("\nEliminando tarea con ID 1...");
        gestor.eliminar(1L);

        System.out.println("\nLista final de tareas:");
        System.out.println(gestor.obtenerTodas());
    }





    public static void main(String[] args) {
        GestorTarea g = new GestorTarea();
        g.Bienvenida();

        demostrarGestionTareas();

        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║  TO-DO LIST - PARADIGMA FUNCIONAL (Java)  ║");
        System.out.println("╚═══════════════════════════════════════════╝\n");

        GestorTareas gestor = new GestorTareas();

        // Agregar tareas
        gestor.agregarTarea("Estudiar programación funcional");
        gestor.agregarTarea("Hacer ejercicio");
        gestor.agregarTarea("Leer un libro de Java");
        gestor.agregarTarea("Practicar streams");

        gestor.mostrarTodas();

        // Completar algunas tareas
        System.out.println("\n--- Completando tareas ---");
        gestor.cambiarEstadoTarea(1);
        gestor.cambiarEstadoTarea(3);

        gestor.mostrarTodas();

        // Ver solo activas
        gestor.mostrarActivas();

        // Ver solo completadas
        gestor.mostrarCompletadas();

        // Eliminar una tarea
        System.out.println("\n--- Eliminando tarea ---");
        gestor.eliminarTarea(2);

        gestor.mostrarTodas();
    }
}
