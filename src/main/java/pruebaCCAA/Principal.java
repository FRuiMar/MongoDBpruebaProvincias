package pruebaCCAA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import pruebaCCAA.view.PanelProvincias;
import pruebaCCAA.view.PanelTabla;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelProvincias panelProvincia = new PanelProvincias();
	private PanelTabla panelTabla = new PanelTabla(panelProvincia);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(300); //para controlar la posición de la división de la pantalla
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		
		splitPane.setLeftComponent(this.panelTabla);
		
		
		splitPane.setRightComponent(this.panelProvincia);
		
		panelProvincia.setPanelTabla(panelTabla);
	}
	
}
