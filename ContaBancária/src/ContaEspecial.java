
public class ContaEspecial extends cb {
	private float limite;
	
	public ContaEspecial(String cliente, int numConta, float saldoInicial, float limite) {
		super(cliente, numConta, saldoInicial);
		this.limite = limite;
	}
	@Override
	public void sacar(float valor) {
		if(saldo + limite >= valor) {
			saldo -= valor;
			System.out.println("Saque realizado. Novo saldo: "+ saldo);
		}else {
			System.out.println("Saldo insuficiente, mesmo com limite.");
		}
	}

}
