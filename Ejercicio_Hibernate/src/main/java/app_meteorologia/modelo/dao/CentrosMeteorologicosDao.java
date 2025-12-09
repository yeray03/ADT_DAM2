package app_meteorologia.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app_meteorologia.modelo.entities.CentrosMeteorologicos;
import app_meteorologia.modelo.util.HibernateUtil;

public class CentrosMeteorologicosDao {
    public static List<CentrosMeteorologicos> getAllCentrosWhereMunicipio(String nombreMunicipio) {
        // Método para obtener todos los centros meteorológicos desde la base de datos
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            List<CentrosMeteorologicos> ret = session.createQuery(
                "FROM CentrosMeteorologicos c WHERE c.municipios.nombre = :nombreMunicipio", 
                CentrosMeteorologicos.class)
                .setParameter("nombreMunicipio", nombreMunicipio)
                .list();
            transaction.commit();
            session.close();
            return ret;
            
            } catch (Exception e) {
            System.out.println("Error al obtener todos los centros meteorológicos: " + e.getMessage());
            return null;
        }
    }
}
