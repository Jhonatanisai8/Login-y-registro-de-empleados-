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
        if (txtUsuario.getText().trim().isEmpty()) {
            return "Usuario";
        }

        if (String.valueOf(txtContrasenia.getText()).isEmpty()) {
            return "Contraseña";
        }
        return "";
    }
}
