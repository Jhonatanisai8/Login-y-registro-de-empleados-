package Vistas;

import Models.Conexion;
import Models.Utelerias;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
//imports para generar pdfs

/**
 *
 * @author Jhonatan
 */
public class ReportesTotales extends javax.swing.JPanel {

    Conexion conexion = Conexion.getInstancia();

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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReporteEmpleados.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(10);

            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("App Paterno");
            tabla.addCell("App Materno");
            tabla.addCell("Área");
            tabla.addCell("Estado Civil");
            tabla.addCell("Nº de hijos");
            tabla.addCell("Bono Área");
            tabla.addCell("Desct");
            tabla.addCell("Sueldo Total");

            try {
                Connection conectar = conexion.conectarBD();
                String sql = "SELECT empleados.id AS \"ID\", empleados.nombre AS \"NOMBRE\", empleados.appPaterno AS \"APP PATERNO\", empleados.appMaterno AS \"APP MATERNO\", area.nombre AS \"ÁREA\", empleados.estadoCivil AS \"ESTADO CIVIL\", empleados.numHijos AS \"Nº DE HIJOS\", TRUNCATE(empleados.bonoArea,2) AS \"BONO ÁREA\", TRUNCATE((empleados.montoDescuento + empleados.montoImpuesto),2) AS \"SUM. DESC\", TRUNCATE(empleados.sueldoTotal,2) AS \"SUELDO TOTAL\" FROM empleados INNER JOIN area ON area.id = empleados.idArea";
                PreparedStatement consultaPreparada = conectar.prepareStatement(sql);
                ResultSet resultado = consultaPreparada.executeQuery();

                //validacion si hay datos
                if (resultado.next()) {
                    do {
                        tabla.addCell(resultado.getString(1));
                        tabla.addCell(resultado.getString(2));
                        tabla.addCell(resultado.getString(2));
                        tabla.addCell(resultado.getString(3));
                        tabla.addCell(resultado.getString(4));
                        tabla.addCell(resultado.getString(5));
                        tabla.addCell(resultado.getString(6));
                        tabla.addCell(resultado.getString(7));
                        tabla.addCell(resultado.getString(8));
                        tabla.addCell(resultado.getString(9));
                        tabla.addCell(resultado.getString(10));
                    } while (resultado.next());
                    documento.add(tabla);
                }
                conexion.desconectaBD();
            } catch (DocumentException | SQLException e) {
                System.out.println("Error al crear pdf: " + e.toString());
            }
            documento.close();
            JOptionPane.showConfirmDialog(null, "Reporte Creado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("Error al crear pdf: " + e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
