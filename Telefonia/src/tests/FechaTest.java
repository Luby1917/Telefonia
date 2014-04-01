package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fecha.Fecha;

public class FechaTest {




	
	
	@Test
	public void testSetToString() {
		Fecha f1 = new Fecha();
		String hora = f1.toString().substring(10);//cortamos la hora
		f1.setFecha(10, 3, 2015);
		assertEquals(f1.toString(), "10/04/2015" +hora);
	}
	
	@Test
	public void testCompareToFecha() {
		
		Fecha f1 = new Fecha();
		Fecha f3 = new Fecha();
		Fecha f2 = new Fecha();
		f2.setFecha(11, 2, 2014);
		
		assertEquals(1, f1.compareTo(f2));
		assertEquals(-1, f2.compareTo(f1));
		assertEquals(f1, f3);
		
		
		
		
	}
	
	@Test
	public void testEqualsObject() {
		Fecha f1 = new Fecha();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
		}
		Fecha f2 = new Fecha();
		assertFalse(f1.equals(f2));
		f1= new Fecha();
		Fecha f3 = new Fecha();
		assertTrue(f1.equals(f3));
	}

}
