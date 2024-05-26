package Vistas;

import DaoImplementacion.EmpleadoDaoImple;
import Models.Empleado;
import Models.Utelerias;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonatan
 */
public class RegistroUsuario extends javax.swing.JPanel {

    Utelerias utelerias = new Utelerias();

    //objetos de la clase empleadoDao y empleadoDaoImple
    EmpleadoDaoImple empleadoDaoImple = new EmpleadoDaoImple();

    //variables para poder modicar un usuario
    boolean isEdition = false;
    Empleado empleadoEditado;

    public RegistroUsuario() {
        initComponents();
        this.estilosCampos();
        //llamamos al metodo en el contructor de este formulario
        utelerias.rellenarCombo("area", "nombre", cbxArea);
        activarCamposHijos("Casado");
        botones.add(bMujer);
        botones.add(bHombre);
    }

    //constructor para poder modificar los datos de un usuario
    public RegistroUsuario(Empleado empleado1) {
        initComponents();
        isEdition = true;
        empleadoEditado = empleado1;
        estilosCampos();
        //llamamos al metodo en el contructor de este formulario
        utelerias.rellenarCombo("area", "nombre", cbxArea);
        activarCamposHijos("Casado");
        botones.add(bMujer);
        botones.add(bHombre);
    }

    private void estilosCampos() {
        txtNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre");
        txtApellidoMaterno.putClientProperty("JTextField.placeholderText", "Ingrese el Apellido Materno");
        txtApellidoPaterno.putClientProperty("JTextField.placeholderText", "Ingrese el Apellido Paterno");
        txtSueldoBase.putClientProperty("JTextField.placeholderText", "Ingrese el sueldo base");
        txtNumHijos.putClientProperty("JTextField.placeholderText", "Cant. Hijos");

        //comenzamos
        if (isEdition) {
            lblTitulo.setText("Información del empleado");
            btnRegistrar.setText("Guardar");
            if (empleadoEditado != null) {
                txtNombre.setText(empleadoEditado.getNombre());
                txtApellidoPaterno.setText(empleadoEditado.getAppPaterno());
                txtApellidoMaterno.setText(empleadoEditado.getAppMaterno());
                txtSueldoBase.setText(empleadoEditado.getSueldoBase() + "");
                cbxArea.setSelectedItem(empleadoEditado.getArea());
                //para el sexo del empleado
                if (empleadoEditado.getSexo().equalsIgnoreCase("Masculino")) {
                    bHombre.setSelected(true);
                } else {
                    bMujer.setSelected(true);
                }
                cbxEstadoCivil.setSelectedItem(empleadoEditado.getEstadoCivil());
                txtNumHijos.setText(empleadoEditado.getNumHijos() + "");
            }
        }
    }

