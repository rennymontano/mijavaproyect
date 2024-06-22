
public class Paciente {
    private String nombre;
    private String dni;
    private int numeroHistorial;

    public Paciente(String nombre, String dni, int numeroHistorial) {
        this.nombre = nombre;
        this.dni = dni;
        this.numeroHistorial = numeroHistorial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getNumeroHistorial() {
        return numeroHistorial;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", numeroHistorial=" + numeroHistorial +
                '}';
    }
}
