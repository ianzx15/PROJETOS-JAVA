package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Controle;

class ControleTeste {
	private Controle controle = new Controle();
	@BeforeEach
	void preparaTeste() {
		controle.cadastraGrupo("lista", 2);
		controle.cadastrarAluno("1", "b", "a");
		controle.cadastrarAluno("2", "c", "d");
		controle.cadastrarAluno("3", "e", "f");
		
	}
	//Cadastrando aluno
	@Test
	void cadastrarAluno1() {
		fail("Not yet implemented");
	}
	
	//Cadastrando aluno com mesma matrícula
	@Test
	void cadastrarAluno2() {
		fail("Not yet implemented");
	}
	
	//Cadastrando aluno com mesmo nome e matrícula diferente
	@Test
	void cadastrarAluno3() {
		fail("Not yet implemented");
	}
	
	//Cadastrando aluno com matrícula, nome e curso nulos
	@Test
	void cadastrarAluno4() {
		fail("Not yet implemented");
	}
	
	
	//Exibindo aluno não cadastrado
	@Test
	void exibeAluno1() {
		fail("Not yet implemented");
	}
	
	//Exibindo aluno
	@Test
	void exibeAluno2() {
		fail("Not yet implemented");
	}

	//Alocando aluno em um grupo
	@Test
	void alocaAluno1() {
	}
	//Alocando aluno em um grupo que não existe
	@Test
	void alocaAluno2() {
	}
	//Alocando aluno que não existe
	@Test
	void alocaAluno3() {
	}
	
	//Alocando aluno que já foi alocado
	@Test
	void alocaAluno4() {
	}
	
	//Alocando aluno acima do limite do grupo
	@Test
	void alocaAluno5() {
	}
	
	//Aluno pertence ao grupo
	@Test
	void pertinencia1() {
	}
	
	//Aluno não pertence ao grupo
	@Test
	void pertinencia2() {
	}
	
	//Grupo não existe
	@Test
	void pertinencia3() {
	}
}