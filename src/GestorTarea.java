import javax.swing.*;

import ParadigmaEstructurado.GestorTareasEstructurado;
import funcional.gestor.GestorTareas;

public class GestorTarea {

    public void Bienvenida(){
        JOptionPane.showMessageDialog(null, "Bienvenido al Gestor de Tareas" +
                "creado con diferentes paradigamas de prgramación");
    }


    public static void main(String[] args) {
        GestorTarea g = new GestorTarea();
        g.Bienvenida();

        //  PARADIGMA ESTRUCTURADO
        // ==============================
        System.out.println("\n=== TO-DO LIST - PARADIGMA ESTRUCTURADO (Java) ===\n");
        GestorTareasEstructurado.iniciarGestor();

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
