package ControleAlunos;

import java.util.HashMap;
import java.util.Scanner;

public class ControleAlunos {
	private HashMap<String, Aluno> alunos = new HashMap<>();
	
	public ControleAlunos() {
		
	}
	
	public void cadastrarAluno(String matricula, String nome, String curso) throws IllegalArgumentException{
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException();
		}
		
		alunos.put(matricula, aluno);
	}
	
}
