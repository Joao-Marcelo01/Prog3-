package model;

public class Desenvolvedor extends Funcionario implements Desenvolve {

    public Desenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(nome + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(nome + " está resolvendo problemas técnicos.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("ID: " + id + " | Desenvolvedor: " + nome + " | Salário: " + salario);
    }
}