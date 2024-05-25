package Interfaces;

import Models.Empleado;
import java.util.List;

/**
 *
 * @author Jhonatan
 */
public interface EmpleadoDao {

    public List<Empleado> listarEmpleados();

    public int insertarEmpleado(Empleado empleado);

    public int modificarDatosEmpleado(Empleado empleado);

    public int eliminarEmpleado(Empleado empleado);
}
