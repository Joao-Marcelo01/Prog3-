import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nGerenciamento de Pacientes");
            System.out.println("1. Listar Pacientes");
            System.out.println("2. Adicionar Paciente");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Excluir Paciente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                listarPacientes();
            } else if (opcao == 2) {
                adicionarPaciente(scanner);
            } else if (opcao == 3) {
                atualizarPaciente(scanner);
            } else if (opcao == 4) {
                excluirPaciente(scanner);
            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
        scanner.close();
    }

    private static void listarPacientes() {
        List<Paciente> pacientes = PacienteManager.listarPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente.listarPaciente());
            }
        }
    }

    private static void adicionarPaciente(Scanner scanner) {
        System.out.print("Digite o número do paciente: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o peso do paciente: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a altura do paciente: ");
        double altura = scanner.nextDouble();

        Paciente paciente = new Paciente(numero, peso, altura);
        PacienteManager.salvarPaciente(paciente);
        System.out.println("Paciente adicionado com sucesso.");
    }

    private static void atualizarPaciente(Scanner scanner) {
        System.out.print("Digite o número do paciente a ser atualizado: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o novo peso: ");
        double novoPeso = scanner.nextDouble();
        System.out.print("Digite a nova altura: ");
        double novaAltura = scanner.nextDouble();

        boolean atualizado = PacienteManager.atualizarPaciente(numero, novoPeso, novaAltura);
        if (atualizado) {
            System.out.println("Paciente atualizado com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private static void excluirPaciente(Scanner scanner) {
        System.out.print("Digite o número do paciente a ser excluído: ");
        int numero = scanner.nextInt();

        boolean excluido = PacienteManager.excluirPaciente(numero);
        if (excluido) {
            System.out.println("Paciente excluído com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
