import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteManager {

    private static final String FILE_PATH = "pacientes.txt";

    public static List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                pacientes.add(Paciente.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return pacientes;
    }

    public static void salvarPaciente(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(paciente.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o paciente: " + e.getMessage());
        }
    }

    public static boolean atualizarPaciente(int numero, double novoPeso, double novaAltura) {
        List<Paciente> pacientes = listarPacientes();
        boolean pacienteAtualizado = false;

        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                pacienteAtualizado = true;
                pacientes.remove(paciente);
                pacientes.add(new Paciente(numero, novoPeso, novaAltura));
                break;
            }
        }

        if (pacienteAtualizado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Paciente p : pacientes) {
                    writer.write(p.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao atualizar o arquivo: " + e.getMessage());
            }
        }

        return pacienteAtualizado;
    }

    public static boolean excluirPaciente(int numero) {
        List<Paciente> pacientes = listarPacientes();
        List<Paciente> pacientesAtualizados = new ArrayList<>();

        boolean pacienteExcluido = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() != numero) {
                pacientesAtualizados.add(paciente);
            } else {
                pacienteExcluido = true;
            }
        }

        if (pacienteExcluido) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Paciente p : pacientesAtualizados) {
                    writer.write(p.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao excluir o paciente: " + e.getMessage());
            }
        }

        return pacienteExcluido;
    }
}
