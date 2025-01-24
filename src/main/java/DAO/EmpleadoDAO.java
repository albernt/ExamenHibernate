package DAO;

import entities.Empleado;

import java.util.List;

public interface EmpleadoDAO {

    void crearEmpleado(Empleado empleado);

    List<Empleado> list();






}
