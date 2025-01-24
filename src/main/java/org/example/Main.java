package org.example;

import DAO.EmpleadoDAO;
import DAO.EmpleadoDAOImpl;
import entities.Empleado;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        Empleado empleado1 = new Empleado();
        empleado1.setId(1L);
        empleado1.setNombre("Nicolás");
        empleado1.setEmail("Niko@mail");
        empleado1.setDepartamento("Desarrollo");

        empleadoDAO.crearEmpleado(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setId(2L);
        empleado2.setNombre("Iván");
        empleado2.setEmail("ivan@mail");
        empleado2.setDepartamento("Desarrollo");

        empleadoDAO.crearEmpleado(empleado2);

        Empleado empleado3 = new Empleado();
        empleado3.setId(3L);
        empleado3.setNombre("Andrea");
        empleado3.setEmail("Andrea@mail");
        empleado3.setDepartamento("Desarrollo");

        empleadoDAO.crearEmpleado(empleado3);

        List<Empleado> empleados = empleadoDAO.list();
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + " - " + empleado.getEmail());
        }
    }
}