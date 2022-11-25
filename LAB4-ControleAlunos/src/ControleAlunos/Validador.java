package ControleAlunos;

import java.util.HashMap;

public class Validador {
	private static void isValido(String valor, String msg) {
		if (valor.isBlank()) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void isArgumentoValido(String valor) {
		isValido(valor, "ARGUMENTO INVÁLIDO");
	}
	
	private static void alunoCadastro(HashMap<String, Aluno> alunos, String matricula, String msg, boolean arg) {
		if (alunos.containsKey(matricula) && arg == true) {
			throw new IllegalArgumentException(msg);
		} else if (!alunos.containsKey(matricula) && arg == false){
			throw new IllegalArgumentException(msg);
		}
	}
	
	
	public static void alunoNaoCadastrado(HashMap<String, Aluno> alunos, String matricula) {
		alunoCadastro(alunos, matricula, "ALUNO NÃO CADASTRADO", false);
	}
	
	public static void alunoJaCadastrado(HashMap<String, Aluno> alunos, String matricula) {
		alunoCadastro(alunos, matricula, "ALUNO JÁ CADASTRADO", true);
	}
	
	
	private static void grupoCadastro(HashMap<String, Grupo> grupos, String tema, String msg, boolean arg) {
		if (grupos.containsKey(tema) && arg == true) {
			throw new IllegalArgumentException(msg);
		} else if (!grupos.containsKey(tema) && arg == false){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void grupoJaCadastrado(HashMap<String, Grupo> grupos, String tema) {
		grupoCadastro(grupos, tema, "GRUPO JÁ CADASTRADO!", true);
	}
	
	public static void grupoNaoCadastrado(HashMap<String, Grupo> grupos, String tema) {
		grupoCadastro(grupos, tema, "GRUPO NÃO CADASTRADO", false);
	}
	
	public static void matriculaJaCadastrada(HashMap<String, Aluno> alunos, String matricula) {
		alunoCadastro(alunos, matricula, "MATRÍCULA JÁ CADASTRADA", true);
	}
	
}
