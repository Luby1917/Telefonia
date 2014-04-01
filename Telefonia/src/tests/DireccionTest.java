package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cliente.Direccion;

public class DireccionTest {

	Direccion d;
	
	@Before 
	public void init(){
		d = new Direccion();
	}
	
	@After
	public void finish(){
		d = null;
	}

	@Test
	public void testDireccionIntStringString() {
		int codPostal = 1;
		String provincia = "A";
		String poblacion = "A";
		Direccion dir = new Direccion(codPostal, provincia, poblacion);
		assertEquals(codPostal, dir.getCodPostal());
		assertEquals(provincia, dir.getProvincia());
		assertEquals(poblacion, dir.getPoblacion());
	}

	@Test
	public void testSetCodPostal() {
		int codPostal = 1;
		d.setCodPostal(codPostal);
		assertEquals(codPostal, d.getCodPostal());
	}

	@Test
	public void testSetProvincia() {
		String provincia = "A";
		d.setProvincia(provincia);				
		assertEquals(provincia, d.getProvincia());
	}

	@Test
	public void testSetPoblacion() {
		String poblacion = "A";
		d.setPoblacion(poblacion);
		assertEquals(poblacion, d.getPoblacion());
	}

}
