public class Paciente {
    private int numero;
    private double peso;
    private double altura;

    public Paciente(int numero, double peso, double altura) {
        this.numero = numero;
        this.peso = peso;
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String listarPaciente() {
        return "Número: " + numero + ", Peso: " + peso + ", Altura: " + altura;
    }

    public static Paciente fromString(String data) {
        String[] parts = data.split(",");
        int numero = Integer.parseInt(parts[0]);
        double peso = Double.parseDouble(parts[1]);
        double altura = Double.parseDouble(parts[2]);
        return new Paciente(numero, peso, altura);
    }

    public String toString() {
        return numero + "," + peso + "," + altura;
    }
}
