package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fecha.Fecha;
import fecha.HoraSemana;
import fecha.PeriodoSemana;

public class PeriodoSemanaTest {
	HoraSemana hI, hF;
	PeriodoSemana pS;
	@Before
	public void init() {
		hI = new HoraSemana();
		hI.setDiaSemana(1);
		hI.setHora(15,25,35);
		hF = new HoraSemana();
		hF.setDiaSemana(2);
		hF.setHora(15,25,35);
		pS = new PeriodoSemana();	
	}

	@After
	public void finish() {
		hI = null;
	}
	
	@Test
	public void testPeriodoSemanaHoraSemanaHoraSemana() {
		HoraSemana hIni = new HoraSemana();
		hIni.setDiaSemana(1);
		hIni.setHora(15,25,35);
		HoraSemana hFin = new HoraSemana();
		hFin.setDiaSemana(2);
		hFin.setHora(15,25,35);
		PeriodoSemana p = new PeriodoSemana(hIni, hFin); 
		assertEquals(hIni, p.getHoraIni());
		assertEquals(hFin, p.getHoraFin());		
	}

	@Test
	public void testSetHoraIni() {
		pS.setHoraIni(hI);
		assertEquals(hI, pS.getHoraIni());
	}

	@Test
	public void testSetHoraFin() {
		pS.setHoraFin(hF);
		assertEquals(hF, pS.getHoraFin());
	}

	@Test
	public void testEstaDentro() {
		/**
		 * hI = new HoraSemana(1,15,25,35);
	 	 * hF = new HoraSemana(2,15,25,35);
		 */
		pS.setHoraIni(hI);
		pS.setHoraFin(hF);
		Fecha f = new Fecha();
		f.setDiaSemana(1);
		f.setHora(15,25,30);
		
		assertFalse(pS.estaDentro(f));
		
		f = new Fecha();
		f.setDiaSemana(1);
		f.setHora(20,20,30);
		assertTrue(pS.estaDentro(f));
		
		f = new Fecha();
		f.setDiaSemana(2);
		f.setHora(15,20,35);
		assertTrue(pS.estaDentro(f));
		
		f = new Fecha();
		f.setDiaSemana(2);
		f.setHora(15,25,30);
		assertTrue(pS.estaDentro(f));
		
		f = new Fecha();
		f.setDiaSemana(2);
		f.setHora(25,25,35);
		assertFalse(pS.estaDentro(f));
		
	}

}
