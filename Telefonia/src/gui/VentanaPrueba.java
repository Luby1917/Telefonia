package gui;

import javax.swing.JFrame;

public class VentanaPrueba {
	public static void main(String [] args){
		JFrame frm = new JFrame("Ventana");
		
		
		//PanelFactura pf = new PanelFactura(this);
		
		//frm.getContentPane().add(pt);
		//frm.setContentPane(pf);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.pack();
		frm.setVisible(true);
	}

}
