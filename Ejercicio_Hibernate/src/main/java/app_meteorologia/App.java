package app_meteorologia;

import java.awt.EventQueue;

import app_meteorologia.vista.VentanaTiempo;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaTiempo().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
