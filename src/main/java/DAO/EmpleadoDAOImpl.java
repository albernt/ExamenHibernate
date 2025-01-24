package DAO;

import Util.HibernateUtil;
import entities.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public void crearEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al guardar el empleado: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public List<Empleado> list() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Empleado", Empleado.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar los empleados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}