package model;

public class Gerente extends Funcionario implements Gerencia {

    public Gerente(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println(nome + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(nome + " está conduzindo uma reunião.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("ID: " + id + " | Gerente: " + nome + " | Salário: " + salario);
    }
}