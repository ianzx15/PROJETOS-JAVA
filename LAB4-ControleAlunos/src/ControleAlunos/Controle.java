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
	
	public void cadastrarAluno(String matricula, String nome, String curso) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			Validador.matriculaJaCadastrada(alunos, matricula);
			this.alunos.put(matricula, aluno);
	}
	
	public String consultarAluno(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		Validador.alunoNaoCadastrado(this.alunos, matricula);
		return "Aluno: " + aluno.getMatricula() + " - " + aluno.getNome() + " - " +
				aluno.getCurso();
	}
	
	public void cadastraGrupo(String tema, String tamanho) {
		Grupo grupo;
		if (tamanho.isEmpty()) {
			grupo = new Grupo (tema);
		} else {
			grupo = new Grupo(tema, tamanho);
		}
		Validador.grupoJaCadastrado(this.grupos, tema);
		this.grupos.put(tema, grupo);
	}

	public  String alocaAluno(String matricula, String tema) {
		Grupo grupo = this.grupos.get(tema);
		Validador.grupoNaoCadastrado(this.grupos, tema);
		Validador.alunoNaoCadastrado(alunos, matricula);
	  if (grupo.getaAlunos().size() >= grupo.getTamanho() && grupo.getTamanho() != 0){
		  throw new ArrayIndexOutOfBoundsException("GRUPO CHEIO!");
	  } else {
		grupo.adicionaAoGrupo(this.alunos.get(matricula));
		return "ALUNO ALOCADO";
	  }
	}
	
	public boolean pertenceGrupo(String tema, String matricula) {
		Grupo grupo = this.grupos.get(tema);
		Aluno aluno = this.alunos.get(matricula);
		Validador.grupoNaoCadastrado(grupos, tema);
		Validador.alunoNaoCadastrado(alunos, matricula);
		return grupo.getaAlunos().contains(aluno);
	}
	
	public String  enumeraGrupos(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		String elemento = "";
		for (Grupo grupo : this.grupos.values()) {
			if (grupo.getaAlunos().contains(aluno)) {
				if (grupo.getTamanho() == 0) {
				elemento +=  "- " + grupo.getTema() + " " + grupo.getaAlunos().size()
						+ "/...\n";
				} else {
				elemento +=  "- " + grupo.getTema() + " " + grupo.getaAlunos().size()
						+ "/" + grupo.getTamanho() +  "\n";
				}
			}
		}
		return "Grupos: \n" + elemento;
	}
	
		public void respostaAluno(String matricula) {
			Validador.alunoNaoCadastrado(alunos, matricula);
			Validador.isArgumentoValido(matricula);
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
