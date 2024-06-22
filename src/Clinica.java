import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Medico> medicos = new ArrayList<>();
    private static ArrayList<Cita> citas = new ArrayList<>();

    public static void altaPaciente(String nombre, String dni, int numeroHistorial) {
        Paciente paciente = new Paciente(nombre, dni, numeroHistorial);
        pacientes.add(paciente);
        System.out.println("Paciente guardado con exito...");
    }

    public static void bajaPaciente(String dni) {
        //Este metodo removeIf realiza una busqueda por pacientes con el Dni y lo remueve
        pacientes.removeIf(paciente -> paciente.getDni().equals(dni));
        System.out.println("Paciente eliminado con exito...");
    }

    public static void altaMedico(String nombre, String dni, String especialidad) {
        Medico medico = new Medico(nombre, dni, especialidad);
        medicos.add(medico);
        System.out.println("Medico guardado con exito...");
    }

    public static void bajaMedico(String dni) {
        //Este metodo removeIf realiza una busqueda por medico con el Dni y lo remueve
        medicos.removeIf(medico -> medico.getDni().equals(dni));
        System.out.println("Medico eliminado con exito...");
    }

    public static void altaCita(String dniPaciente, String dniMedico, LocalDateTime fecha) {
        Paciente pacienteEncontrado = null;
        for (Paciente unPaciente : pacientes) {
            if (unPaciente.getDni().equals(dniPaciente)) {
                pacienteEncontrado = unPaciente;
                break;
            }
        }
        if (pacienteEncontrado == null) {
            System.err.println("Paciente no encontrado");
            return;
        }

        Medico medicoEncontrado = null;
        for (Medico unMedico : medicos) {
            if (unMedico.getDni().equals(dniMedico)) {
                medicoEncontrado = unMedico;
                break;
            }
        }
        if (medicoEncontrado == null) {
            System.err.println("Medico no encontrado");
            return;
        }

        for (Cita c : citas) {
            if (c.getMedico().equals(medicoEncontrado) && c.getFecha().equals(fecha)) {
                System.err.println("El medico ya tiene una cita en ese momento");
                return;
            }
        }

        Cita cita = new Cita(pacienteEncontrado, medicoEncontrado, fecha);
        citas.add(cita);
    }

    public static ArrayList<Paciente> listarPacientesPorMedicoYFecha(String dniMedico, LocalDate fecha) {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();

        for (Cita cita : citas) {
            if (cita.getMedico().getDni().equals(dniMedico) && cita.getFecha().toLocalDate().equals(fecha)) {
                listaPacientes.add(cita.getPaciente());
            }
        }

        return listaPacientes;
    }

}