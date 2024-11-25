package model;

public class GerenteDesenvolvedor extends Funcionario implements Desenvolve, Gerencia {

    public GerenteDesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(nome + " está codando como desenvolvedor.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(nome + " está resolvendo problemas técnicos.");
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
        System.out.println("ID: " + id + " | Gerente Desenvolvedor: " + nome + " | Salário: " + salario);
    }
}