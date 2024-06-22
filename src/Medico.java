
public class Medico {
    private String nombre;
    private String dni;
    private String especialidad;

    public Medico(String nombre, String dni, String especialidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}