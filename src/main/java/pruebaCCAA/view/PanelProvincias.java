package pruebaCCAA.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;

import pruebaCCAA.controllers.ControladorComunidadMongo;
import pruebaCCAA.controllers.ControladorProvinciasMongo;
import pruebaCCAA.entities.ComunidadAutonoma;
import pruebaCCAA.entities.Provincia;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelProvincias extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCode;
	private JTextField jtfLabel;
	public JComboBox<ComunidadAutonoma> jcbCcaa;  //le quito el private porque tengo que usarlo luego en el panelCCAA.
	private PanelTabla panelTablita;
	

	public PanelTabla setPanelTabla(PanelTabla panelTablita) {
		return this.panelTablita = panelTablita;
	}
	
	
	
	/**
	 * Create the panel.
	 */
	public PanelProvincias() {
				
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestorDeProvincias = new JLabel("Gestor de Provincias");
		lblGestorDeProvincias.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblGestorDeProvincias = new GridBagConstraints();
		gbc_lblGestorDeProvincias.gridwidth = 3;
		gbc_lblGestorDeProvincias.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestorDeProvincias.gridx = 0;
		gbc_lblGestorDeProvincias.gridy = 1;
		add(lblGestorDeProvincias, gbc_lblGestorDeProvincias);
		
		JLabel lblNewLabel = new JLabel("Code Provincia:  ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfCode = new JTextField();
		jtfCode.setEnabled(false);
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 3;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre (Label): ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 4;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Com. Autónoma: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbCcaa = new JComboBox<ComunidadAutonoma>();
		GridBagConstraints gbc_jcbCcaa = new GridBagConstraints();
		gbc_jcbCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCcaa.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCcaa.gridx = 1;
		gbc_jcbCcaa.gridy = 5;
		add(jcbCcaa, gbc_jcbCcaa);
		
		JButton jbtVerCCAA = new JButton("Ver Comunidad");
		jbtVerCCAA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarPanelProvinciasEnJDialog();
			}
		});
		jbtVerCCAA.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_jbtVerCCAA = new GridBagConstraints();
		gbc_jbtVerCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jbtVerCCAA.gridx = 2;
		gbc_jbtVerCCAA.gridy = 5;
		add(jbtVerCCAA, gbc_jbtVerCCAA);
		
		JButton jbtGuardar = new JButton("Guardar");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, 
							"No se ha realizado la actualización");
					ex.printStackTrace();
				}
			}
		});
		jbtGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.gridwidth = 3;
		gbc_jbtGuardar.insets = new Insets(10, 0, 0, 0);
		gbc_jbtGuardar.gridx = 0;
		gbc_jbtGuardar.gridy = 7;
		add(jbtGuardar, gbc_jbtGuardar);

		
		
		cargaTodasCCAA();
	}

	
	
	
	
	/**
	 * 
	 */
	public void mostrarPanelProvinciasEnJDialog () {
		JDialog dialogo = new JDialog();
		dialogo.setResizable(true);
		dialogo.setTitle("Gestión de la CCAA");
		dialogo.setContentPane(new PanelCCAA(this, panelTablita));
		dialogo.pack();
		dialogo.setModal(true);
		dialogo.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		dialogo.setVisible(true);
	}

	
	
	public void muestraProvincia(Provincia ps) {
		
		if(ps != null)
			
			this.jtfLabel.setText("" + ps.getLabel());
			this.jtfCode.setText(ps.getCode());
		
			for (int i = 0; i < this.jcbCcaa.getItemCount(); i++) {
				if (((ComunidadAutonoma) this.jcbCcaa.getItemAt(i)).getCode() 
						.equals(ps.getParentCode())) {
					this.jcbCcaa.setSelectedIndex(i);
				}
			}
	}
		

		
	
	
	/**
	 * 
	 */
	public void cargaTodasCCAA() {
		
		this.jcbCcaa.removeAllItems();
		
		List<ComunidadAutonoma> ccaas = (List<ComunidadAutonoma>) ControladorComunidadMongo
				.getInstance().getAllCcaa();
		for (ComunidadAutonoma ca : ccaas) {
			this.jcbCcaa.addItem(ca);
		}
	}
	
	
	
	/**
	 * Guardamos los datos del panelProvincia.
	 */
	public void guardar() {
		Provincia pr = new Provincia();
		
		// GUARDAMOS LOS DATOS QUE HAY EN EL PANEL PROVINCIA
		// EN UN OBJETO PROVINCIA
		
		pr.setCode(this.jtfCode.getText());
		
		if (!this.jtfLabel.getText().isEmpty()) {
			pr.setLabel(this.jtfLabel.getText());
		}else {
			JOptionPane.showMessageDialog(null,
					"El nombre no puede estar vacío");;
			return;
		}
		
		pr.setParentCode(((ComunidadAutonoma)this.jcbCcaa.getSelectedItem()).getCode());
		
		
		// GUARDAMOS EL DOCUMENTO (U OBJETO) EN LA COLECCIÓN
		ControladorProvinciasMongo.getInstance()
			.updateProvincia(pr);
		
		
		// Actualizo la tabla para mostrar los nuevos datos.
		this.panelTablita.updateTable();  
	
		
		
		JOptionPane.showMessageDialog(null, 
				"Se ha actualizado la provincia con éxito");
	}
	
	
	public void updateCCAAdelJCombo() {
		ComunidadAutonoma ca = (ComunidadAutonoma) jcbCcaa.getSelectedItem();
		
		cargaTodasCCAA(); // Actualizamos el JComboBox
		
		// Buscamos la comunidad autónoma correspondiente en el nuevo JComboBox y la seleccionamos
	    for (int i = 0; i < jcbCcaa.getItemCount(); i++) {
	        if (((ComunidadAutonoma) jcbCcaa.getItemAt(i)).getCode().equals(ca.getCode())) {
	            jcbCcaa.setSelectedIndex(i);
	            break; // Una vez encontrada y seleccionada, salimos del bucle
	        }
	    }
	    
	}
	
	
	
	
	
	
/// creo getters y setters del jtfCode para poder usarlo en el JDialog.
	public JTextField getJtfCode() {
		return jtfCode;
	}

	public void setJtfCode(JTextField jtfCode) {
		this.jtfCode = jtfCode;
	}
	

}
