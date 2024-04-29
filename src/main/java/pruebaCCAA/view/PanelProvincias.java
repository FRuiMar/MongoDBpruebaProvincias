package pruebaCCAA.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class PanelProvincias extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCode;
	private JTextField jtfLabel;

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
		
		JLabel lblNewLabel = new JLabel("Code: ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfCode = new JTextField();
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 3;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Label: ");
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
		
		JLabel lblNewLabel_2 = new JLabel("CCAA: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox jcbCCAA = new JComboBox();
		GridBagConstraints gbc_jcbCCAA = new GridBagConstraints();
		gbc_jcbCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCCAA.gridx = 1;
		gbc_jcbCCAA.gridy = 5;
		add(jcbCCAA, gbc_jcbCCAA);
		
		JButton jbtVerCCAA = new JButton("Ver Comunidad");
		jbtVerCCAA.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_jbtVerCCAA = new GridBagConstraints();
		gbc_jbtVerCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jbtVerCCAA.gridx = 2;
		gbc_jbtVerCCAA.gridy = 5;
		add(jbtVerCCAA, gbc_jbtVerCCAA);
		
		JButton jbtGuardar = new JButton("Guardar");
		jbtGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.gridwidth = 3;
		gbc_jbtGuardar.insets = new Insets(10, 0, 0, 0);
		gbc_jbtGuardar.gridx = 0;
		gbc_jbtGuardar.gridy = 7;
		add(jbtGuardar, gbc_jbtGuardar);

	}

}
