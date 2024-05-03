package pruebaCCAA.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import pruebaCCAA.controllers.ControladorComunidadMongo;
import pruebaCCAA.controllers.ControladorProvinciasMongo;
import pruebaCCAA.entities.ComunidadAutonoma;
import pruebaCCAA.entities.Provincia;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelCCAA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCodeCCAA;
	private JTextField jtfLabelCCAA;


	ComunidadAutonoma ccaa;
	
	//se declaran para poder pasarlos en la construcción del panelCCAA
	PanelProvincias panelProvin;
	PanelTabla panelTab;

	
	
	/**
	 * Create the panel. Pasandole el panelProvincias como puntero y el PanelTabla
	 * así puedo trabajar con referencias a ellos.
	 */
	public PanelCCAA(PanelProvincias panelProvin, PanelTabla panelTab) {
		
		this.panelProvin = panelProvin;
		this.panelTab = panelTab;
		
		// Guardamos el Objeto CCAA seleccionado.
		this.ccaa = (ComunidadAutonoma) this.panelProvin.jcbCcaa.getSelectedItem();
		
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeCcaa = new JLabel("Gestión de Comunidades Autónomas");
		lblGestinDeCcaa.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblGestinDeCcaa = new GridBagConstraints();
		gbc_lblGestinDeCcaa.gridwidth = 2;
		gbc_lblGestinDeCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeCcaa.gridx = 0;
		gbc_lblGestinDeCcaa.gridy = 1;
		add(lblGestinDeCcaa, gbc_lblGestinDeCcaa);
		
		JLabel lblNewLabel = new JLabel("Code CCAA: ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfCodeCCAA = new JTextField();
		GridBagConstraints gbc_jtfCodeCCAA = new GridBagConstraints();
		gbc_jtfCodeCCAA.insets = new Insets(0, 0, 5, 10);
		gbc_jtfCodeCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodeCCAA.gridx = 1;
		gbc_jtfCodeCCAA.gridy = 3;
		add(jtfCodeCCAA, gbc_jtfCodeCCAA);
		jtfCodeCCAA.setColumns(10);
		
		JLabel lblLabel = new JLabel("Nombre: ");
		lblLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.EAST;
		gbc_lblLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 4;
		add(lblLabel, gbc_lblLabel);
		
		jtfLabelCCAA = new JTextField();
		GridBagConstraints gbc_jtfLabelCCAA = new GridBagConstraints();
		gbc_jtfLabelCCAA.insets = new Insets(0, 0, 5, 10);
		gbc_jtfLabelCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabelCCAA.gridx = 1;
		gbc_jtfLabelCCAA.gridy = 4;
		add(jtfLabelCCAA, gbc_jtfLabelCCAA);
		jtfLabelCCAA.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCCAA();
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);
		
		muestraCCAA();

	}

	
	
	/**
	 * Sacamos en el panel CCAA los datos del Code y el nombre de la CCAA.
	 */
	private void muestraCCAA() {
		
		this.jtfCodeCCAA.setText(ccaa.getCode());
		
		if (!ccaa.getLabel().isEmpty()) {
			this.jtfLabelCCAA.setText(ccaa.getLabel());
		} else {
			this.jtfLabelCCAA.setText("");
		}
		
	}
	
	
	
	
	/**
	 * Guardamos los datos de la CCAA del jDialog.
	 */
	private void guardarCCAA() {
		
		ComunidadAutonoma ca = new ComunidadAutonoma();
		
		ca.setCode(this.jtfCodeCCAA.getText());
		
		if (!this.jtfLabelCCAA.getText().isEmpty()) {
			ca.setLabel(this.jtfLabelCCAA.getText());
		} else {
			JOptionPane.showMessageDialog(null,
					"La descripción no puede estar vacía");;
			return;
		}

		//Tenemos que guardar el parentcode, que siempre es el mismo en principio.
		// Si tuvieramos por ejemplo paises, el parent code pertenecería al pais
		// De momento no se va a modificar.
		ca.setParentCode(ccaa.getParentCode());
		
		//actualizamos la comunidad(documento) en la colección.
		ControladorComunidadMongo.getInstance().updateComunidad(ca);
		
		this.panelProvin.updateCCAAdelJCombo();
		
		updatePanelPrincipal();
		
		JOptionPane.showMessageDialog(null, "Update realizado correctamente");
		
		// si quiero que el jdialog se cierre despues de que se haga el guardado de forma correcta
		Window window = SwingUtilities.windowForComponent(this);
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            dialog.dispose();
        }
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private void updatePanelPrincipal() {
		

		//Actualizo la tabla
		this.panelTab.updateTable();

		
		
		List<Provincia> provincias = ControladorProvinciasMongo
				.getInstance().getAllProvincias();

		//saco el codigo de la provincia que hay en el panelProvincia
		String code = this.panelProvin.getJtfCode().getText();

		
		for (Provincia provincia : provincias) {
			if (provincia.getCode().equalsIgnoreCase(code)) {
				this.panelTab.selectRowByCode(provincia);
			}
		}
		
		
	}
	
	
}
