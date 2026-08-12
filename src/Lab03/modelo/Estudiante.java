// Indica el paquete o carpeta lógica a la que pertenece esta clase
package Lab03.modelo;

// Declaración de la clase pública Estudiante (plantilla o molde para crear objetos)
public class Estudiante {
    // Atributo privado para almacenar el carnet (encapsulado para que nadie lo altere directamente)
    private String carnet;
    // Atributo privado para almacenar el nombre completo del estudiante
    private String nombre;
    // Atributo privado para almacenar el nombre de la carrera que cursa
    private String carrera;

    // Constructor público que se ejecuta con 'new' para inicializar los 3 atributos requeridos
    public Estudiante(String carnet, String nombre, String carrera) {
        // 'this.carnet' se refiere al atributo de la clase; 'carnet' al valor recibido en el parámetro
        this.carnet = carnet;
        // Asigna el nombre recibido al atributo interno 'nombre'
        this.nombre = nombre;
        // Asigna la carrera recibida al atributo interno 'carrera'
        this.carrera = carrera;
    }

    // Método getter público que permite consultar/leer el carnet guardado
    public String getCarnet() {
        // Retorna la cadena de texto del carnet
        return carnet;
    }

    // Método getter público que permite consultar/leer el nombre guardado
    public String getNombre() {
        // Retorna la cadena de texto del nombre
        return nombre;
    }

    // Método getter público que permite consultar/leer la carrera guardada
    public String getCarrera() {
        // Retorna la cadena de texto de la carrera
        return carrera;
    }

    // Sobrescribe el método estándar toString() para formatear cómo se imprime la información
    @Override
    public String toString() {
        // Concatena y devuelve una cadena legible con todos los datos del estudiante
        return carnet + " - " + nombre + " (" + carrera + ")";
    }
}
