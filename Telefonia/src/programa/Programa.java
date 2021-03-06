package programa;

import gui.Controlador;
import gui.ControladorImp;
import gui.Vista;
import gui.VistaImp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.SwingUtilities;

import carteraclientes.CarteraClientes;

public class Programa {
	static CarteraClientes cc;

	public static void main(String[] args) {
		cargar();
		ejecuta();
		guardar();
	}

	public static void ejecuta() {
		
		final Vista vista = new VistaImp();
		Controlador controlador = new ControladorImp();
		vista.setControlador(controlador);
		vista.setModelo(cc);
		controlador.setModelo(cc);
		controlador.setVista(vista);
		cc.setVista(vista);
	
		
		SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			vista.crear();
			vista.mostrar();
		}
		});
		
		
		
	}

	private static void guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("cartera3.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cc);
			oos.close();
		} catch (Exception e) {
			System.out.println("Fallo al intentar guardar el programa");
		}
	}

	private static void cargar() {
		try {
			FileInputStream fis = new FileInputStream("cartera3.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cc = (CarteraClientes) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("Fallo al intentar cargar el programa\nGenerando una nueva base de datos");
			Iniciador ini = new Iniciador(4);//4 clientes con 4 facturas con 4 llamadas cada una
			cc = ini.get();
		}

	}

}
