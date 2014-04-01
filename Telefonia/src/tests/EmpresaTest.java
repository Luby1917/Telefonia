package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import llamadas.Llamada;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tarifas.TarifaBasica;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import excepciones.ObjetoNoEncontrado;
import fecha.Fecha;

public class EmpresaTest {

	Empresa e;
	Fecha f;
	TarifaBasica t;
	@Before
	public void init(){
		t = new TarifaBasica(1);
		Direccion direccion = new Direccion(1, "A", "A");
		e = new Empresa("A", "A", "A", direccion, t, "A");
		f = new Fecha();
	}
	
	@After
	public void finish(){
		e = null;
		f = null;
	}
	
	@Test
	public void testEmpresaStringStringStringDireccionIntString() {
		String nombre = "B";
		String NIF = "B";
		String tel = "B";
		Direccion direccion = new Direccion(1, "A", "A");
		String correoE = "B";
		Empresa part = new Empresa(nombre, tel,  NIF, direccion, t, correoE);
		assertEquals(nombre, part.getNombre());
		assertEquals(NIF, part.getNIF());
		assertEquals(tel, part.getTelefono());
		assertEquals(direccion, part.getDireccion());
		assertEquals(t,part.getTarifa());
		assertEquals(correoE, part.getCorreoE());
	}

	@Test
	public void testGetFecha() {
		assertEquals(f, e.getFecha());
	}

	@Test
	public void testSetTarifa() {
		e.setTarifa(t);
		assertEquals(t, e.getTarifa());
	}

	@Test
	public void testSetNombre() {
		String str = "B";
		e.setNombre(str);
		assertEquals(str, e.getNombre());
	}

	@Test
	public void testSetNIF() {
		String str = "B";
		e.setNIF(str);
		assertEquals(str, e.getNIF());
	}

	@Test
	public void testSetDireccion() {
		Direccion direccion = new Direccion(1, "A", "A");
		e.setDireccion(direccion);
		assertEquals(direccion, e.getDireccion());
	}

	@Test
	public void testSetCorreoE() {
		String str = "B";
		e.setCorreoE(str);
		assertEquals(str, e.getCorreoE());
	}


	@Test
	public void testGetFactura() {
		Llamada ll = new Llamada("A", "A", 1, t);

		e.anadirLlamada(ll);
		e.emitirFactura();

		try {
			int id = e.getFacturas().get(e.getFacturas().size() - 1).getId();
			e.getFactura(id);
		} catch (ObjetoNoEncontrado e) {
			fail("Esta factura existe");
		}
		try {

			e.getFactura(-1);
			fail("Esta factura no existe");
		} catch (ObjetoNoEncontrado e) {
		}
	}

	

	@Test
	public void testSetTelefono() {
		String str = "2";
		e.setTelefono(str);
		assertEquals(str, e.getTelefono());
	}



	@Test
	public void testEqualsObject() {
		Direccion direccion = new Direccion(1, "A", "A");
		Empresa e2 = new Empresa("B", "B", "B", direccion, t, "B");
		assertFalse(e.equals(e2));//Clientes Diferentes
		
		e2 = new Empresa("A", "A",  "B", direccion, t, "B");
		assertFalse(e.equals(e2));//Clientes Diferentes
		
		e2 = new Empresa("B", "A", "A", direccion, t, "A");
		assertTrue(e.equals(e2));
		
	}

}
