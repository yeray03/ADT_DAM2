package app_meteorologia.modelo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app_meteorologia.modelo.entities.Provincias;
import app_meteorologia.modelo.util.HibernateUtil;

public class ProvinciasDao {

    public static Provincias getProvinciaPorId(int id) {
        // Lógica para obtener una provincia por su ID
        Provincias ret = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            ret = session.get(Provincias.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Error al obtener la provincia por ID: " + e.getMessage());
        }
        return ret;
    }

    public static List<Provincias> getAllProvincias() {
        // Lógica para obtener todas las provincias
        List<Provincias> ret = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            ret = session.createQuery("FROM Provincias", Provincias.class).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Error al obtener todas las provincias: " + e.getMessage());
        }
        return ret;
    }
}
