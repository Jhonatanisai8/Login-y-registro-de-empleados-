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
        if ((txtUsuario.getText().trim().isEmpty() || txtUsuario.getText().trim().equals("Ingrese su nombre de usuario"))
                && (String.valueOf(txtContrasenia.getPassword()).isEmpty() || String.valueOf(txtContrasenia.getPassword()).equals("**********"))) {
            return "Ambos campos";
        }
        if (txtUsuario.getText().trim().isEmpty() || txtUsuario.getText().trim().equals("Ingrese su nombre de usuario")) {
            return " Campo Usuario";
        } else if (String.valueOf(txtContrasenia.getPassword()).isEmpty() || String.valueOf(txtContrasenia.getPassword()).equals("**********")) {
            return "Campo Contraseña";
        }
        return "";
    }
}
