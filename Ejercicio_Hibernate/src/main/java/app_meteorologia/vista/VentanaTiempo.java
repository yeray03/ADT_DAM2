package app_meteorologia.vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import app_meteorologia.modelo.dao.ProvinciasDao;
import app_meteorologia.modelo.entities.Provincias;
import app_meteorologia.modelo.util.HibernateUtil;

import java.util.List;

import javax.swing.JButton;

public class VentanaTiempo extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaTiempo() {
		inicializar();
	}

	private void inicializar() {
		// Configuración de la ventana
		setTitle("Aplicación de Meteorología");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Centrar la ventana en la pantalla
		getContentPane().setLayout(null);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(157, 234, 407, 38);
		getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(317, 321, 116, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
		HibernateUtil.getSessionFactory();

		List<Provincias> listaProvincias = ProvinciasDao.getAllProvincias();

		for (Provincias provincia : listaProvincias) {
			comboBox.addItem(provincia.getNombre());
		}
	}
}
