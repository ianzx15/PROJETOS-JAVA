package lulaTeste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lula.CAD_COMITIVA;
import lula.CAD_LOCAL;
import lula.LulaSistema;

class LulaSistemaTest {
	private LulaSistema lula;
	
	@BeforeEach
	void preparaSistema() {
		lula = new LulaSistema();
		CAD_LOCAL local1 = new CAD_LOCAL("ic", "introducao", 1111);
		CAD_LOCAL local2 = new CAD_LOCAL("ac", "introducao", 1511);
		
		lula.cadastraLocal(local1);
		lula.cadastraLocal(local2);
		
		CAD_COMITIVA comi = new CAD_COMITIVA(0, "aaa", 15, 11111);
		CAD_COMITIVA comi2 = new CAD_COMITIVA(99, "bbb", 40, 11123321);
		CAD_COMITIVA comi3 = new CAD_COMITIVA(63, "ccc", 2, 11152);
		
		lula.cadastraComitiva(comi);
		lula.cadastraComitiva(comi2);
		lula.cadastraComitiva(comi3);
		lula.registraVisita("ic", 0);
		lula.registraVisita("ic", 99);
		lula.registraVisita("ac", 63);
		
	}
	
	@Test
	void testExibeLocal() {
		assertEquals("ic - introducao - 1111\n", this.lula.exibeLocal("ic") );
		assertEquals("ac - introducao - 1511\n", this.lula.exibeLocal("ac"));
	}

	@Test
	void testCadastraComitiva() {
		assertEquals(55, lula.contaVisita("ic"));
		assertEquals(2, lula.contaVisita("ac"));
	}

}
