// Indica que esta clase reside dentro del paquete 'vista'
package Lab03.vista;

// Importa la clase Estudiante del paquete modelo para poder crear objetos con los datos ingresados
import Lab03.modelo.Estudiante;

// Importa todas las herramientas gráficas de Swing (JFrame, JPanel, JLabel, JTextField, JButton, etc.)
import javax.swing.*;

// Importa las herramientas AWT para maquetar contenedores, tipografías y colores (BorderLayout, Font, etc.)
import java.awt.*;

// 'extends JFrame' indica que esta clase HEREDA de ventana gráfica y adquiere todos sus poderes
public class VentanaRegistro extends JFrame {

    // Declaración de la caja de texto para escribir el carnet (privada para proteger la referencia)
    private JTextField txtCarnet;

    // Declaración de la caja de texto para escribir el nombre completo
    private JTextField txtNombre;

    // Declaración de la caja de texto para escribir la carrera
    private JTextField txtCarrera;

    // Declaración del botón interactivo para procesar e inscribir al estudiante
    private JButton btnGuardar;

    // Declaración del botón interactivo para borrar las cajas de texto
    private JButton btnLimpiar;

    // Constructor de la ventana: aquí se configura y construye toda la interfaz al hacer 'new VentanaRegistro()'
    public VentanaRegistro() {

        // Define el texto que aparecerá arriba en la barra superior de la ventana
        setTitle("Sistema de Gestión de Estudiantes — UNA");

        // Establece las dimensiones de la ventana: 450 píxeles de ancho por 300 píxeles de alto
        setSize(450, 300);

        // Indica que cuando el usuario toque la 'X' de cerrar, el programa Java debe detenerse totalmente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Posiciona la ventana exactamente en el centro geométrico de la pantalla del monitor
        setLocationRelativeTo(null);


        // Crea el panel contenedor principal organizado en 5 regiones (BorderLayout) con 10px de espacio libre
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        // Aplica un relleno/margen interno transparente de 15px alrededor del panel para no pegar con el borde
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        // Crea una etiqueta de texto centrada horizontalmente para el título del formulario
        JLabel lblTitulo = new JLabel("Inscripción de Estudiantes", SwingConstants.CENTER);

        // Aplica una tipografía en negrita (BOLD) y tamaño de fuente 18
        lblTitulo.setFont(new Font("Nunito", Font.BOLD, 18));

        // Cambia el color del texto al rojo institucional de la Universidad Nacional (RGB: 200, 16, 46)
        lblTitulo.setForeground(new Color(200, 16, 46));

        // Inserta la etiqueta del título en la zona superior (NORTH) del panel principal
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);


        // Crea un panel secundario en cuadrícula fija de 3 filas por 2 columnas, con 8px de separación entre celdas
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 8, 8));

        // [Fila 1, Col 1]: Agrega la etiqueta para identificar el carnet
        panelFormulario.add(new JLabel("Carnet:"));

        // Instancia el componente donde el usuario digitará su número de carnet
        txtCarnet = new JTextField();

        // [Fila 1, Col 2]: Agrega la caja de texto del carnet al lado de su etiqueta
        panelFormulario.add(txtCarnet);

        // [Fila 2, Col 1]: Agrega la etiqueta para identificar el nombre
        panelFormulario.add(new JLabel("Nombre Completo:"));

        // Instancia el componente donde el usuario digitará su nombre
        txtNombre = new JTextField();

        // [Fila 2, Col 2]: Agrega la caja de texto del nombre
        panelFormulario.add(txtNombre);

        // [Fila 3, Col 1]: Agrega la etiqueta para identificar la carrera
        panelFormulario.add(new JLabel("Carrera:"));

        // Instancia el componente donde el usuario digitará su carrera
        txtCarrera = new JTextField();

        // [Fila 3, Col 2]: Agrega la caja de texto de la carrera
        panelFormulario.add(txtCarrera);

        // Coloca todo el panel del formulario en el área central (CENTER) para que ocupe todo el espacio principal
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);


        // Crea un panel alineado a la derecha (FlowLayout.RIGHT) para contener los botones de acción
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        // Instancia el botón de borrar con la etiqueta 'Limpiar'
        btnLimpiar = new JButton("Limpiar");

        // Instancia el botón de confirmación con la etiqueta 'Guardar Estudiante'
        btnGuardar = new JButton("Guardar Estudiante");

        // Inserta el botón de limpiar en el panel secundario de botones
        panelBotones.add(btnLimpiar);

        // Inserta el botón de guardar al lado derecho dentro del panel secundario
        panelBotones.add(btnGuardar);

        // Coloca el panel de botones en la región inferior (SOUTH) del panel principal
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);


        // Conecta un oyente de clics (ActionListener) al botón 'Guardar' mediante una función lambda (e -> ...)
        btnGuardar.addActionListener(e -> {

            // Extrae el texto escrito por el usuario dentro de la caja de carnet y lo asigna a una variable
            String carnet = txtCarnet.getText();

            // Extrae el texto escrito por el usuario dentro de la caja de nombre
            String nombre = txtNombre.getText();

            // Extrae el texto escrito dentro de la caja de carrera
            String carrera = txtCarrera.getText();

            // Evalúa si alguna de las tres cadenas de texto se encuentra vacía
            if (carnet.isEmpty() || nombre.isEmpty() || carrera.isEmpty()) {

                // Si falta información, despliega una ventana emergente (Pop-up) con un ícono de advertencia
                JOptionPane.showMessageDialog(this,
                        "Por favor complete todos los campos.",
                        "Campos Incompletos",
                        JOptionPane.WARNING_MESSAGE);

            } else {

                // Si todos los datos están completos, crea el objeto Estudiante en la capa de modelo
                Estudiante nuevo = new Estudiante(carnet, nombre, carrera);

                // Muestra una ventana emergente informativa confirmando la creación exitosa del estudiante
                JOptionPane.showMessageDialog(this,
                        "Estudiante registrado con éxito:\n" + nuevo.toString(),
                        "Registro Exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });


        // Conecta un oyente de clics al botón 'Limpiar'
        btnLimpiar.addActionListener(e -> {

            // Blanquea el texto dentro de la caja del carnet
            txtCarnet.setText("");

            // Blanquea el texto dentro de la caja del nombre
            txtNombre.setText("");

            // Blanquea el texto dentro de la caja de la carrera
            txtCarrera.setText("");
        });


        // Ensambla el panel principal ya construido para que sea el contenido visible de esta ventana 'JFrame'
        this.add(panelPrincipal);
    }
}