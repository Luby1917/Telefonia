package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fecha.Fecha;
import fecha.Periodo;

public class PeriodoTest {
	Fecha f1, f2;
	Periodo p;
	
	@Before
	public void init(){
		p = new Periodo();
		f1 = new Fecha();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		f2 = new Fecha();
	}
	@After
	public void finish(){
		f1= f2= null;
	}

	@Test
	public void testPeriodoFechaFecha() {
		Periodo p1 = new Periodo(f1, f2);
		assertEquals(f1, p1.getFechaInicio());
		assertEquals(f2, p1.getFechaFin());
		
	}

	@Test
	public void testSetFechaInicio() {
		p.setFechaInicio(f2);
		assertEquals(f2, p.getFechaInicio());
	}

	@Test
	public void testSetFechaFin() {
		p.setFechaFin(f1);
		assertEquals(f1, p.getFechaFin());
	}
	
	
	@Test
	public void testEstaDentroFecha() {
		Fecha fechaI = new Fecha();
		Fecha f3 = new Fecha();
		fechaI.setFecha(10, 2, 2000);

		Fecha fechaF = new Fecha();
		fechaF.setFecha(10, 5, 2014);
		
		Periodo periodo = new Periodo(fechaI, fechaF);
	
		
		f3.setFecha(10, 6, 2014);
		assertFalse(periodo.estaDentro(f3));
	
		f3.setFecha(10, 3, 2010);
		assertTrue(periodo.estaDentro(f3));
		
		
	}

}
