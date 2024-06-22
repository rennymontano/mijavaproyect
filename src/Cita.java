import java.time.LocalDateTime;

public class Cita {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fecha;

    public Cita(Paciente paciente, Medico medico, LocalDateTime fecha) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", fecha=" + fecha +
                '}';
    }
}

