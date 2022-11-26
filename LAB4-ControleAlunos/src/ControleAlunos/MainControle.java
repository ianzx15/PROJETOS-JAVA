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
						"(O)lhaí quais grupos o Aluno Tá\n" +
						"(S)im, quero Fechar o Programa!\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam" +
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
		case "O":
			exibirGruposDoAluno(controle, scanner);
			break;
		case "R":
			registraRespostaAluno(controle, scanner);
			break;
		case "I":
			imprimeRespostaAlunos(controle, scanner);
			break;
		case "S":
			sair();
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
		}		
		  catch (IllegalArgumentException erro) {
			System.out.println(erro.getMessage());
		}
	}
	
	public static void exibirAluno(Controle controle, Scanner scanner) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		try {
			System.out.println(controle.consultarAluno(matricula));
		} catch(IllegalArgumentException erro){
			System.out.println(erro.getMessage());
		}
	}
	
	public static void criaGrupo(Controle controle, Scanner scanner){
		System.out.println("Grupo: ");
		String tema = scanner.nextLine();
		System.out.println("Tamanho: ");
		String tamanho = scanner.nextLine();
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
		String grupo;
		String matricula;
		scanner.nextLine();
		if (escolha.toUpperCase().equals("A")) {
			System.out.println("Matrícula: ");
			matricula = scanner.nextLine();
			System.out.println("Grupo: ");
			grupo = scanner.nextLine();
			try {
				System.out.println(controle.alocaAluno(matricula, grupo));
			} catch (IllegalArgumentException erro){
				System.out.println(erro.getMessage());
			}
		} else {
			System.out.println("GRUPO: ");
			grupo = scanner.nextLine();
			System.out.println("ALUNO: ");
			matricula = scanner.nextLine();
			try {
				if(controle.pertenceGrupo(grupo, matricula)) {
					System.out.println("ALUNO PERTENCE AO GRUPO.");
				} else { 
				System.out.println("ALUNO NÃO PERTENCE AO GRUPO.");
				}
			}catch (IllegalArgumentException erro) {
				System.out.println(erro.getMessage());
			}
		}
	}
	
	public static void exibirGruposDoAluno(Controle controle, Scanner scanner) {
		System.out.println("Aluno: ");
		System.out.println(controle.enumeraGrupos(scanner.nextLine()));
	}
	
	public static void registraRespostaAluno(Controle controle, Scanner scanner) {
		 System.out.println("Matrícula: ");
		 String matricula = scanner.nextLine();
		  try{
			  controle.respostaAluno(matricula);
			  System.out.println("ALUNO REGISTRADO!");
		  } catch (IllegalArgumentException erro) {
			  System.out.println(erro.getMessage());
		  }
		  
	}
	
	public static void  imprimeRespostaAlunos(Controle controle, Scanner scanner) {
		System.out.println("Alunos: \n" + controle.imprimeRespostaAluno());
	}
	
	public static void sair() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Controle controle = new Controle();
		while (true) {
		Scanner sc = new Scanner(System.in);
		comando(menu(sc), controle);
		}
	}
	
}
