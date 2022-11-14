package ControleAlunos;

import java.util.Scanner;

public class MainControle {
	
	private static String menu(Scanner sc) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" +
						"(N)ovo Grupo\n" +
						"(A)locar Aluno no Grupo e Verficar pertinência a Grupos\n" +
						"(O)lhaí quais grupos o Aluno Tá" +
						"(S)im, quero Fechar o Programa!" +
						"\n" + 
						"Opção> ");
		return sc.next().toUpperCase();
		
	}
	
	private static void comando(String opcao, Controle controle) {
		Scanner scanner = new Scanner(System.in);
		switch (opcao) {
		case "C":
			cadastrarAluno(controle, scanner);
			break;
		case "E":
			exibirAluno(controle, scanner);
			break;
		case "N":
			criaGrupo(controle, scanner);
			break;
		case "A": 
			alocarOuPertinencia(controle, scanner);
			break;
//		case "O":
//			exibirGruposDoAluno();
//		case "S":
//			sair();
		default:
			break;
		}
	}
	
	public static void cadastrarAluno(Controle controle, Scanner scanner) {
			System.out.println("Matrícula: ");
			String matricula = scanner.nextLine();
			System.out.println("NOME: ");
			String nome = scanner.nextLine();
			System.out.println("Curso: ");
			String curso = scanner.nextLine();
		try {
			controle.cadastrarAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
		} catch (NullPointerException erro){
			throw erro;
		}		
		  catch (IllegalArgumentException a) {
			System.out.println(a.getMessage());
		}
	}
	
	public static void exibirAluno(Controle controle, Scanner scanner) {
		System.out.println("Matrícula: ");
		String matricula = scanner.next();
		try {
			System.out.println(controle.consultarAluno(matricula));
		} catch(NullPointerException erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public static void criaGrupo(Controle controle, Scanner scanner){
		System.out.println("Grupo: ");
		String tema = scanner.next();
		System.out.println("Tamanho: ");
		int tamanho = scanner.nextInt();
		try {
			controle.cadastraGrupo(tema, tamanho);
			System.out.println("CADASTRO REALIZADO!");
		} catch(IllegalArgumentException erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public static void alocarOuPertinencia(Controle controle, Scanner scanner) {
		System.out.println("(A)locar Aluno ou (P)ertinência a Grupo? ");
		String escolha = scanner.next();
		if (escolha.toUpperCase().equals("A")) {
			System.out.println("Matrícula: ");
			String matricula = scanner.next();
			System.out.println("Grupo: ");
			String grupo = scanner.next();
			try {
				controle.alocaAluno(matricula, grupo);
			} catch (IllegalArgumentException erro){
				System.out.println(erro.getMessage());
			} catch (IndexOutOfBoundsException erro) {
				System.out.println(erro.getMessage());
			}
		}
	}
	
	
	public static void main(String[] args) {
		Controle controle = new Controle();
		while (true) {
		Scanner sc = new Scanner(System.in);
		comando(menu(sc), controle);
		}
	}
	
}
