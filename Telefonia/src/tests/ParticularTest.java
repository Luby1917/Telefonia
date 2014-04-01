package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import llamadas.Llamada;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tarifas.TarifaBasica;
import cliente.Direccion;
import cliente.Particular;
import excepciones.ObjetoNoEncontrado;
import facturas.Factura;
import fecha.Fecha;

public class ParticularTest {
	Particular p;
	Fecha f;
	TarifaBasica tarifa;

	@Before
	public void init() {
		tarifa = new TarifaBasica(5);
		Direccion direccion = new Direccion(1, "A", "A");
		p = new Particular("A", "A", "A", "A", direccion, tarifa, "A");
		f = new Fecha();
	}

	@After
	public void finish() {
		p = null;
		f = null;
	}

	@Test
	public void testEqualsObject() {
		
		Direccion direccion = new Direccion(1, "A", "A");
		Particular p1 = new Particular("B", "B", "B", "B", direccion, tarifa, "B");
		assertFalse(p.equals(p1));//Clientes Diferentes
		
		p1 = new Particular("A", "A", "B", "B", direccion, tarifa, "B");
		assertFalse(p.equals(p1));//Clientes Diferentes
		
		p1 = new Particular("B", "A", "B", "A", direccion, tarifa, "A");
		assertTrue(p.equals(p1));
		
		
	}

	@Test
	public void testParticularStringStringStringStringDireccionIntString() {
		String nombre = "B";
		String apellido = "B";
		String NIF = "B";
		String tel = "B";
		Direccion direccion = new Direccion(1, "A", "A");
		String correoE = "B";

		Particular part = new Particular(nombre, tel, apellido, NIF, direccion,
				tarifa, correoE);
		assertEquals(nombre, part.getNombre());
		assertEquals(apellido, part.getApellidos());
		assertEquals(NIF, part.getNIF());
		assertEquals(tel, part.getTelefono());
		assertEquals(direccion, part.getDireccion());
		assertEquals(tarifa, part.getTarifa());
		assertEquals(correoE, part.getCorreoE());
	}

	@Test
	public void testGetFecha() {
		assertEquals(f, p.getFecha());
	}

	@Test
	public void testSetApellidos() {
		String str = "B";
		p.setApellidos(str);
		assertEquals(str, p.getApellidos());
	}

	@Test
	public void testSetTarifa() {
		TarifaBasica t = new TarifaBasica(4);
		p.setTarifa(t);
		assertEquals(t, p.getTarifa());
	}

	@Test
	public void testSetNombre() {
		String str = "B";
		p.setNombre(str);
		assertEquals(str, p.getNombre());
	}

	@Test
	public void testSetNIF() {
		String str = "B";
		p.setNIF(str);
		assertEquals(str, p.getNIF());
	}

	@Test
	public void testSetDireccion() {
		Direccion direccion = new Direccion(1, "A", "A");
		p.setDireccion(direccion);
		assertEquals(direccion, p.getDireccion());
	}

	@Test
	public void testSetCorreoE() {
		String str = "B";
		p.setCorreoE(str);
		assertEquals(str, p.getCorreoE());
	}

	@Test
	public void testGetFactura() {
		Llamada ll = new Llamada("A", "A", 1, tarifa);

		p.anadirLlamada(ll);
		p.emitirFactura();

		try {
			int id = p.getFacturas().get(p.getFacturas().size() - 1).getId();
			p.getFactura(id);
		} catch (ObjetoNoEncontrado e) {
			fail("Esta factura existe");
		}
		try {

			p.getFactura(-1);
			fail("Esta factura no existe");
		} catch (ObjetoNoEncontrado e) {
		}
	}

	@Test
	public void testAnadirLlamada() {
		
		Factura fac = new Factura(tarifa);
		Llamada ll = new Llamada("A", "A", 1, tarifa);
		fac.anadirLlamada(ll);
		p.anadirLlamada(ll);
		
		
		assertEquals(p.getLlamadas().get(p.getLlamadas().size()-1), ll);
		
	}

	@Test
	public void testGetLlamadas() {
		
		List<Llamada> lista = new ArrayList<Llamada>();
		
		Factura fac = new Factura(tarifa);
		Llamada ll = new Llamada("A", "A", 1, tarifa);
		fac.anadirLlamada(ll);
		lista.add(ll);
		
		p.anadirLlamada(ll);
		p.emitirFactura();
		
		ll = new Llamada("A", "A", 1, tarifa);
		fac.anadirLlamada(ll);
		lista.add(ll);
		
		p.anadirLlamada(ll);
		p.emitirFactura();
		
		
		assertEquals(p.getLlamadas(), lista);
	
		

	}

	@Test
	public void testEmitirFactura() {
		
		Factura fac = new Factura(tarifa);
		Llamada ll = new Llamada("A", "A", 1, tarifa);
		fac.anadirLlamada(ll);
		p.anadirLlamada(ll);
		p.emitirFactura();
		fac=fac.emitirFactura();
		
		
		/*
		 * Debido a que las facturas tiene un codigo unico no se pueden probar
		assertEquals(p.getFacturas().get(p.getFacturas().size()-1), fac);
		*/
	}

	@Test
	public void testGetFacturas() {
		/*
		 * Debido a que las facturas tiene un codigo unico no se pueden probar
		 * 
		 * */
	}

	@Test
	public void testSetTelefono() {
		String str = "2";
		p.setTelefono(str);
		assertEquals(str, p.getTelefono());
	}

}
