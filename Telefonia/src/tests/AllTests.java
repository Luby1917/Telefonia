package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CarteraClientesTest.class, DireccionTest.class,
		EmpresaTest.class, FacturaTest.class, FechaTest.class,
		LlamadaTest.class, ParticularTest.class, PeriodoTest.class })
public class AllTests {

}
