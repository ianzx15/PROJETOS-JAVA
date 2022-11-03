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
        this.contatoBase = new Contato("Matheus", "Gaudencio", "555-5551");
        agendaBase.adicionaFavorito(agendaBase.getContato(2),1);
        agendaBase.adicionaFavorito(agendaBase.getContato(100),10);
        agendaBase.adicionaFavorito(agendaBase.getContato(1),5);

    }
	
	@Test
	void testEqualsContato() {
		assertTrue(contatoBase.equals(contatoBase));
	}
	
	@Test
	void testEqualsContato1() {
		assertFalse(contatoBase.equals(agendaBase.getContato(100)));
	}

	@Test
	void testToString() {
		assertEquals("\n1 - ian evangelista"
				+ "\n2 - batata assada"
				+ "\n100 - beterraba cozida", this.contatoBase.toString(agendaBase, false));
	}
	
	@Test
	void testToString1() {
		assertEquals("\n1 - batata assada"
				+ "\n5 - ian evangelista"
				+ "\n10 - beterraba cozida", this.contatoBase.toString(agendaBase, true));
	}
	
	
	
	

}
