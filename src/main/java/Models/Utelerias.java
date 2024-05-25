package Models;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 *
 * @author Jhonatan
 */
public class Utelerias {

    //instancia de la clase Conexion
    Conexion conexion = Conexion.getInstancia();

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

    //metodo para rellenar el combo box
    public void rellenarCombo(String tabla, String valor, JComboBox cbxArea) {
        String sql = "SELECT nombre FROM " + tabla;
        Connection conectar = conexion.conectarBD();
        Statement st;

        try {
            st = conectar.createStatement();
            ResultSet consulta = st.executeQuery(sql);

            //mientras la tabla tenga datos
            while (consulta.next()) {
                cbxArea.addItem(consulta.getString(valor));
            }
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al llenar combo box: " + e.toString());
        }
    }

    //metodos para validar que los campos no esten vacios
    public static String validarCamposFormularioRegistrarUsuario(JTextField txtNombre, JTextField txtAppPaterno, JTextField txtappMaterno,
            JTextField txtSueldoBase, JTextField txtNumHijos, ButtonGroup botones) {

        if (txtNombre.getText().trim().isEmpty() || txtAppPaterno.getText().trim().isEmpty() || txtappMaterno.getText().trim().isEmpty()
                || txtSueldoBase.getText().trim().isEmpty() || txtNumHijos.getText().trim().isEmpty()) {
            return "Todos los campos";
        }

        if (txtNombre.getText().trim().isEmpty()) {
            return "Nombre";
        }

        if (txtAppPaterno.getText().trim().isEmpty()) {
            return "Apellido Paterno";
        }

        if (txtappMaterno.getText().trim().isEmpty()) {
            return "Apellido Materno";
        }

        if ((txtSueldoBase.getText().trim().isEmpty()) || (Double.parseDouble(txtSueldoBase.getText()) < 0)) {
            return "Sueldo Base";
        }

        if (botones.getSelection() == null) {
            return "Sexo";
        }
        return "";
    }
}
