package gui;

import javax.swing.JFrame;

public class VentanaPrueba {
	public static void main(String [] args){
		JFrame frm = new JFrame("Ventana");
		
		PanelTarifa pt =new PanelTarifa();
		PanelDireccion pd = new PanelDireccion();
		//frm.getContentPane().add(pt);
		frm.setContentPane(pd);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.pack();
		frm.setVisible(true);
	}

}
