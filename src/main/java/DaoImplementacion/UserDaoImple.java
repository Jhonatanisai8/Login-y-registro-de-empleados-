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
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.toString());
        }
    }
    
    @Override
    public boolean comprobarUsuriosRepetidos(Usuario usuario) {
        
    }
    
    @Override
    public boolean iniciarSesion(Usuario usuario) {
        
    }
    
}
