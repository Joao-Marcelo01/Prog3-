package controller;

import model.*;
import java.util.ArrayList;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDetalhes();
        }
    }

    public void atualizarSalario(int id, double aumento) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.receberAumento(aumento);
                System.out.println("Salário atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void excluirFuncionario(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        System.out.println("Funcionário removido com sucesso!");
    }
}