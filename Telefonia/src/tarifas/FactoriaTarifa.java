package tarifas;



public class FactoriaTarifa {
	Tarifa tarifa;
	public FactoriaTarifa(TipoTarifa tipoTarifa) {
		tarifa = new TarifaBasica(nombre, pS, coste)
	}
 
		public void anadirTarifa(TipoTarifa tipoTarifa) {
			switch (tipoTarifa) {
			case TARIFA_DOMINGO:
				tarifa = new TarifaAdicional(tipoTarifa);
				break;
			case TARIFA_TARDE:
				tarifa = new TarifaAdicional(tipoTarifa);
				break;
		}
	
	public Tarifa getTarifa(){
		return tarifa;
	}

}
