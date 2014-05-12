package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import tarifas.TarifasExtraDiaGratis;
import tarifas.TarifasExtraFranjaHoraria;

public class PanelTarifa extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5367590239077074168L;
	
	
	private JCheckBox tarifaHorasRebajadas;
	private JCheckBox tarifaDiaGratis;
	private JComboBox<String> horasRebajadas;
	private JComboBox<String> diaGratis;
	
	public PanelTarifa(){
		super();
		setLayout(new GridLayout(2,2));
		
		tarifaHorasRebajadas = new JCheckBox("Franja horaria con precio reducido");
		
		tarifaHorasRebajadas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox jc = (JCheckBox)e.getSource();
				if(jc.isSelected()){
					horasRebajadas.setEnabled(true);
				}else{
					horasRebajadas.setEnabled(false);
				}
			}
		});
		tarifaDiaGratis = new JCheckBox("Dia gratis");
		tarifaDiaGratis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox jc = (JCheckBox)e.getSource();
				if(jc.isSelected()){
					diaGratis.setEnabled(true);
				}else{
					diaGratis.setEnabled(false);
				}
			}
		});
		
		horasRebajadas = new JComboBox<String>();
		horasRebajadas.setEnabled(false);
		diaGratis = new JComboBox<String>();
		diaGratis.setEnabled(false);
		
		int size = TarifasExtraDiaGratis.values().length+1;
		String[] opcionesDiasGratis = new String[size];
		opcionesDiasGratis[0]="...";
		for(int i = 0; i < size-1;i++){
			opcionesDiasGratis[i+1] = TarifasExtraDiaGratis.values()[i].getNombre();
		}
		diaGratis.setModel(new DefaultComboBoxModel<String>(opcionesDiasGratis));

		size = TarifasExtraFranjaHoraria.values().length+1;
		String[] opcionesFranjaHoraria = new String[size];
		opcionesFranjaHoraria[0]="...";
		for(int i = 0; i < size-1;i++){
			opcionesFranjaHoraria[i+1] = TarifasExtraFranjaHoraria.values()[i].getNombre();
		}
		horasRebajadas.setModel(new DefaultComboBoxModel<String>(opcionesFranjaHoraria));

		add(tarifaHorasRebajadas);
		add(horasRebajadas);
		add(tarifaDiaGratis);
		add(diaGratis);
		
		
		
	}
	
	public String getHorasRebajadas(){
		String seleccion= (String) horasRebajadas.getSelectedItem();
		if(horasRebajadas.getSelectedIndex()==0)
			return null;
		else
			return seleccion;
	}
	
	public String getDiaGratis(){
		String seleccion= (String) diaGratis.getSelectedItem();
		if(diaGratis.getSelectedIndex()==0)
			return null;
		else
			return seleccion;
	}
	
	
	public void setHorasRebajadas(TarifasExtraFranjaHoraria horas){
		horasRebajadas.setSelectedItem(horas.getNombre());
		
	
	}
	
	public void setDiaGratis(TarifasExtraDiaGratis dia ){
		diaGratis.setSelectedItem(dia.getNombre());
		
		
	}
	
	

}
