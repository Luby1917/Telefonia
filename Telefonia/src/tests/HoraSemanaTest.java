package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import fecha.Fecha;
import fecha.HoraSemana;

public class HoraSemanaTest {
	HoraSemana h;
	int diaS;
	int hora;
	int min;
	int seg;

	@Before
	public void init() {
		h = new HoraSemana();
		diaS = 2;
		hora = 14;
		min = 33;
		seg = 56;
	}

	@After
	public void finish() {
		h = null;
	}

	@AfterClass
	public static void f() {//TODO
		System.out.println("\n\n");
		HoraSemana hs = new HoraSemana();
		hs.setDiaSemana(1);
		hs.setHora( 14, 15, 15);
		System.out.println(hs);
	}
	
	@Test
	public void testHoraSemanaIntIntIntInt() {

		HoraSemana hs = new HoraSemana();
		hs.setDiaSemana(diaS);
		hs.setHora( hora, min, seg);
		assertEquals(diaS, hs.getDiaSemana());
		assertEquals(hora, hs.getHora());
		assertEquals(min, hs.getMinutos());
		assertEquals(seg, hs.getSegundos());

	}

	@Test
	public void testSetHora() {
		h.setHora(hora, min, seg);
		assertEquals(hora, h.getHora());
		assertEquals(min, h.getMinutos());
		assertEquals(seg, h.getSegundos());

	}

	

	@Test
	public void testCompareTo() {
		HoraSemana h2;
		h = new HoraSemana();
		h.setDiaSemana(4);
		h.setHora(20, 43, 12);
		
		h2 = new HoraSemana();
		h2.setDiaSemana(5);
		h2.setHora(23, 43, 12);
		assertEquals(-1, h.compareTo(h2));

		h2 = new HoraSemana();
		h2.setDiaSemana(3);
		h2.setHora(23, 43, 12);
		assertEquals(1, h.compareTo(h2));

		h2 = new HoraSemana();
		h2.setDiaSemana(4);
		h2.setHora( 19, 43, 12);
		assertEquals(1, h.compareTo(h2));

		h2 = new HoraSemana();
		h2.setDiaSemana(4);
		h2.setHora( 20, 42, 12);
		assertEquals(1, h.compareTo(h2));

		h2 = new HoraSemana();
		h2.setDiaSemana(4);
		h2.setHora( 20, 43, 11);
		assertEquals(1, h.compareTo(h2));
			
		h2 = new HoraSemana();
		h2.setDiaSemana(4);
		h2.setHora(20, 43, 12);
		assertEquals(0, h.compareTo(h2));
	}
	@Test
	public void testCompararSemana() {
		Fecha f;
		h = new HoraSemana();
		h.setDiaSemana(4);
		h.setHora(20, 43, 12);
		
		f = new Fecha();
		f.setDiaSemana(5);
		f.setHora(23, 43, 12);
		assertEquals(-1, h.compararSemana(f));

		f = new Fecha();
		f.setDiaSemana(3);
		f.setHora(23, 43, 12);
		assertEquals(1, h.compararSemana(f));

		f = new Fecha();
		f.setDiaSemana(4);
		f.setHora( 19, 43, 12);
		assertEquals(1, h.compararSemana(f));

		f = new Fecha();
		f.setDiaSemana(4);
		f.setHora( 20, 42, 12);
		assertEquals(1, h.compararSemana(f));

		f = new Fecha();
		f.setDiaSemana(4);
		f.setHora( 20, 43, 11);
		assertEquals(1, h.compararSemana(f));
			
		f = new Fecha();
		f.setDiaSemana(4);
		f.setHora(20, 43, 12);
		assertEquals(0, h.compararSemana(f));
		
	}

}
