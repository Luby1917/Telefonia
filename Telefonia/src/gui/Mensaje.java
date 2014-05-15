package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mensaje {
	
	boolean resultado=false;
	String nombre, mensaje;
	
	public Mensaje(String nombre, String mensaje){
		
	}
	
	public boolean mensaje(){
		final JFrame frm = new JFrame(nombre);
		Container cont = frm.getContentPane();
		JLabel labelMensaje = new JLabel(mensaje);
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado=true;
				frm.setVisible(false);
				frm.dispose();
			}
		});
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resultado=false;
				frm.setVisible(false);
				frm.dispose();
			}
		});
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		cont.setLayout(new BoxLayout(cont, BoxLayout.PAGE_AXIS));
		
		cont.add(labelMensaje);
		panel.add(botonAceptar);
		panel.add(botonCancelar);
		cont.add(panel);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		frm.pack();
		
		return resultado;
	}
}
