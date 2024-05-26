package Models;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        if (txtNombre.getText().trim().isEmpty() && txtAppPaterno.getText().trim().isEmpty() && txtappMaterno.getText().trim().isEmpty()
                && txtSueldoBase.getText().trim().isEmpty() && txtNumHijos.getText().trim().isEmpty()) {
            return "Todos los campos";
        }

        if (txtNombre.getText().trim().isEmpty()) {
            txtNombre.requestFocus();
            return " Campo Nombre";
        }

        if (txtAppPaterno.getText().trim().isEmpty()) {
            txtAppPaterno.requestFocus();
            return "Campo Apellido Paterno";
        }

        if (txtappMaterno.getText().trim().isEmpty()) {
            txtappMaterno.requestFocus();
            return "Campo Apellido Materno";
        }

        if ((txtSueldoBase.getText().trim().isEmpty()) || (Double.parseDouble(txtSueldoBase.getText()) <= 0)) {
            txtSueldoBase.requestFocus();
            return "Campon Sueldo Base";
        }

        if (botones.getSelection() == null) {
            return "Campo Sexo";
        }
        return "";
    }

    //METODO PARA VER LOS REGISTROS EN UN JTABLE
    public void cargarTable(DefaultTableModel modelo, JTable tblDatos, int indice) {

        String sql = "SELECT empleados.id, empleados.nombre, empleados.appPaterno, empleados.appMaterno,TRUNCATE( empleados.sueldoBase,2), area.nombre, empleados.estadoCivil, TRUNCATE(empleados.sueldoTotal,2) FROM empleados INNER JOIN area ON area.id = empleados.idArea";
        String sqlTotal = "SELECT empleados.id, empleados.nombre, empleados.appPaterno, empleados.appMaterno,TRUNCATE( empleados.sueldoBase,2), area.nombre, empleados.sexo, empleados.estadoCivil,empleados.numHijos, TRUNCATE(empleados.bonoArea,2), TRUNCATE((empleados.montoDescuento + empleados.montoImpuesto),2), TRUNCATE(empleados.sueldoTotal,2) FROM empleados INNER JOIN area ON area.id = empleados.idArea";

        String sql3 = "SELECT COUNT(empleados.idArea), area.nombre from empleados inner join area on area.id = empleados.idArea GROUP by (area.nombre)";
        String sqlSexo = "SELECT COUNT(sexo), sexo FROM empleados GROUP BY (sexo)";
        PreparedStatement consultaPreparada = null;

        try {
            Connection conectar = conexion.conectarBD();
            if (indice == 0) {
                consultaPreparada = conectar.prepareStatement(sql);
            } else if (indice == 1) {
                consultaPreparada = conectar.prepareStatement(sqlTotal);
            } else if (indice == 2) {
                consultaPreparada = conectar.prepareStatement(sql3);
            } else {
                consultaPreparada = conectar.prepareStatement(sqlSexo);
            }
            ResultSet resultado = consultaPreparada.executeQuery();

            //obtenemos los datos de la tabla en la base de datos
            ResultSetMetaData datos = resultado.getMetaData();
            int cantColumnas = datos.getColumnCount();

            //cargamos los datos 
            while (resultado.next()) {
                Object arreglo[] = new Object[cantColumnas];
                for (int i = 0; i < cantColumnas; i++) {
                    arreglo[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }

            tblDatos.setModel(modelo);
            conexion.desconectaBD();
        } catch (SQLException e) {
            System.out.println("Error al mostrar tabla: " + e.toString());
        }
    }

    //METODO PARA LIMPIAR LOS CAMPOS EN EL FORMULARIO DE  REGOSTRO DE PERSONAS
    public static void limpiarCamposFormularioRegistrarUsuario(JTextField txtNombre, JTextField txtAppPaterno, JTextField txtappMaterno,
            JTextField txtSueldoBase, JTextField txtNumHijos, JComboBox cbxArea, JComboBox cbxEstadoCivil) {
        String nulo = "";
        txtNombre.setText(nulo);
        txtAppPaterno.setText(nulo);
        txtNumHijos.setText(nulo);
        txtSueldoBase.setText(nulo);
        txtappMaterno.setText(nulo);
        cbxArea.setSelectedIndex(0);
        cbxEstadoCivil.setSelectedIndex(0);
        //para el cursor
        txtNombre.requestFocus();
    }
}
