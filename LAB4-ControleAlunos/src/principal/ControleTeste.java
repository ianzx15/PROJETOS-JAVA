package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.ControleAlunos;

class ControleTeste {
	@BeforeEach
	void preparaTeste() {
		ControleAlunos alunos = new ControleAlunos();
		alunos.cadastrarAluno("1111", null, null);
	}
	//Cadastrando aluno
	@Test
	void testCadastrarAluno1() {
		fail("Not yet implemented");
	}
	
	//Cadastrando aluno com mesma matrícula
	@Test
	void testCadastrarAluno2() {
		fail("Not yet implemented");
	}
	
	//Cadastrando aluno com mesmo nome e matrícula diferente
	@Test
	void testCadastrarAluno3() {
		fail("Not yet implemented");
	}

}
