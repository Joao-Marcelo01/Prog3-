package model;

import java.io.Serializable;

public class Treinador extends Funcionario implements Treina, Serializable {
    private static final long serialVersionUID = 1L;

    public Treinador(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println(nome + " está ensinando novas tecnologias.");
    }

    @Override
    public void motivarEquipe() {
        System.out.println(nome + " está motivando a equipe.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("ID: " + id + " | Treinador: " + nome + " | Salário: " + salario);
    }
}
