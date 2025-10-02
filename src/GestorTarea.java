import ParadigmaOOP.Controller.TareaController;
import ParadigmaOOP.Modelo.Tarea;

import javax.swing.*;

public class GestorTarea {

    public void Bienvenida() {

        System.out.println(("Bienvenido al Gestor de Tareas" +
                "creado con diferentes paradigamas de prgramación"));
    }

    public static void demostrarGestionTareasOOP() {

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


        demostrarGestionTareasOOP();



    }




}
