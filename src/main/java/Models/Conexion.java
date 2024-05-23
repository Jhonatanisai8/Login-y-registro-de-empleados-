package Models;

import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class Conexion {

    private Conexion() {

    }

    private static Connection conexion;
    private static Conexion intancia;

    private static final String URL = "jdbc:mysql://localhost:3307/registro_empleado";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public Connection conectarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conectado");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error el conectar: " + e.toString());
        }
        return conexion;
    }

    public void desconectaBD() throws SQLException {
        try {
            conexion.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.toString());
            conexion.close();
        } finally {
            conexion.close();
        }
    }

    //patron singleton
    public static Conexion getInstancia() {
        if (intancia == null) {
            intancia = new Conexion();
        }
        return intancia;
    }

}
