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
	//adicionar nos limites
	void testAdicionaFavorito() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.adicionaFavorito(agendaBase.getContato(100), 1);
		assertTrue(agendaBase.getContatoFavorito(10).equals(contatoBase));
		assertTrue(agendaBase.getContatoFavorito(1).equals(agendaBase.getContato(100)));
	}
	
	@Test
	//adicionar em uma posição inexistente
	void testAdicionaFavorito1() {

	}
	
	@Test
	//sobrescrever contato favorito
	void testAdicionaFavorito2() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.adicionaFavorito(agendaBase.getContato(2), 10);
		assertFalse(agendaBase.getContatoFavorito(10).equals(contatoBase));
	}
	
	
	@Test
	//remove favorito da posicao limite
	void testRemoveFavorito() {
		agendaBase.adicionaFavorito(contatoBase, 10);
		agendaBase.removeFavorito(10);
		assertTrue(agendaBase.getContatoFavorito(10) == null);
	}

	@Test
	void testCadastraContatoIntStringStringString() {
	}

	@Test
	void testCadastraContatoIntContato() {
	}

	@Test
	void testImprimeContato() {
	}


}
