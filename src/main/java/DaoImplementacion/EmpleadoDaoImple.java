package DaoImplementacion;

import Interfaces.EmpleadoDao;
import Models.Conexion;
import Models.Empleado;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class EmpleadoDaoImple implements EmpleadoDao {

    //llamos a la clase conexion y al metodo de obtener instancia
    Conexion conexion = Conexion.getInstancia();
    
    @Override
    public List<Empleado> listarEmpleados() {
        //list de empleado
        List<Empleado> empleados = new ArrayList<>();
        //objeto de la clase empleado
        Empleado empleado;
        //atributos del empleado
        int id;
        String nombre;
        String appPaterno;
        String appMaterno;
        double sueldoBase;
        String area;
        String sexo;
        String estadoCivil;
        int numHijos;
        
        try {
            Connection conectar = conexion.conectarBD();
            String sql = "";
            PreparedStatement consultaPreparada = conectar.prepareStatement(sql);
            ResultSet resultado = consultaPreparada.executeQuery();
            
            while (resultado.next()) {
                id = resultado.getInt("id");
                nombre = resultado.getString("nombre");
                appPaterno = resultado.getString("appPaterno");
                appMaterno = resultado.getString("appMaterno");
                sueldoBase = resultado.getDouble("sueldoBase");
                area = resultado.getString("idArea");
                sexo = resultado.getString("sexo");
                estadoCivil = resultado.getString("estadoCivil");
                numHijos = resultado.getInt("numHijos");
            }
            conexion.desconectaBD();
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.toString());
        }
        return empleados;
    }
    
    @Override
    public int insertarEmpleado(Empleado empleado) {
        int registros = 0;
        try {
            Connection conectar = conexion.conectarBD();
            String sql = "INSERT INTO empleados (nombre,appPaterno,appMaterno,sueldoBase,idArea,sexo,estadoCivil,numHijos, bonoArea,montoDescuento,montoImpuesto,sueldoTotal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consultaPreparada = conectar.prepareStatement(sql);
            
            consultaPreparada.setString(1, empleado.getNombre());
            consultaPreparada.setString(2, empleado.getAppPaterno());
            consultaPreparada.setString(3, empleado.getAppMaterno());
            consultaPreparada.setDouble(4, empleado.getSueldoBase());
            
            switch (empleado.getArea()) {
                case "Desarrollo de Software":
                    consultaPreparada.setInt(5, 1);
                    break;
                case "Gestión de Proyectos":
                    consultaPreparada.setInt(5, 2);
                    break;
                case "Análisis y Diseño":
                    consultaPreparada.setInt(5, 3);
                    break;
                case "Soporte y Mantenimiento":
                    consultaPreparada.setInt(5, 4);
                    break;
                case "Infraestructura y Operaciones":
                    consultaPreparada.setInt(5, 5);
                    break;
                case "Innovación y Desarrollo de Nuevas Tecnologías":
                    consultaPreparada.setInt(5, 6);
                    break;
                case "ventas y Marketing":
                    consultaPreparada.setInt(5, 7);
                    break;
            }
            
            consultaPreparada.setString(6, empleado.getSexo());
            consultaPreparada.setString(7, empleado.getEstadoCivil());
            consultaPreparada.setInt(8, empleado.getNumHijos());
            consultaPreparada.setDouble(9, empleado.bonoArea());
            consultaPreparada.setDouble(10, empleado.montoSeguro());
            consultaPreparada.setDouble(11, empleado.montoImpuesto());
            consultaPreparada.setDouble(12, empleado.montoSueldoTotal());
            
            registros = consultaPreparada.executeUpdate();
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al insertar Empleado: " + e.toString());
        }
        return registros;
    }
    
    @Override
    public int modificarDatosEmpleado(Empleado empleado) {
        return 0;
    }
    
    @Override
    public int eliminarEmpleado(Empleado empleado) {
        return 0;
    }
    
}
