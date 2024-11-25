package view;

/*
 	trabalho feito por:
 	Luis Felipe Dos Santos
 	Aron Barbosa
 	João Torres
 	João Marcelo Lopes
 */


import controller.FuncionarioController;
import model.*;

import java.util.Scanner;

public class FuncionarioView {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Funcionario");
            System.out.println("2. Listar Funcionarios");
            System.out.println("3. Atualizar Salario");
            System.out.println("4. Excluir Funcionario");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.next();
                    System.out.print("Digite o salário: ");
                    double salario = scanner.nextDouble();
                    System.out.println("Escolha o tipo: 1-Desenvolvedor, 2-Gerente, 3-Treinador, 4-Gerente Desenvolvedor");
                    int tipo = scanner.nextInt();
                    Funcionario funcionario;

                    if (tipo == 1) funcionario = new Desenvolvedor(1, nome, salario);
                    else if (tipo == 2) funcionario = new Gerente(2, nome, salario);
                    else if (tipo == 3) funcionario = new Treinador(3, nome, salario);
                    else funcionario = new GerenteDesenvolvedor(4, nome, salario);

                    controller.adicionarFuncionario(funcionario);
                    break;

                case 2:
                    controller.listarFuncionarios();
                    break;

                case 3:
                    System.out.print("Digite o ID do funcionário: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite o aumento salarial: ");
                    double aumento = scanner.nextDouble();
                    controller.atualizarSalario(id, aumento);
                    break;

                case 4:
                    System.out.print("Digite o ID do funcionário: ");
                    id = scanner.nextInt();
                    controller.excluirFuncionario(id);
                    break;

                case 5:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}