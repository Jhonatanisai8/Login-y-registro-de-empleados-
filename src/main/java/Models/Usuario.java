package Models;

/**
 *
 * @author Jhonatan
 */
public class Usuario {

    private int id;
    private String nombreUsuario;
    private String contrasenia;

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contraseña) {
        this.contrasenia = contraseña;
    }

}
