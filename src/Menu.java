import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public static void MenuInicio() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        boolean salir  = true;
        while (salir) {
            System.out.println("*********************************************");
            System.out.println("                   CLINICA");
            System.out.println("*********************************************");
            System.out.println("1. Alta Paciente");
            System.out.println("2. Baja Paciente");
            System.out.println("3. Alta Medico");
            System.out.println("4. Baja Medico");
            System.out.println("5. Alta Cita");
            System.out.println("6. Listar Pacientes por Medico y Fecha");
            System.out.println("7. Salir");
            
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dniPaciente = scanner.nextLine();
                    System.out.print("Numero Historial: ");
                    int numeroHistorial = scanner.nextInt();
                    scanner.nextLine();  
                    Clinica.altaPaciente(nombrePaciente, dniPaciente, numeroHistorial);
                    break;
                case 2:
                    System.out.print("DNI: ");
                    dniPaciente = scanner.nextLine();
                    Clinica.bajaPaciente(dniPaciente);
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dniMedico = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    Clinica.altaMedico(nombreMedico, dniMedico, especialidad);
                    break;
                case 4:
                    System.out.print("DNI: ");
                    dniMedico = scanner.nextLine();
                    Clinica.bajaMedico(dniMedico);
                    break;
                case 5:
                    System.out.print("DNI Paciente: ");
                    dniPaciente = scanner.nextLine();
                    System.out.print("DNI Medico: ");
                    dniMedico = scanner.nextLine();
                    System.out.print("Fecha (dd/MM/yyyy HH:mm): ");
                    String fechaStr = scanner.nextLine();
                    try {
                        LocalDateTime fecha = LocalDateTime.parse(fechaStr, dateTimeFormatter);
                        Clinica.altaCita(dniPaciente, dniMedico, fecha);
                    } catch (Exception e) {
                        System.out.println("Error al crear la cita: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("DNI Medico: ");
                    dniMedico = scanner.nextLine();
                    System.out.print("Fecha (dd/MM/yyyy): ");
                    fechaStr = scanner.nextLine();
                    try {
                        LocalDate fecha = LocalDate.parse(fechaStr, dateFormatter);
                        ArrayList<Paciente> listaPacientes = Clinica.listarPacientesPorMedicoYFecha(dniMedico, fecha);
                        for (Paciente paciente : listaPacientes) {
                            System.out.println(paciente);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al listar pacientes: " + e.getMessage());
                    }
                    break;
                default:
                    salir = false;
                    break;
            }
        }
    }
}
