package Interfaces;

import Models.Usuario;

/**
 *
 * @author Jhonatan
 */
public interface UsuarioDao {

    public void registrarUsuario(Usuario usuario);

    public boolean comprobarUsuriosRepetidos(Usuario usuario);

    public boolean iniciarSesion(Usuario usuario);
}
