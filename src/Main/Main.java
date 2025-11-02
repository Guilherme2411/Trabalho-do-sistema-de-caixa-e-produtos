package Main;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static Scanner input=new Scanner (System.in);
	static ArrayList<Produto> produtos= new ArrayList<>();
	static Caixa caixa = new Caixa();
	
	public static void main (String[] args) {
		int opcao;
		
		do {
			System.out.println(" \n ---- MENU -----");
			System.out.println(" Aperte 1 para Cadastrar Produto");
			System.out.println("Aperte 2 para listar produtos");
			System.out.println("Aperte 3 para realizar uma venda");
			System.out.println("Aperte 4 para exibir o caixa");
			System.out.println("aperte 5 para sair");
			System.out.println("Escolha:");
			opcao = input.nextInt();
			input.nextLine();
			
			switch(opcao) {
			case 1 -> cadastro();
			case 2 -> listarProdutos();
			case 3 -> venda();
			case 4 -> caixa.exibecaixa();
			case 5 -> System.out.println("Encerrando");
			default -> System.out.println("Opcao invalida");
		}
			
		} while (opcao !=5);
	}
	static void cadastro () {
		System.out.println("\n Nome do produto:");
		String nome = input.nextLine();
		if (nome.trim().isEmpty()) {
			System.out.println("nome invalido");
			return;
		}
		for (Produto p : produtos) {
			if (p.getNome().equalsIgnoreCase(nome));
			return;
		}
		System.out.println("Preco: ");
		double preco = input.nextDouble();
		if (preco<=0) {
			System.out.println("Preco invalido");
			return;
			
		}
		System.out.println("Estoque inicial: ");
		int estoque = input.nextInt();
		if (estoque<0) {
			System.out.println("Estoque invalido");
			return;
		}
		produtos.add(new Produto(nome,preco,estoque));
		System.out.println("Produto cadastrado!");
	}
	static void listarProdutos() {
		System.out.println("\n Produtos:");
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		} else {
			for (Produto p : produtos) {
				System.out.println(p);
			}
		}
	}
	static void venda() {
		listarProdutos();
		if (produtos.isEmpty()) return;
		
		System.out.println("\n Digite o nome do produto");
		String nome = input.nextLine();
		Produto produto = null;
		
		for(Produto p : produtos) {
			if (p.getNome().equalsIgnoreCase(nome)) {
				produto=p;
				break;
			}
		}
		if (produto == null) {
			System.out.println("Produto nao encontrado");
			return;
		}
		System.out.println("Quantidade");
		int qtd = input.nextInt();
		if (qtd<=0 || qtd > produto.getEstoque()) {
			System.out.println("Estoque insuficiente");
			return;
		}
		double total = qtd * produto.getPreco();
		System.out.println("Total da compra: \n R$" + total);
		System.out.println("Valor pago: \n R$");
		double pago = input.nextDouble();
		if (pago<total) {
			System.out.println("Valor insuficiente");
			return;
		}
		double troco = pago-total;
		System.out.println("Troco: \n R$" + troco);
		caixa.addPagamento(pago);
		if (!caixa.Troco(troco)) {
			System.out.println("Nao ha notas suficientes para o troco");
			System.out.println("Pagamento devoldido");
			
			caixa.Troco(pago);
		}
		produto.retirarestoque(qtd);
		System.out.println("Venda realizada com sucesso!");
			
		}
		
	}
	
