package pruebaCCAA.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import pruebaCCAA.entities.ComunidadAutonoma;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCCAA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox<ComunidadAutonoma> jcbCcaa;
	ComunidadAutonoma ccaa;

	/**
	 * Create the panel.
	 */
	public PanelCCAA(ComunidadAutonoma ccaa, JComboBox<ComunidadAutonoma> jcbCcaa) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeCcaa = new JLabel("Gestión de CCAA");
		lblGestinDeCcaa.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblGestinDeCcaa = new GridBagConstraints();
		gbc_lblGestinDeCcaa.gridwidth = 2;
		gbc_lblGestinDeCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeCcaa.gridx = 0;
		gbc_lblGestinDeCcaa.gridy = 1;
		add(lblGestinDeCcaa, gbc_lblGestinDeCcaa);
		
		JLabel lblNewLabel = new JLabel("Code: ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblLabel = new JLabel("Label: ");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.EAST;
		gbc_lblLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 4;
		add(lblLabel, gbc_lblLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 10);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);

	}

}
