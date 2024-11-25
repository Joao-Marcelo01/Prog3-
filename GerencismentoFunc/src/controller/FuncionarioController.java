package controller;

import model.*;
import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private final String FILE_PATH = "funcionarios.txt";
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = carregarFuncionarios();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarFuncionarios();
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDetalhes();
        }
    }

    public void atualizarSalario(int id, double aumento) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.receberAumento(aumento);
                salvarFuncionarios();
                System.out.println("Salário atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }

    public void excluirFuncionario(int id) {
        boolean removido = funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        if (removido) {
            salvarFuncionarios();
            System.out.println("Funcionário removido com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void salvarFuncionarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(funcionarios);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os funcionários: " + e.getMessage());
        }
    }

    private ArrayList<Funcionario> carregarFuncionarios() {
        File arquivo = new File(FILE_PATH);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (ArrayList<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os funcionários: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
