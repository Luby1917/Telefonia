package programa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import carteraclientes.CarteraClientes;

public class Programa {
	static CarteraClientes cc;

	public static void main(String[] args) {
		cargar();
		ejecuta();
		guardar();
	}

	public static void ejecuta() {
		new Menu(cc);
	}

	private static void guardar() {
		try {
			FileOutputStream fos = new FileOutputStream("cartera.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cc);
			oos.close();
		} catch (Exception e) {
			System.out.println("Fallo al intentar guardar el programa");
			e.printStackTrace();
		}
	}

	private static void cargar() {
		try {
			FileInputStream fis = new FileInputStream("cartera.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cc = (CarteraClientes) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println("Fallo al intentar cargar el programa");
			e.printStackTrace();
		}

	}

}
