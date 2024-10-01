
class Contas {
	public static void main(String[]args) {
		contaPoupança cp = new ContaPoupança("João Marcelo", 12345,1000.0f,5);
		ContaEspecial ce = new ContaEspecial("Maria Silva", 67890,500.0f,1000.0f);
		
		System.out.println("Conta Poupança: ");
		cp.mostrarDados();
		System.out.println("\Conta Especial: ");
		ce.mostrarDados();
		
		
	}

}
