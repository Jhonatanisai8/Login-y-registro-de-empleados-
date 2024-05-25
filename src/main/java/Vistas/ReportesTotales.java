package Vistas;

import Models.Utelerias;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhonatan
 */
public class ReportesTotales extends javax.swing.JPanel {

    //objeto de la clase Utelerias
    Utelerias utelerias = new Utelerias();

    String cabezera[] = {"ID",
        "NOMBRE",
        "APELLIDO PATERNO",
        "APELLIDO MATERNO",
        "SUELDO BASE",
        "ÁREA", 
        "SEXO",
        "ESTADO CIVIL",
        "Nº HIJOS",
        "BONO ÁREA",
        "SUMA DESC",
        "SUELDO TOTAL"};
    DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);

    public ReportesTotales() {
        initComponents();
        utelerias.cargarTable(modelo, tblDatos, 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 20)); // NOI18N
        jLabel1.setText("Reportes de EmpleadosTotales:");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO PATERNO", "APELLIDO MATERNO", "SUELDO BASE", "ÀREA TRABAJO", "SEXO", "ESTADO CIVIL", "Nº HIJOS", "BONO ÀREA", "SUMA DESC", "SUELDO TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                        .addGap(476, 476, 476))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
