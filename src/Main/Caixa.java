package Main;

public class Caixa {
	private int nota50 = 5;
	private int nota20= 5;
	private int nota10 = 5;
	
	public double getSaldo() {
		return nota50*50 + nota20*20 + nota10*10;
	}
	
	public void exibecaixa() {
		System.out.println("\n Saldo no caixa: R$ " + getSaldo());
		System.out.println("Notas no caixa: ");
		System.out.println("\n 50: " + nota50);
		System.out.println("\n 20: " + nota20);
		System.out.println("\n 10:"+ nota10);
		
	}
	
	public void addPagamento(double valor) {
		int aux = (int) valor;
		while (aux>=50) { nota50++; aux -= 50;}
		while (aux>=20) {nota20++; aux-= 20;}
		while(aux>=10) { nota10++; aux-=10;}
		
		if (aux!= 0) {
			System.out.println("\n O valor nao pode ser trocado no caixa");
		}
	}
	
	public boolean Troco(double valor) {
		int troco = (int) valor;
		
		int qtd50= 0,qtd20=0,qtd10=0;
		int aux = troco;
		while (aux >= 50 && nota50-qtd50>0) {
			qtd50++; aux -= 50;
		}
		while (aux >= 20 && nota20 - qtd20>0) {
			qtd20++; aux -=20;
			
		}
		while (aux>= 10 && nota10-qtd10>0) {
			qtd10++; aux -=10;
		}
		if (aux!=0) {
			return false;
		}
		nota50-=qtd50;
		nota20-=qtd20;
		nota10-=qtd10;
		
		System.out.println("Troco dado:\n ");
		if(qtd50>0) System.out.println(qtd50 + "\n notas de 50");
		if(qtd20>0) System.out.println(qtd20 +"\n notas de 20");
		if(qtd10>0) System.out.println(qtd10 +"\n notas de 10");
		return true;
}
	
}