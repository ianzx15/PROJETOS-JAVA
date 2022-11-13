package ControleAlunos;

import java.util.HashMap;
import java.util.Scanner;

public class ControleAlunos {
	
	private HashMap<String, Aluno> alunos;
	
	public ControleAlunos() {
		alunos = new HashMap<>();
	}
	
	public void cadastrarAluno(String matricula, String nome, String curso) throws RuntimeException{
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (this.alunos.containsKey(matricula)) {
			throw new RuntimeException("MATRÍCULA JÁ CADASTRADA");
		} 
			this.alunos.put(matricula, aluno);
			System.out.println(alunos.size());
	}
	
}
