package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Controle;

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
	
	//Cadastrando aluno com matrícula, nome e curso nulos
	@Test
	void cadastrarAluno4() {
		try {
			this.controle.cadastrarAluno(null, null, null);
		} catch (NullPointerException erro) {}
	}
	
	//Exibindo aluno não cadastrado
	@Test
	void exibeAluno1() {
		try {
			this.controle.consultarAluno("77");
			fail("ALUNO NÃO CADASTRADO");
		} catch (NullPointerException erro) {}
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
	    assertEquals("ALUNO ALOCADO",this.controle.alocaAluno("2", "lista"));
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
	
	//Aluno cadastrado não pertence ao grupo
	@Test
	void pertinencia2() {
		try {
			controle.pertenceGrupo("lista", "55");
			fail("ALUNO NÃO CADASTRADO.");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Pertinência a grupo que não existe	@Test
	void pertinencia3() {
		try {
			controle.pertenceGrupo("tema", "1");
			fail("GRUPO NÃO CADASTRADO");
		} catch (IllegalArgumentException erro) {}
	}
	
	//Pertinência de aluno não cadastrado 
	@Test
	void pertinencia4() {
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
}
