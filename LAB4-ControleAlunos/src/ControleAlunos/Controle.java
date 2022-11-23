package ControleAlunos;

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	
	private ArrayList<Aluno> alunosResponderam;
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
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
	
	public void cadastraGrupo(String tema, String tamanho) throws IllegalArgumentException {
		Grupo grupo;
		if (tamanho.isEmpty()) {
			grupo = new Grupo (tema);
		} else {
			grupo = new Grupo(tema, tamanho);
		}
		
		if (this.grupos.containsKey(tema)) {
			throw new IllegalArgumentException("GRUPO JÁ CADASTRADO!");
		}
		this.grupos.put(tema, grupo);
	}

	public  String alocaAluno(String matricula, String tema) {
		Grupo grupo = this.grupos.get(tema);
		if(!this.grupos.containsKey(tema)){
			throw new IllegalArgumentException("GRUPO NÃO CADASTRADO.");
	  } else if (!this.alunos.containsKey(matricula)){
		throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
	  } else if (grupo.getaAlunos().size() >= grupo.getTamanho() && grupo.getTamanho() != 0){
		  throw new ArrayIndexOutOfBoundsException("GRUPO CHEIO!");
	  } else {
		grupo.adicionaAoGrupo(this.alunos.get(matricula));
		return "ALUNO ALOCADO";
	  }
	}
	
	public boolean pertenceGrupo(String tema, String matricula) {
		Grupo grupo = this.grupos.get(tema);
		Aluno aluno = this.alunos.get(matricula);
		if (!this.grupos.containsKey(tema)) {
			throw new IllegalArgumentException("GRUPO NÃO CADASTRADO.");
		} else if (!this.alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("ALUNO NÃO CADASTRADO.");
		}
		return grupo.getaAlunos().contains(aluno);
	}
	
	public String  enumeraGrupos(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		String elemento = "";
		for (Grupo grupo : this.grupos.values()) {
			if (grupo.getaAlunos().contains(aluno)) {
				if (grupo.getTamanho() == 0) {
				elemento +=  "- " + grupo.getTema() + " " + grupo.getaAlunos().size()
						+ "/\n";
				} else {
				elemento +=  "- " + grupo.getTema() + " " + grupo.getaAlunos().size()
						+ "/" + grupo.getTamanho() +  "\n";
				}
			}
		}
		return "Grupos: \n" + elemento;
	}
	

		public void respostaAluno(String matricula) {
			if (!this.alunos.containsKey(matricula)) {
				throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");
			}
			this.alunosResponderam.add(this.alunos.get(matricula));
			
		}
		
		public String imprimeRespostaAluno() {
			String alunos = "";
			int indice = 0;
			for (Aluno aluno : this.alunosResponderam) {
				indice ++;
				alunos += indice + ". " + aluno.getMatricula() + " - " + aluno.getNome()
				+ " - " + aluno.getCurso() + "\n"; 
			}
			return alunos;
		}
}
