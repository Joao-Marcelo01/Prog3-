
public class ContaPoupança extends cb {
	private int diaDeRendimento;
	
	public ContaPoupança(String cliente, int numConta,float saldoInicial, int diaDeRendimento) {
		super(cliente, numConta,saldoInicial);
		this.diaDeRendimento = diaDeRendimento;
	}
	public void calcularNovoSaldo(float taxaDeRendimento) {
		saldo += saldo * taxaDeRendimento;
		System.out.println("Novo saldo após rendimento: "+saldo);
	}
}
