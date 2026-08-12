// Declaración del paquete principal de la aplicación
package Lab03;

// Importa la clase VentanaRegistro creada en el paquete vista
import Lab03.vista.VentanaRegistro;

// Importa la herramienta de utilidades Swing para manejo seguro de hilos de ejecución
import javax.swing.SwingUtilities;

// Clase contenedora del método ejecutable
public class Main {

    // Método principal estándar que busca la Máquina Virtual de Java para comenzar
    public static void main(String[] args) {

        // Transfiere la creación de la interfaz gráfica al hilo especial de eventos de Swing (EDT)
        SwingUtilities.invokeLater(() -> {

            // Llama al constructor de la ventana (crea todos los paneles, botones y cajas de texto)
            VentanaRegistro ventana = new VentanaRegistro();

            // Vuelve visible la ventana en el monitor del usuario (por defecto las ventanas nacen invisibles)
            ventana.setVisible(true);
        });
    }
}