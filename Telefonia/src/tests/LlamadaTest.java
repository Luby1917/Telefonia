package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import llamadas.Llamada;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tarifas.TarifaBasica;
import fecha.Fecha;

public class LlamadaTest {
	Llamada ll;
	TarifaBasica tarifa;
	
	@Before
	public void init() {
		ll = new Llamada();
		tarifa = new TarifaBasica(5);
		

	}

	@After
	public void finish() {
		ll = null;
		tarifa = null;

	}
	
	
	@Test
	public void testLlamadaStringStringIntInt() {
		String telefonoDest= "6";
		String telefono= "6";
		int duracion = 2;
		Llamada llamada = new Llamada(telefono,telefonoDest, duracion,tarifa);
		assertEquals(telefonoDest, llamada.getTelefonoDestino());
		assertEquals(telefono, llamada.getTelefonoCliente());
		assertEquals(duracion, llamada.getDuracion());
		assertEquals(tarifa, llamada.getTarifa());
		
	
	
	
	}

	@Test
	public void testSetTelefonoCliente() {
		String telefono= "6";
		ll.setTelefonoCliente(telefono);
		assertEquals(telefono, ll.getTelefonoCliente());
	}

	@Test
	public void testSetTelefonoDestino() {
		String telefonoDest= "6";
		ll.setTelefonoDestino(telefonoDest);
		assertEquals(telefonoDest, ll.getTelefonoDestino());
	}

	@Test
	public void testSetFecha() {
		Fecha f = new Fecha();
		ll.setFecha(f);
		assertEquals(f, ll.getFecha());
	}

	@Test
	public void testSetDuracion() {
		int duracion = 2;
		ll.setDuracion(duracion);
		assertEquals(duracion, ll.getDuracion());
	}

	@Test
	public void testSetTarifa() {
	
		ll.setTarifa(tarifa);
		assertEquals(tarifa, ll.getTarifa());
	}

	@Test
	public void testSetCoste() {
		int coste = 4;
		ll.setCoste(coste);
		assertEquals(coste, ll.getCoste());
	}

	@Test
	public void testEqualsObject() {
		Llamada ll1 = new Llamada("A", "A", 1,tarifa);
		Llamada ll2 = new Llamada("A", "A", 1,tarifa);
		Llamada ll3 = new Llamada("B", "B", 2,tarifa);
		Llamada ll4 = new Llamada("A", "B", 2,tarifa);

		assertTrue(ll1.equals(ll2));
		assertFalse(ll1.equals(ll3));
		assertFalse(ll1.equals(ll4));
		assertTrue(ll1.equals(ll1));
		
		
	}

}
