package DaoImplementacion;

import Interfaces.UsuarioDao;
import Models.Conexion;
import Models.Usuario;
import java.sql.*;

/**
 *
 * @author Jhonatan
 */
//hacemos referencia que va a impletar los metodos del interfas UsuarioDao
public class UserDaoImple implements UsuarioDao {

    //llamos a la clase conexion y al metodo de obtener instancia
    Conexion conexion = Conexion.getInstancia();

    @Override
    public void registrarUsuario(Usuario usuario) {
        try {
            Connection conectar = conexion.conectarBD();
            //nuestra consulta sql
            String sql = "INSERT INTO usuarios VALUES (?,?,?)";
            PreparedStatement insertar = conectar.prepareStatement(sql);
            insertar.setInt(1, 0);
            insertar.setString(2, usuario.getNombreUsuario());
            insertar.setString(3, usuario.getContraseña());
            insertar.executeUpdate();
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.toString());
        }
    }

    @Override
    public boolean comprobarUsuriosRepetidos(Usuario usuario) {
        return true;
    }

    @Override
    public boolean iniciarSesion(String user, String pass) {
        try {
            Connection conectar = conexion.conectarBD();
            String sql = "SELECT  * FROM usuarios WHERE usuario = '" + user + "' and pasword = '" + pass + "'";
            PreparedStatement buscar = conectar.prepareStatement(sql);

            ResultSet consulta = buscar.executeQuery();
            if (consulta.next()) {
                return true;
            }
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al iniciar Sesion: " + e.toString());
        }
        return false;
    }

}
