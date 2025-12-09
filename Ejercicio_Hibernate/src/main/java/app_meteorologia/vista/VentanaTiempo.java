package app_meteorologia.vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import app_meteorologia.modelo.dao.CentrosMeteorologicosDao;
import app_meteorologia.modelo.dao.MunicipiosDao;
import app_meteorologia.modelo.dao.ProvinciasDao;
import app_meteorologia.modelo.entities.CentrosMeteorologicos;
import app_meteorologia.modelo.entities.Municipios;
import app_meteorologia.modelo.entities.Provincias;
import app_meteorologia.modelo.util.HibernateUtil;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

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

		// Inicializar Hibernate
		HibernateUtil.getSessionFactory();

		// Crear el JComboBox para las provincias
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(157, 234, 407, 38);
		getContentPane().add(comboBox);

		// Crear el botón de selección
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.setBounds(317, 321, 116, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
		// Cargar las provincias desde la base de datos
		List<Provincias> listaProvincias = ProvinciasDao.getAllProvincias();

		// Agregar las provincias al JComboBox
		for (Provincias provincia : listaProvincias) {
			comboBox.addItem(provincia.getNombre());
		}

		// Crear el modelo de datos para la lista
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		// Crear los JList y los JScrollPane correspondientes
		JList<String> listaMunicipios = new JList<>(listModel);
		JList<String> listaCentroMet = new JList<>(listModel);
		JList<String> listaEspNat = new JList<>(listModel);
		// Crear el JScrollPane para poder hacer scroll en la lista
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 60, 277, 250);
		scrollPane.setViewportView(listaMunicipios);
		scrollPane.setVisible(false);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(467, 60, 307, 250);
		scrollPane2.setViewportView(listaEspNat);
		scrollPane2.setVisible(false);
		getContentPane().add(scrollPane2);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(2, 60, 307, 250);
		scrollPane3.setViewportView(listaCentroMet);
		scrollPane3.setVisible(false);
		getContentPane().add(scrollPane3);
		
		// Obtener el municipio seleccionado
		String municipioSeleccionado = listaMunicipios.getSelectedValue();
		btnNewButton.addActionListener(e -> {
			
			if (comboBox.isVisible() == true) {
				// Obtener la provincia seleccionada
				String provinciaSeleccionada = (String) comboBox.getSelectedItem();

				// Cargar los municipios correspondientes a la provincia seleccionada
				List<Municipios> listaMunicipiosBD = MunicipiosDao
						.getAllMunicipiosWhereProvincia(provinciaSeleccionada);
				// Limpiar el modelo de la lista antes de agregar nuevos elementos
				listModel.clear();
				// Agregar los municipios al modelo de la lista
				for (Municipios municipio : listaMunicipiosBD) {
					listModel.addElement(municipio.getNombre());
				}
				// Mostrar la lista de municipios y ocultar el comboBox
				scrollPane.setVisible(true);
				comboBox.setEnabled(false);
				comboBox.setVisible(false);

			} else if (scrollPane.isVisible() == true) {
				comboBox.setVisible(false);
				List<CentrosMeteorologicos> listaCentros = CentrosMeteorologicosDao
						.getAllCentrosWhereMunicipio(municipioSeleccionado);
				// Limpiar el modelo de la lista antes de agregar nuevos elementos
				listModel.clear();
				// Agregar los centros meteorológicos al modelo de la lista
				for (CentrosMeteorologicos centro : listaCentros) {
					listModel.addElement(centro.getNombre());
				}

				// Ocultar la lista de municipios y mostrar el comboBox
				scrollPane.setVisible(false);
				scrollPane2.setVisible(true);
				scrollPane3.setVisible(true);

			}

		});
	}
}
