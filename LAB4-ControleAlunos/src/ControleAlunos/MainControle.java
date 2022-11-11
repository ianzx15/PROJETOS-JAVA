package ControleAlunos;

import java.util.HashSet;
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
	
	private static void comando(String opcao) {
		switch (opcao) {
		case "C":
			cadastrarAluno();
			break;
		case "E":
			exibirAluno();
			break;
		case "N":
			criaGrupo();
			break;
		case "A": 
			alocarAluno();
			break;
		case "O":
			exibirGruposDoAluno();
		case "S":
			sair();
		default:
			break;
		}
	}
	
	public void cadastrarAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Matrícula: ");
		
	}
	
	public static void main(String[] args) {
		while (true) {
		Scanner sc = new Scanner(System.in);
		comando(menu(sc));
		}
	}
	
}
