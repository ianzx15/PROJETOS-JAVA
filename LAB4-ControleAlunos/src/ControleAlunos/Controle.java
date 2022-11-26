package ControleAlunos;

/**
 * Organização de um controle que armazena e trata objetos
 * do tipo Aluno e Grupo.
 * @author Ian Evangelista Rodrigues
 */


import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	
	private ArrayList<Aluno> alunosResponderam;
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	
	/**
	 * Constrói um controle.
	 * @param alunosResponderam A lista de alunos que respondeu.
	 * @param alunos O hashmap de alunos.
	 * @param grupos O hashmap de gruposl.
	 */
	public Controle() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosResponderam = new ArrayList<>();
	}
	
	/**
	 * Retorna um aluno específico que respondeu a pergunta.
	 * @param matricula A matrícula do aluno.
	 * @return O aluno relacionado à matrícula.
	 */
	public Aluno getAlunoRespondeu(int matricula) {
		return this.alunosResponderam.get(matricula);
	}
	
	/**
	 * Cadastra um aluno.
	 * @param matricula A matrícula do aluno.
	 * @param nome O nome do aluno.
	 * @param curso O curso do aluno.
	 */
	public void cadastrarAluno(String matricula, String nome, String curso) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			Validador.matriculaJaCadastrada(alunos, matricula);
			this.alunos.put(matricula, aluno);
	}
	
	/**
	 * Consulta os atributos de um objeto Aluno específico.
	 * @param matricula A matrícula do aluno
	 * @return Uma string contendo os dados do aluno formatados.
	 */
	public String consultarAluno(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		Validador.alunoNaoCadastrado(this.alunos, matricula);
		return "Aluno: " + aluno.getMatricula() + " - " + aluno.getNome() + " - " +
				aluno.getCurso();
	}
	
	/**
	 * Cadastra um grupo, podendo ter limite de alunos ou não.
	 * @param tema O tema do grupo.
	 * @param tamanho O tamanho do grupo. Pode assumir o 
	 * valor vazio para indicar que não há limite.
	 */
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

	/**
	 * Insere um aluno em um grupo.
	 * @param matricula A matrícula do aluno.
	 * @param tema O tema do aluno.
	 * @return Retorna uma confirmação caso o aluno seja alocado com sucesso.
	 */
	public  String alocaAluno(String matricula, String tema) {
		Grupo grupo = this.grupos.get(tema);
		Validador.grupoNaoCadastrado(this.grupos, tema);
		Validador.alunoNaoCadastrado(alunos, matricula);
	  if (grupo.getaAlunos().size() >= grupo.getTamanho() && grupo.getTamanho() != 0){
		  throw new ArrayIndexOutOfBoundsException("GRUPO CHEIO!");
	  } else {
		grupo.adicionaAoGrupo(this.alunos.get(matricula));
		return "ALUNO ALOCADO!";
	  }
	}
	
	/**
	 * Retorna se o aluno pertence ou não a um grupo específico.
	 * @param tema O tema do grupo.
	 * @param matricula A matrícula do aluno.
	 * @return Retorna true ou false representando a pertinência do aluno
	 */
	public boolean pertenceGrupo(String tema, String matricula) {
		Grupo grupo = this.grupos.get(tema);
		Aluno aluno = this.alunos.get(matricula);
		Validador.alunoNaoCadastrado(alunos, matricula);
		Validador.grupoNaoCadastrado(grupos, tema);
		return grupo.getaAlunos().contains(aluno);
	}
	
	/**
	 * Enumera todos os grupos dos quais o aluno faz parte.
	 * @param matricula A matrícula do aluno.
	 * @return Retorna a string formatada com os dados do(s) grupo(s)
	 * que o aluno participa.
	 */
	public String  enumeraGrupos(String matricula) {
		Aluno aluno = this.alunos.get(matricula);
		String elemento = "";
		for (Grupo grupo : this.grupos.values()) {
			if (grupo.getaAlunos().contains(aluno)) {
				elemento += grupo.toString();
				}
		}
		return "Grupos: \n" + elemento;
	}
	
	/**
	 * Adiciona o aluno à lista de alunos que responderam.
	 * @param matricula A matrícula do aluno.
	 */
		public void respostaAluno(String matricula) {
			Validador.alunoNaoCadastrado(alunos, matricula);
			this.alunosResponderam.add(this.alunos.get(matricula));
			
		}
		
		/**
		 * Mostra de forma ordenada os alunos que responderam à pergunta.
		 * @return Retorna os atributos de cada aluno que respondeu.
		 */
		public String imprimeRespostaAluno() {
			String alunos = "";
			int indice = 0;
			for (Aluno aluno : this.alunosResponderam) {
				indice ++;
				alunos += indice + aluno.toString();
			}
			return alunos;
		}
}
