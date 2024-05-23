package Models;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jhonatan
 */
public class Utelerias {

    //validacion de campos
    public static String validarCampos(JTextField txtUsuario, JPasswordField txtContrasenia) {
        if (txtUsuario.getText().trim().isEmpty() || txtUsuario.getText().trim().equals("Ingrese su nombre de usuario")) {
            return "Usuario";
        }
        
        if (String.valueOf(txtContrasenia.getPassword()).isEmpty() || String.valueOf(txtContrasenia.getPassword()).equals("**********")) {
            return "Contraseña";
        }
        return "";
    }
}
