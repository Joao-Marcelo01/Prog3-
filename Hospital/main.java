import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Alterar paciente");
            System.out.println("3 - Excluir paciente");
            System.out.println("4 - Listar pacientes");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do paciente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Peso do paciente (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura do paciente (m): ");
                    double altura = scanner.nextDouble();
                    System.out.print("Sexo do paciente (1 para Masculino, 2 para Feminino): ");
                    int sexo = scanner.nextInt();
                    Paciente paciente = new Paciente(id, nome, peso, altura, sexo);
                    hospital.adicionarPaciente(paciente);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do paciente a ser alterado: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha
                    Paciente pacienteAlterar = hospital.buscarPacientePorId(idAlterar);
                    if (pacienteAlterar != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo peso (kg): ");
                        double novoPeso = scanner.nextDouble();
                        System.out.print("Nova altura (m): ");
                        double novaAltura = scanner.nextDouble();
                        System.out.print("Novo sexo (1 para Masculino, 2 para Feminino): ");
                        int novoSexo = scanner.nextInt();
                        hospital.alterarPaciente(idAlterar, novoNome, novoPeso, novaAltura, novoSexo);
                        System.out.println("Paciente alterado com sucesso!");
                    } else {
                        System.out.println("Paciente não encontrado!");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do paciente a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    if (hospital.excluirPaciente(idExcluir)) {
                        System.out.println("Paciente excluído com sucesso!");
                    } else {
                        System.out.println("Paciente não encontrado!");
                    }
                    break;
                case 4:
                    hospital.listarPacientes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
