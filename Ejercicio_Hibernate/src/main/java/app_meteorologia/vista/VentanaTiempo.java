package app_meteorologia.vista;

import javax.swing.JFrame;

import app_meteorologia.modelo.util.HibernateUtil;

public class VentanaTiempo extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaTiempo() {
		inicializar ();
	}

	private void inicializar() {
		// Configuración de la ventana
		setTitle("Aplicación de Meteorología");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Centrar la ventana en la pantalla
		setVisible(true);
		HibernateUtil.getSessionFactory(); // Inicializar Hibernate
	}
}
