package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class AgendaTest {

	private Agenda agendaBase;
	private Contato contatoBase;
	
	@BeforeEach
	void preparaContatos() {
		agendaBase = new Agenda();
		agendaBase.cadastraContato(1, "ian", "evangelista", "(83) 99292922");
		agendaBase.cadastraContato(2, "batata", "assada", "(55) 22222222");
		agendaBase.cadastraContato(100, "beterraba", "cozida", "(33) 41414141");
		
		this.contatoBase = new Contato("cebola", "frita", "(04) 52255252");
		agendaBase.cadastraContato(30, "cebola", "frita", "(04) 52255252");
		
	}
	@Test
	/**
	 * adiciona contato nos limites
	 */
	void testAdicionaFavorito() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.adicionaFavorito(agendaBase.getContato(100), 1);
		assertTrue(agendaBase.getContatoFavorito(10).equals(contatoBase));
		assertTrue(agendaBase.getContatoFavorito(1).equals(agendaBase.getContato(100)));
	}
	
	@Test
	/**
	 * Sobrescreve contato favorito
	 */
	void testAdicionaFavorito1() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.adicionaFavorito(agendaBase.getContato(2), 10);
		assertFalse(agendaBase.getContatoFavorito(10).equals(contatoBase));
	}
	
	
	@Test
	/**
	 * Remove favorito 
	 */
	void testRemoveFavorito() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.removeFavorito(10);
		assertTrue(agendaBase.getContatoFavorito(10) == null);
	}

	@Test
	/**
	 * Cadastra contato no menor limte.
	 */
	void testCadastraContato() {
		agendaBase.cadastraContato(1, "cenoura", "ralada", "(21) 65656565");
		assertTrue(agendaBase.getContato(1) != null);
	}	

	@Test
	/**
	 * Cadastra contato no maior limte.
	 */
	void testCadastraContato1() {
		agendaBase.cadastraContato(100, "pepino", "fatiado", "(22) 48484848");
		assertTrue(agendaBase.getContato(100) != null);
		
	}
	
	@Test
	/**
	 * Sobrescrevendo contato.
	 */
	void testCadastraContato2() {
		assertTrue(agendaBase.getContato(30).equals(contatoBase));
		agendaBase.cadastraContato(30, "cenoura", "ralada", "(21) 65656565"); 
		assertFalse(agendaBase.getContato(30).equals(contatoBase));
	}
	
	@Test
	/**
	 * Cadastra contato com nome vazio.
	 */
	void testCadastraContato3() {
		
	}
	
	@Test
	/**
	 * Cadastra contatos iguais.
	 */
	void testCadastraContato4() {
		
	}
	
	@Test
	/**
	 * Cadastra contato acima do limite.
	 */
	void testCadastraContato5() {
		
	}
	
	@Test
	/**
	 * Cadastra contato abaixo do limte.
	 */
	void testCadastraContato6() {
		
	}
	
	@Test
	/**
	 * Cadastra contato com telefone vazio.
	 */
	void testCadastraContato7() {
		
	}
	
	@Test
	/**
	 * Retorna o contato sem telefone cadastrado.
	 */
	void testImprimeContato1() {
		agendaBase.cadastraContato(66, "milho", "pipoca", "");
		assertEquals("\nmilho pipoca\n", agendaBase.imprimeContato(66));
	}
	
	@Test
	/**
	 * Trata um contato vazio
	 * 
	 */
	void testImprimeContato2() {
		assertNull(agendaBase.getContato(15));
		try {
			agendaBase.imprimeContato(15);
		} catch (IllegalArgumentException error) {}
	}
	
	
	
	@Test
	/**
	 * Retorna o contato formatado 
	 */
	void testImprimeContato3() {
		assertEquals("\nbatata assada\n(55) 22222222", agendaBase.imprimeContato(2));
	}

	
	@Test
	/**
	 * Retorna o contato formatado se está favoritado.
	 */
	void testImprimeContato4() {
		agendaBase.adicionaFavorito(contatoBase, 2);
		assertEquals("\n❤️ cebola frita\n(04) 52255252", agendaBase.imprimeContato(30));
	}
	
	@Test
	/**
	 * Trata uma posição iválida no limite inferior.
	 */
	void testImprimeContato5() {
		assertNull(agendaBase.getContato(0));
		try {
			agendaBase.getContato(0);
		} catch (IllegalArgumentException erro) {}
	}
	
	@Test
	/**
	 * Trata uma posição iválida no limite superior.
	 */
	void testImprimeContato6() {
		try {
			agendaBase.getContato(101);
		} catch (RuntimeException erro) {}
	}
}