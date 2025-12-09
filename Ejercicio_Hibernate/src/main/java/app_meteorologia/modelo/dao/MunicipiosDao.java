package app_meteorologia.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app_meteorologia.modelo.entities.Municipios;
import app_meteorologia.modelo.util.HibernateUtil;

public class MunicipiosDao {

    public static List<Municipios> getAllMunicipiosWhereProvincia(String nombreProvincia) {
        // Método para obtener todos los municipios desde la base de datos
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            List<Municipios> ret = session.createQuery(
                "FROM Municipios m WHERE m.provincias.nombre = :nombreProvincia", 
                Municipios.class)
                .setParameter("nombreProvincia", nombreProvincia)
                .list();
            transaction.commit();
            session.close();
            return ret;
            
            } catch (Exception e) {
            System.out.println("Error al obtener todos los municipios: " + e.getMessage());
            return null;
        }
    }
}
