package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class ContatoTest {
	private Contato contatoBase;
	private Agenda agendaBase;
	
	@BeforeEach
	 void preparaContatos() {
		agendaBase = new Agenda();
		agendaBase.cadastraContato(1, "ian", "evangelista", "(83) 99292922");
		agendaBase.cadastraContato(2, "batata", "assada", "(55) 22222222");
		agendaBase.cadastraContato(100, "beterraba", "cozida", "(33) 41414141");
        this.contatoBase = new Contato("leguminosas", "fritas", "(32) 555-5551");
        agendaBase.adicionaFavorito(agendaBase.getContato(2),1);
        agendaBase.adicionaFavorito(agendaBase.getContato(100),10);
        agendaBase.adicionaFavorito(agendaBase.getContato(1),5);
    }
  
	@Test
	/**
	 * verifica se existem contatos iguais.
	 */
	void testEqualsContato() {
		assertTrue(this.contatoBase.equals(this.contatoBase));
	}

	@Test
	/**
	 * Retorna o contato em formato de string.
	 */
	void testToString() {
		assertEquals("batata assada", this.agendaBase.getContato(2).toString());
	}
	
	@Test
	/**
	 * Verifica se há dois contatos iguais
	 */
	void testExisteIguais() {
		Contato contato = new Contato("acerola", "gelada", "(32) 32323232");
		assertFalse(contato.existeIguais(agendaBase.getListaContatos()));
		agendaBase.cadastraContato(77, "acerola", "gelada", "(32) 32323232");
		assertTrue(contato.existeIguais(agendaBase.getListaContatos()));
		
	}

}
