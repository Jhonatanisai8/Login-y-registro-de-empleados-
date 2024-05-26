package Vistas;

import DaoImplementacion.EmpleadoDaoImple;
import Formularios.frmHola;
import Models.Empleado;
import Models.Utelerias;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jhonatan
 */
public class ReporteUsuarios extends javax.swing.JPanel {
    
    String cabezera[] = {"ID", "NOMBRES", "APELLIDO PATERNO", "APELLIDO MATERNO", "SUELDO BASE", "ÁREA", "ESTADO CIVIL", "SUELDO TOTAL"};
    DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);
    
    Utelerias utelerias = new Utelerias();

    //variables para buscar por nombre
    private TableRowSorter trsFiltro;
    String filtro;
    
    public ReporteUsuarios() {
        initComponents();
        this.estilos();
        utelerias.cargarTable(modelo, btlDatos, 0);
    }
    
    void estilos() {
        txtBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre a buscar");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        btlDatos = new javax.swing.JTable();
        EliminarBtn = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        ModificarBtn = new javax.swing.JPanel();
        btnModificar = new javax.swing.JLabel();
        NuevoBtn = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BuscarBtn = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20)); // NOI18N
        jLabel1.setText("Reporte de Empleado:");

        btlDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO PATERNO", "APPELLIDO MATERNO", "SUELDO BASE", "ÁREA", "ESTADO CIVIL", "SUELDO TOTAL"
            }
        ));
        jScrollPane1.setViewportView(btlDatos);

        EliminarBtn.setBackground(new java.awt.Color(2, 75, 115));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/ELIMINAR (2).png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout EliminarBtnLayout = new javax.swing.GroupLayout(EliminarBtn);
        EliminarBtn.setLayout(EliminarBtnLayout);
        EliminarBtnLayout.setHorizontalGroup(
            EliminarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        EliminarBtnLayout.setVerticalGroup(
            EliminarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ModificarBtn.setBackground(new java.awt.Color(2, 75, 115));

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/MODIFICAR.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ModificarBtnLayout = new javax.swing.GroupLayout(ModificarBtn);
        ModificarBtn.setLayout(ModificarBtnLayout);
        ModificarBtnLayout.setHorizontalGroup(
            ModificarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        ModificarBtnLayout.setVerticalGroup(
            ModificarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnModificar)
        );

        NuevoBtn.setBackground(new java.awt.Color(2, 75, 115));

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/NUEVO (3).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout NuevoBtnLayout = new javax.swing.GroupLayout(NuevoBtn);
        NuevoBtn.setLayout(NuevoBtnLayout);
        NuevoBtnLayout.setHorizontalGroup(
            NuevoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        NuevoBtnLayout.setVerticalGroup(
            NuevoBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo)
        );

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20)); // NOI18N
        jLabel2.setText("Buscar:");

        BuscarBtn.setBackground(new java.awt.Color(2, 75, 115));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/BUSCAR (2).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BuscarBtnLayout = new javax.swing.GroupLayout(BuscarBtn);
        BuscarBtn.setLayout(BuscarBtnLayout);
        BuscarBtnLayout.setHorizontalGroup(
            BuscarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BuscarBtnLayout.setVerticalGroup(
            BuscarBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscarBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscar))
        );

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar)))
                        .addGap(119, 119, 119)
                        .addComponent(BuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NuevoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ModificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EliminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BuscarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(EliminarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModificarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NuevoBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        EliminarBtn.setBackground(new Color(2, 75, 115));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        ModificarBtn.setBackground(new Color(2, 75, 115));
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseExited
        NuevoBtn.setBackground(new Color(2, 75, 115));
    }//GEN-LAST:event_btnNuevoMouseExited

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        BuscarBtn.setBackground(new Color(2, 75, 115));
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        EliminarBtn.setBackground(new Color(3, 105, 160));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        ModificarBtn.setBackground(new Color(3, 105, 160));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseEntered
        NuevoBtn.setBackground(new Color(3, 105, 160));
    }//GEN-LAST:event_btnNuevoMouseEntered

    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        BuscarBtn.setBackground(new Color(3, 105, 160));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        frmHola.colocalarPanelEnPrincipal(new RegistroUsuario());
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        if (txtBuscar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor Ingrese el nombre a Buscar", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        buscar();
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        trsFiltro = new TableRowSorter(btlDatos.getModel());
        btlDatos.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int fila;
        int idEmpleado;
        //metodo para selecionar la fila
        fila = btlDatos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Por favor seleciona el empleado a modificar", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            EmpleadoDaoImple empleadoDaoImple = new EmpleadoDaoImple();
            idEmpleado = (int) btlDatos.getValueAt(fila, 0);
            frmHola.colocalarPanelEnPrincipal(new RegistroUsuario(empleadoDaoImple.obtenerInformacion(idEmpleado)));
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        int fila;
        int idEmpleado;
        //metodo para selecionar la fila
        fila = btlDatos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Por favor seleciona el empleado a eliminar", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            idEmpleado = (int) btlDatos.getValueAt(fila, 0);
            EmpleadoDaoImple empleadoDaoImple = new EmpleadoDaoImple();
            //llamamos al constructor que nos permite eliminar un empleado
            Empleado empleado = new Empleado(idEmpleado);
            empleadoDaoImple.eliminarEmpleado(empleado);
            modelo.removeRow(fila);
            JOptionPane.showMessageDialog(null, "Cliente con id: " + idEmpleado + " Eliminado", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked
    
    public void filtroNombre() {
        if (txtBuscar == null) {
        } else {
            try {
                filtro = txtBuscar.getText();
                //va a buscar en la colunna 1 y buscar lo que esta almacenado en la caja de texto
                trsFiltro.setRowFilter(RowFilter.regexFilter(filtro, 1));
            } catch (Exception e) {
                System.out.println("Error al buscar: " + e.toString());
            }
        }
    }
    
    private void buscar() {
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = txtBuscar.getText();
                txtBuscar.setText(cadena);
                repaint();

                // Verificar si trsFiltro está inicializado antes de llamar a filtro()
                if (trsFiltro != null) {
                    filtroNombre();
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BuscarBtn;
    private javax.swing.JPanel EliminarBtn;
    private javax.swing.JPanel ModificarBtn;
    private javax.swing.JPanel NuevoBtn;
    private javax.swing.JTable btlDatos;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
