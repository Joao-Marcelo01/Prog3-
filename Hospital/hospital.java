import java.util.ArrayList;

public class Hospital {
    private ArrayList<Paciente> pacientes;

    public Hospital() {
        pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public void alterarPaciente(int id, String nome, double peso, double altura, int sexo) {
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            paciente.setNome(nome);
            paciente.setPeso(peso);
            paciente.setAltura(altura);
            paciente.setSexo(sexo);
        }
    }

    public boolean excluirPaciente(int id) {
        Paciente paciente = buscarPacientePorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}
