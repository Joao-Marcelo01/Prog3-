package model;

public abstract class Funcionario {
    protected int id;
    protected String nome;
    protected double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void receberAumento(double aumento) {
        this.salario += aumento;
    }

    public abstract void mostrarDetalhes();
}