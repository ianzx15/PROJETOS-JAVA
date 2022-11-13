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
	
	private static void comando(String opcao, ControleAlunos alunos) {
		switch (opcao) {
		case "C":
			cadastrarAluno(alunos);
			break;
//		case "E":
//			exibirAluno();
//			break;
//		case "N":
//			criaGrupo();
//			break;
//		case "A": 
//			alocarAluno();
//			break;
//		case "O":
//			exibirGruposDoAluno();
//		case "S":
//			sair();
		default:
			break;
		}
	}
	
	public static void cadastrarAluno(ControleAlunos alunos) {
		while (true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Matrícula: ");
		String matricula = sc.nextLine();
		System.out.println("NOME: ");
		String nome = sc.nextLine();
		System.out.println("Curso: ");
		String curso = sc.nextLine();

		try {
			alunos.cadastrarAluno(matricula, nome, curso);
		} catch (RuntimeException erro) {
			System.out.println(erro.getMessage());
			break;
		}
		System.out.println("CADASTRO REALIZADO!");
		break;
		}
	}
	
	public static void main(String[] args) {
		ControleAlunos alunos = new ControleAlunos();
		while (true) {
		Scanner sc = new Scanner(System.in);
		comando(menu(sc), alunos);
		}
	}
	
}
