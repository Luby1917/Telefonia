package gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class PruebaGUI {
	
	public static void main(String [] args){
		
		JFrame frm = new JFrame("VENTANA");
		Container cont = frm.getContentPane();
		PanelClientes pc = new PanelClientes();
		pc.nuevoCliente();
		cont.add(pc, BorderLayout.NORTH);
		frm.setVisible(true);
		frm.pack();
		
		
	}

}