    public void registrarEmpleado() {
        //metodo para insertar
        Empleado empleado;
        String campos = Utelerias.validarCamposFormularioRegistrarUsuario(txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSueldoBase, txtNumHijos, botones);
        if (campos.equals("")) {
            int id;
            String nombre;
            String appPaterno;
            String appMaterno;
            double sueldoBase;
            String area;
            String sexo = "";
            String estadoCivil;
            int numHijos;

            nombre = txtNombre.getText();
            appPaterno = txtApellidoPaterno.getText();
            appMaterno = txtApellidoMaterno.getText();
            sueldoBase = Double.parseDouble(txtSueldoBase.getText());
            area = cbxArea.getSelectedItem().toString();
            if (bMujer.isSelected()) {
                sexo = "Femenino";
            }
            if (bHombre.isSelected()) {
                sexo = "Masculino";
            }
            estadoCivil = cbxEstadoCivil.getSelectedItem().toString();
            if (estadoCivil.equalsIgnoreCase("Casado")) {
                if (txtNumHijos.getText().trim().isEmpty() || Integer.parseInt(txtNumHijos.getText()) <= 0) {
                    JOptionPane.showMessageDialog(null, "Esta Vacia y/o no se puede ser Negativo", sexo, HEIGHT);
                } else {
                    numHijos = Integer.parseInt(txtNumHijos.getText());
                    if (isEdition) {
                        empleado = empleadoEditado;
                    } else {
                        empleado = new Empleado(nombre, appPaterno, appMaterno, sueldoBase, area, sexo, estadoCivil, numHijos);
                    }
                    if (!isEdition) {
                        empleadoDaoImple.insertarEmpleado(empleado);
                        JOptionPane.showMessageDialog(null, "Empleado con nombre " + nombre + " registrado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                        Utelerias.limpiarCamposFormularioRegistrarUsuario(txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSueldoBase, txtNumHijos, cbxArea, cbxEstadoCivil);
                    } else {
                        id = empleado.getId();
                        empleado = new Empleado(id, nombre, appPaterno, appMaterno, sueldoBase, area, sexo, estadoCivil, numHijos);
                        empleadoDaoImple.modificarDatosEmpleado(empleado);
                        JOptionPane.showMessageDialog(null, "Empleado con nombre " + nombre + " Modificado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                        Utelerias.limpiarCamposFormularioRegistrarUsuario(txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSueldoBase, txtNumHijos, cbxArea, cbxEstadoCivil);
                    }
                }
            } else {
                if (isEdition) {
                    empleado = empleadoEditado;
                } else {
                    empleado = new Empleado(nombre, appPaterno, appMaterno, sueldoBase, area, sexo, estadoCivil, 0);
                }
                if (!isEdition) {
                    empleadoDaoImple.insertarEmpleado(empleado);
                    JOptionPane.showMessageDialog(null, "Empleado con nombre " + nombre + " registrado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                    Utelerias.limpiarCamposFormularioRegistrarUsuario(txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSueldoBase, txtNumHijos, cbxArea, cbxEstadoCivil);
                } else {
                    id = empleado.getId();
                    empleado = new Empleado(id, nombre, appPaterno, appMaterno, sueldoBase, area, sexo, estadoCivil, 0);
                    empleadoDaoImple.modificarDatosEmpleado(empleado);
                    JOptionPane.showMessageDialog(null, "Empleado con nombre " + nombre + " Modificado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                    Utelerias.limpiarCamposFormularioRegistrarUsuario(txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtSueldoBase, txtNumHijos, cbxArea, cbxEstadoCivil);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verificar en " + campos, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSueldoBase = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNumHijos = new javax.swing.JTextField();
        lblHijos = new javax.swing.JLabel();
        RegistrarBtn = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        bHombre = new javax.swing.JRadioButton();
        bMujer = new javax.swing.JRadioButton();

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20)); // NOI18N
        lblTitulo.setText("Registro de un nuevo Empleado:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtApellidoPaterno.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel3.setText("Apellido Paterno:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel4.setText("Apellido Materno:");

        txtApellidoMaterno.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel5.setText("Sueldo Base:");

        txtSueldoBase.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel6.setText("Aréa:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel7.setText("Estado Civil:");

        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Soltero" }));
        cbxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoCivilActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        jLabel8.setText("Sexo:");

        txtNumHijos.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        lblHijos.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        lblHijos.setText("Nº de Hijos:");

        RegistrarBtn.setBackground(new java.awt.Color(0, 52, 91));
        RegistrarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrarBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarBtnMouseExited(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/GUARDAR (2).png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout RegistrarBtnLayout = new javax.swing.GroupLayout(RegistrarBtn);
        RegistrarBtn.setLayout(RegistrarBtnLayout);
        RegistrarBtnLayout.setHorizontalGroup(
            RegistrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RegistrarBtnLayout.setVerticalGroup(
            RegistrarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cbxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaActionPerformed(evt);
            }
        });

        bHombre.setText("Masculino");
        bHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHombreActionPerformed(evt);
            }
        });

        bMujer.setText("Femenino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(236, 236, 236))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addGap(6, 6, 6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(23, 23, 23))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(248, 248, 248))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidoPaterno)
                            .addComponent(txtNombre)
                            .addComponent(txtApellidoMaterno)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtSueldoBase)
                                .addGap(214, 214, 214)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHijos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumHijos)
                                .addGap(51, 51, 51))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(RegistrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(95, 95, 95))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(79, 79, 79))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bHombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bMujer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(131, 131, 131))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(79, 79, 79)))))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bHombre)
                            .addComponent(bMujer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegistrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarBtnMouseEntered
        RegistrarBtn.setBackground(new Color(1, 97, 143));
    }//GEN-LAST:event_RegistrarBtnMouseEntered

    private void RegistrarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarBtnMouseExited
        RegistrarBtn.setBackground(new Color(0, 52, 91));
    }//GEN-LAST:event_RegistrarBtnMouseExited

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cbxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAreaActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        registrarEmpleado();
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void cbxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoCivilActionPerformed
        activarCamposHijos(cbxEstadoCivil.getSelectedItem().toString());
    }//GEN-LAST:event_cbxEstadoCivilActionPerformed

    private void bHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bHombreActionPerformed

    public void activarCamposHijos(String valor) {
        if (valor.equalsIgnoreCase("Casado") || valor.equalsIgnoreCase("Casada")) {
            txtNumHijos.setVisible(true);
            lblHijos.setVisible(true);
        } else {
            txtNumHijos.setVisible(false);
            lblHijos.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RegistrarBtn;
    private javax.swing.JRadioButton bHombre;
    private javax.swing.JRadioButton bMujer;
    private javax.swing.ButtonGroup botones;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JComboBox<String> cbxEstadoCivil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHijos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumHijos;
    private javax.swing.JTextField txtSueldoBase;
    // End of variables declaration//GEN-END:variables
}
