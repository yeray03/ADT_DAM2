package app_meteorologia.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app_meteorologia.modelo.entities.EspaciosNaturales;
import app_meteorologia.modelo.entities.Municipios;
import app_meteorologia.modelo.util.HibernateUtil;

public class EspaciosNaturalesDao {
    public static List<EspaciosNaturales> getAllEspaciosWhereMunicipio(String nombreMunicipio) {
        // Método para obtener todos los municipios desde la base de datosº
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            List<EspaciosNaturales> ret = session.createQuery("SELECT DISTINCT e FROM EspaciosNaturales e " +
                    "JOIN e.municipiosEspaciosNats men " +
                    "JOIN men.municipios m " +
                    "WHERE m.nombre = :nombreMunicipio",
                    EspaciosNaturales.class)
                    .setParameter("nombreMunicipio", nombreMunicipio)
                    .list();
            transaction.commit();
            session.close();
            return ret;

        } catch (Exception e) {
            System.out.println("Error al obtener todos los espacios naturales: " + e.getMessage());
            return null;
        }
    }
}
