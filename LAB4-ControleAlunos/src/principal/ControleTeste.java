package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;
import ControleAlunos.Controle;
import ControleAlunos.Grupo;

class ControleTeste {
	private Controle controle = new Controle();
	@BeforeEach
	void preparaTeste() {
		controle.cadastraGrupo("lista", "2");
		controle.cadastrarAluno("1", "banana", "frita");
		controle.cadastrarAluno("2", "cebola", "cortada");
		controle.cadastrarAluno("3", "molho", "branco");
		controle.alocaAluno("1", "lista");
	}
	
	//Construtor Aluno com matrícula inválida
	@Test
	void construtorAluno1() {
		try {
			Aluno aluno = new Aluno("", "a", "b");
			fail("ARGUMENTO INVÁLIDO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Construtor Aluno com nome inválido
	@Test
	void construtorAluno2() {
		try {
			Aluno aluno = new Aluno("1", "", "b");
			fail("ARGUMENTO INVÁLIDO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Construtor Aluno com curso inválido
	@Test
	void construtorAluno3() {
		try {
			Aluno aluno = new Aluno("1", "a", "");
			fail("ARGUMENTO INVÁLIDO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Construtor Aluno
	@Test
	void construtorAluno4() {
			Aluno aluno = new Aluno("5", "suco", "doce");
			assertEquals("suco", aluno.getNome());
	}
	
	
	//Construtor Grupo
	@Test
	void construtorGrupo1() {
			Grupo grupo = new Grupo("lista", "3");
			assertEquals("lista", grupo.getTema());
	}
	
	//Construtor Grupo com tema inválido
	@Test
	void construtorGrupo2() {
			try{
				Grupo grupo = new Grupo("", "3");
				fail("ARGUMENTO INVÁLIDO");
			} catch (IllegalArgumentException erro) {}
	}
	
	//Construtor Grupo sem limite de tamanho
		@Test
		void construtorGrupo3() {
			Grupo grupo = new Grupo("lista");
			assertEquals(0, grupo.getTamanho());	
		}
	
		
	//Cadastrando aluno
	@Test
	void cadastrarAluno1() {
		this.controle.cadastrarAluno("11", "batata", "doce");
		assertEquals("Aluno: 11 - batata - doce",controle.consultarAluno("11"));
	}
	
	//Cadastrando aluno com mesma matrícula
	@Test
	void cadastrarAluno2() {
		try{
			this.controle.cadastrarAluno("1", "cenoura", "ralada");
			fail("MATRÍCULA JÁ CADASTRADA");
		} catch (IllegalArgumentException erro) {}
		
	}
	//Cadastrando aluno com mesmo nome e matrícula diferente
	@Test
	void cadastrarAluno3() {
			this.controle.cadastrarAluno("12", "banana", "frita");
			assertEquals("Aluno: 12 - banana - frita",controle.consultarAluno("12"));
	}
	
	//Cadastrando aluno com matrícula inválida
	@Test
	void cadastrarAluno4() {
		try {
			this.controle.cadastrarAluno("", "pao", "doce");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Exibindo aluno não cadastrado
	@Test
	void exibeAluno1() {
		try {
			this.controle.consultarAluno("77");
			fail("ALUNO NÃO CADASTRADO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Exibindo aluno
	@Test
	void exibeAluno2() {
			this.controle.consultarAluno("1");
			assertEquals("Aluno: 1 - banana - frita",controle.consultarAluno("1"));
	}

	//Alocando aluno em um grupo
	@Test
	void alocaAluno1() {
		this.controle.alocaAluno("1", "lista");
		assertTrue(this.controle.pertenceGrupo("lista", "1"));
	}
	//Alocando aluno em um grupo que não existe
	@Test
	void alocaAluno2() {
		try{
			this.controle.alocaAluno("1", "conjuntos");
			fail("GRUPO NÃO CADASTRADO.");
		} catch (IllegalArgumentException erro) {}
	}
	//Alocando aluno que não existe
	@Test
	void alocaAluno3() {
		try {
			this.controle.alocaAluno("99", "lista");
			fail("ALUNO NÃO CADASTRADO.");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Alocando aluno que já foi alocado
	@Test
	void alocaAluno4() {
	    assertEquals("ALUNO ALOCADO!",this.controle.alocaAluno("2", "lista"));
	}
	
	//Ultrapassando o limite de alunos por grupo
	@Test
	void alocaAluno5() {
		try{
			controle.alocaAluno("3", "lista");
			controle.alocaAluno("2", "lista");
			fail("GRUPO CHEIO");
		} catch (ArrayIndexOutOfBoundsException erro) {}
	}
	
	//Pertinência  ao grupo
	@Test
	void pertinencia1() {
		assertTrue(controle.pertenceGrupo("lista", "1"));
		assertFalse(controle.pertenceGrupo("lista", "2"));
	}
	
	//Pertinência a grupo que não existe	
	@Test
	void pertinencia2() {
		try {
			controle.pertenceGrupo("tema", "1");
			fail("GRUPO NÃO CADASTRADO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Pertinência de aluno não cadastrado 
	@Test
	void pertinencia3() {
		try {
			controle.pertenceGrupo("lista", "33");
			fail("ALUNO NÃO CADASTRADO.");
		} catch (IllegalArgumentException erro) {}
	}
		
	//Criando grupo sem restrição de tamanho
	@Test
	void criarGrupo1() {
			controle.cadastraGrupo("conjuntos", "");
			controle.alocaAluno("1", "conjuntos");
			assertEquals("Grupos: \n- lista 1/2\n- conjuntos 1/...\n",controle.enumeraGrupos("1"));
	}
	//Criando grupo com restrição de tamanho
	@Test
	void criarGrupo2() {
			controle.cadastraGrupo("restrito", "2");
			controle.alocaAluno("1", "restrito");
			assertEquals("Grupos: \n- lista 1/2\n- restrito 1/2\n",controle.enumeraGrupos("1"));
	}
	
	//Criando grupo com nome repetido
	@Test
	void criarGrupo3() {
		try{
			controle.cadastraGrupo("lista", "22");
			fail("GRUPO JÁ CADASTRADO!");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Enumera grupo com limite de alunos
	@Test
	void exibeGruposAluno1() {
		controle.alocaAluno("2", "lista");
		controle.cadastraGrupo("tema", "5");
		controle.alocaAluno("2", "tema");
		assertEquals("Grupos: \n- lista 2/2\n"
				+ "- tema 1/5\n", controle.enumeraGrupos("2"));
	}
	
	//Enumera grupos sem limite de aluno
	@Test
	void exibeGruposAluno2() {
		controle.alocaAluno("2", "lista");
		controle.cadastraGrupo("tema", "");
		controle.alocaAluno("2", "tema");
		assertEquals("Grupos: \n- lista 2/2\n"
				+ "- tema 1/...\n", controle.enumeraGrupos("2"));
	}
	
	//Enumera grupos de aluno sem grupo
		@Test
		void exibeGruposAluno3() {
			controle.cadastraGrupo("tema", "");
			assertEquals("Grupos: \n", controle.enumeraGrupos("2"));
		}
		

	//Registra resposta do aluno
	@Test
	void registraResposta1() {
		controle.respostaAluno("1");
		assertEquals("banana", controle.getAlunoRespondeu(0).getNome().toString());
	}
	
	//Registra resposta de aluno não cadastrado
	@Test
	void registraResposta2() {
		try{
			controle.respostaAluno("222");
			fail("ALUNO NÃO CADASTRADO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Imprime alunos que responderam
	@Test
	void imprimeRespostaAluno1() {
		controle.respostaAluno("1");
		controle.respostaAluno("3");
		assertEquals("1. 1 - banana - frita\n"
				+ "2. 3 - molho - branco\n", controle.imprimeRespostaAluno());
	}
	
	//Imprime vazio caso alunos não tenham respondido
		@Test
		void imprimeRespostaAluno2() {
			assertEquals("", controle.imprimeRespostaAluno());
		}
	
		
}
