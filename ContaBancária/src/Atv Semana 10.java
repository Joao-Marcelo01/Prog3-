
public class cb {
	protected String cliente;
	protected int numConta;
	protected float saldo;
	
	public cb( String cliente, int numConta, float saldoInicial) {
		this.cliente = cliente;
		this.numConta = numConta;
		this.saldo = saldoInicial;
	}
	
	public void sacar(float valor) {
		if(saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque realiozado. Novo Saldo: " + saldo);
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}
	public void depositar(float valor) {
		saldo += valor;
		System.out.println("Depósito realizado. Novo saldo: " + saldo);
	}
	public void mostrarDados() {
		System.out.println("Cliente: " + cliente);
		System.out.println("Número da conta: "+ numConta);
		System.out.println("Saldo: "+ saldo);
	}
}
