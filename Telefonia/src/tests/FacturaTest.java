package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import llamadas.Llamada;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tarifas.Tarifa;
import tarifas.TarifaBasica;
import facturas.Factura;
import fecha.Fecha;
import generador.Generador;

public class FacturaTest {
	Factura f;
	Fecha fcrea;
	int duracion;
	Tarifa tarifa;
	Generador gn;

	@Before
	public void init() {
		gn = new Generador();
		duracion =6;
		tarifa = gn.generaTarifa();
		fcrea = new Fecha();
		f = new Factura(tarifa);
	}
	
	@After
	public void finish(){
		gn =null;
		f= null;
	}

	@Test
	public void testFacturaInt() {
		assertEquals(tarifa, f.getTarifaAplicada());
		assertEquals(0, f.getLlamadas().size());
		assertEquals(0, f.getSegundosConsumidos());
		
	}
/*
	@Test
	public void testCalcularImporte() {//TODO cambiar conforme Decorador
		assertEquals(0, f.getImporte(),0);
		Llamada ll = new Llamada("A", "B", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		assertEquals((double)(duracion*f.getTarifaAplicada().getCoste())/100, f.getImporte(),0);//TODO
	}

	@Test
	public void testAnadirLlamada() {
		Llamada ll = new Llamada("A", "B", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		assertEquals(1, f.getLlamadas().size());
		assertEquals(ll, f.getLlamadas().get(f.getLlamadas().size()-1));
		
	}
*/
	@Test
	public void testEmitirFactura() {
		Llamada ll = new Llamada("A", "B", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		ll = new Llamada("A", "C", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		Factura fac = f.emitirFactura();
		Fecha fecha = new Fecha();
		assertEquals(fac.getFecha(), fecha);
		assertEquals(fac.getPeriodoFacturacion().getFechaInicio(), fcrea);
		assertEquals(fac.getPeriodoFacturacion().getFechaFin(), fecha);
	
	}

	@Test
	public void testGetSegundosConsumidos() {
		Llamada ll = new Llamada("A", "B", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		assertEquals(duracion, f.getSegundosConsumidos());
		ll = new Llamada("A", "C", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		assertEquals(duracion*2, f.getSegundosConsumidos());
	}

	@Test
	public void testGetTarifaAplicada() {
		assertEquals(tarifa, f.getTarifaAplicada());
	}

	@Test
	public void testGetFechaEmision() {
		f.emitirFactura();
		assertEquals(fcrea, f.getFecha());
	}

	@Test
	public void testGetLlamadas() {
		List<Llamada> llamadas= new ArrayList();
		Llamada ll = new Llamada("A", "B", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		llamadas.add(ll);
		assertEquals(duracion, f.getSegundosConsumidos());
		ll = new Llamada("A", "C", duracion, f.getTarifaAplicada());
		f.anadirLlamada(ll);
		llamadas.add(ll);
		assertEquals(llamadas, f.getLlamadas());
	}

}
