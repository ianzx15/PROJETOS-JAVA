package principal;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class mainTeste {
	
	private MeuDesafioMinhaVida teste = new MeuDesafioMinhaVida();
	
	/**
	 * Criando desafio
	 */
	@Test
	void criarDesafio1() {
		assertEquals(0,teste.addDesafio("batata"));
		assertEquals(1,teste.addDesafio("legume"));
	}
	
	/**
	 * Criando desafio com nome ja existente
	 */
	@Test
	void criarDesafio2() {
		teste.addDesafio("batata");
		teste.addDesafio("legume");
		assertEquals(-1 ,teste.addDesafio("batata"));
		
	}
	
	/**
	 * Exibindo elemento 
	 */

	@Test
	void exibeDesafio1() {
		teste.addDesafio("batata");
		teste.addDesafio("legume");
		assertEquals("Título: legume\n"
				+ "0 execuções",teste.exibeDesafio(1));
	}
	
	/**
	 * Exibindo elemento fora dos limites
	 */

	@Test
	void exibeDesafio2() {
		teste.addDesafio("batata");
		teste.addDesafio("legume");
		assertEquals("Elemento fora dos limites",teste.exibeDesafio(4));
	}
	
	/**
	 * Adicionando ação
	 */

	@Test
	void addAcao() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		
		assertEquals("batata", teste.getTitulo(0));
	}
	
	/**
	 * Progredindo ação sem valor específico
	 */

	@Test
	void progredirAcao1() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.addAcao(0, "12/12/2022", 32);
		teste.progressoAcao(44);
		teste.progressoAcao(44);
		teste.progressoAcao(32);
		assertEquals(20, teste.getProgresso(44));
		assertEquals(10, teste.getProgresso(32));
	}
	
	/**
	 * Progredindo ação com valor específico
	 */

	@Test
	void progredirAcao2() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.progressoAcao(44, 30);
		teste.progressoAcao(44);
		assertEquals(40, teste.getProgresso(44));
	}
	
	/**
	 * Progredindo ao limite 100
	 */

	@Test
	void progredirAcao3() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.progressoAcao(44, 90);
		teste.progressoAcao(44);
		assertEquals(100, teste.getProgresso(44));
	}
	
	
	/**
	 * Progredindo além do limite 100
	 */

	@Test
	void progredirAcao4() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.progressoAcao(44, 95);
		teste.progressoAcao(44);
		assertEquals(0, teste.getProgresso(44));
		teste.progressoAcao(44);
		assertEquals(10, teste.getProgresso(44));
	}
	
	/**
	 * Contando execuções
	 */

	@Test
	void contarExecucao1() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.progressoAcao(44, 100);
		teste.progressoAcao(44, 100);
		teste.progressoAcao(44, 100);
		teste.progressoAcao(44, 100);
		assertEquals(2, teste.getExecucoes(0));
	}
	
	/**
	 * Obtendo execução por meio de duas ações
	 */

	@Test
	void contarExecucao2() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.addAcao(0, "09/08/2022", 77);
		teste.progressoAcao(44, 66);
		teste.progressoAcao(44, 56);
		teste.progressoAcao(77, 98);
		teste.progressoAcao(77, 22);
		assertEquals(2, teste.getExecucoes(0));
	}
	
	/**
	 * Listando ações
	 */

	@Test
	void listarAcoes() {
		teste.addDesafio("batata");
		teste.addAcao(0, "15/12/2022", 44);
		teste.addAcao(0, "13/11/2022", 29);
		teste.addAcao(0, "13/11/2022", 22);

		teste.addDesafio("legume");
		teste.addAcao(1, "12/5/2022", 9);
		
		assertEquals("Acao 29 - 13/11/2022 - batata - 0\n"
				+ "Acao 44 - 15/12/2022 - batata - 0\n"
				+ "Acao 9 - 12/5/2022 - legume - 0\n"
				+ "Acao 22 - 13/11/2022 - batata - 0\n", teste.listarAcao());
		
	}
	
}
