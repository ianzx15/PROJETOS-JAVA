package ControleAlunos;

import java.util.HashMap;
import java.util.HashSet;

public class Controle {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
	}
	
	public void cadastrarAluno(String matricula, String nome, String curso) throws IllegalArgumentException, NullPointerException{
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA");
		} else if(matricula.isEmpty() || nome.isEmpty() || curso.isEmpty()) {
			throw new NullPointerException();
		}
			this.alunos.put(matricula, aluno);
	}
	
	public String consultarAluno(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		if (aluno == null) {
			throw new NullPointerException("ALUNO NÃO CADASTRADO.");
		}
		return "Aluno: " + aluno.getMatricula() + " - " + aluno.getNome() + " - " +
				aluno.getCurso();
	}
	
	public void cadastraGrupo(String tema, int tamanho) throws IllegalArgumentException {
		Grupo grupo = new Grupo(tema, tamanho);
		if (this.grupos.containsKey(tema)) {
			throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
		}
		this.grupos.put(tema, grupo);
	}

	public void alocaAluno(String matricula, String tema) {
		Grupo grupo = this.grupos.get(tema);
		if(!this.grupos.containsKey(tema)){
			throw new IllegalArgumentException("GRUPO NÃO CADASTRADO.");
	  } else if (!this.alunos.containsKey(matricula)){
		throw new IllegalArgumentException("ALUNO NÃO CADASTRADO."); 
	  }
		if (!grupo.getaAlunos().contains(this.alunos.get(matricula))) {
			//PROBLEMA 1 - NÃO LANÇA EXCEÇÃO
			try{
				grupo.adicionaAoGrupo(this.alunos.get(matricula));
				System.out.println("ALUNO ALOCADO!");
			} catch (IndexOutOfBoundsException erro){
				System.out.println(erro.getMessage());
			}
		}
	}
}
