import javax.swing.*;

public class GestorTarea {

    public void Bienvenida(){
        JOptionPane.showMessageDialog(null, "Bienvenido al Gestor de Tareas" +
                "creado con diferentes paradigamas de prgramación");
    }

    public static void main(String[] args) {
        GestorTarea g = new GestorTarea();
        g.Bienvenida();
    }
}
