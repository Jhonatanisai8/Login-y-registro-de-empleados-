package Models;

import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class Conexion {

    private static Connection conexion;
    private static Conexion intancia;

    private static final String URL = "jdbc:mysql://localhost:3307/bd_login";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

}
