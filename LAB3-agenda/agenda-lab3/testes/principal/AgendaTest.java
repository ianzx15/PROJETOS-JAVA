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
		contatoBase = new Contato("cebola", "frita", "(04) 52255252");
		agendaBase.cadastraContato(30, contatoBase);
		
	}
	@Test
	/**
	 * adiciona contato nos limites
	 */
	void testAdicionaFavorito() {
		this.agendaBase.adicionaFavorito(this.contatoBase, 10);
		this.agendaBase.adicionaFavorito(this.agendaBase.getContato(100), 1);
		assertTrue(this.agendaBase.getContatoFavorito(10).equals(this.contatoBase));
		assertTrue(this.agendaBase.getContatoFavorito(1).equals(this.agendaBase.getContato(100)));
	}
	
	@Test
	/**
	 * Sobrescreve contato favorito
	 */
	void testAdicionaFavorito1() {
		this.agendaBase.adicionaFavorito(this.contatoBase, 10);
		this.agendaBase.adicionaFavorito(this.agendaBase.getContato(2), 10);
		assertFalse(this.agendaBase.getContatoFavorito(10).equals(this.contatoBase));
	}
	
	
	@Test
	/**
	 * Remove favorito 
	 */
	void testRemoveFavorito() {
		this.agendaBase.adicionaFavorito(this.contatoBase, 10);
		this.agendaBase.removeFavorito(10);
		assertTrue(this.agendaBase.getContatoFavorito(10) == null);
	}

	@Test
	/**
	 * Cadastra contato.
	 */
	void testCadastraContato() {
		Contato contato = new Contato("pepino", "fatiado", "(22) 48484848");
		this.agendaBase.cadastraContato(32, contato);
		this.agendaBase.cadastraContato(17, "cenoura", "ralada", "(21) 65656565");
		assertTrue(this.agendaBase.getContato(17) != null);
		assertTrue(this.agendaBase.getContato(32).equals(contato));
	}	

	@Test
	/**
	 * Sobrescrevendo contato.
	 */
	void testCadastraContato1() {
		assertTrue(this.agendaBase.getContato(30).equals(this.contatoBase));
		this.agendaBase.cadastraContato(30, "cenoura", "ralada", "(21) 65656565"); 
		assertFalse(this.agendaBase.getContato(30).equals(this.contatoBase));
	}
	
	@Test
	/**
	 * .Impede de cadastrar dois contatos iguais
	 */
	void testCadastraContato2() {
		agendaBase.cadastraContato(31, "cebola", "frita", "(04) 52255252" );
	assertNotEquals(agendaBase.getContato(30));

	}

	@Test
	/**
	 * 
	 */
	void testImprimeContato() {
	}


}
