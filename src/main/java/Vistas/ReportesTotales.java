package Vistas;

import Models.Conexion;
import Models.Utelerias;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
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
        GenerarReporteBtn = new javax.swing.JPanel();
        btnGenerarReporte = new javax.swing.JLabel();

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

        GenerarReporteBtn.setBackground(new java.awt.Color(2, 75, 115));

        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnGenerarReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/NUEVO (3).png"))); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarReporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout GenerarReporteBtnLayout = new javax.swing.GroupLayout(GenerarReporteBtn);
        GenerarReporteBtn.setLayout(GenerarReporteBtnLayout);
        GenerarReporteBtnLayout.setHorizontalGroup(
            GenerarReporteBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );
        GenerarReporteBtnLayout.setVerticalGroup(
            GenerarReporteBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGenerarReporte)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(GenerarReporteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(390, 390, 390))
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
                .addGap(20, 20, 20)
                .addComponent(GenerarReporteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseClicked

        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReporteEmpleados.pdf"));
            documento.open();

            PdfPTable tabla = new PdfPTable(8);

            tabla.addCell("Id");
            tabla.addCell("Nombre");
            tabla.addCell("App Paterno");
            tabla.addCell("App Materno");
            tabla.addCell("Área");
            tabla.addCell("Estado Civil");
            tabla.addCell("Desct");
            tabla.addCell("Sueldo Total");

            try {
                Connection conectar = conexion.conectarBD();
                String sql = "SELECT empleados.id, empleados.nombre , empleados.appPaterno, empleados.appMaterno, area.nombre , empleados.estadoCivil, TRUNCATE((empleados.montoDescuento + empleados.montoImpuesto),2) , TRUNCATE(empleados.sueldoTotal,2) FROM empleados INNER JOIN area ON area.id = empleados.idArea";
                PreparedStatement consultaPreparada = conectar.prepareStatement(sql);
                ResultSet resultado = consultaPreparada.executeQuery();

                //validacion si hay datos
                if (resultado.next()) {
                    do {
                        tabla.addCell(resultado.getString(1));
                        tabla.addCell(resultado.getString(2));
                        tabla.addCell(resultado.getString(3));
                        tabla.addCell(resultado.getString(4));
                        tabla.addCell(resultado.getString(5));
                        tabla.addCell(resultado.getString(6));
                        tabla.addCell(resultado.getString(7));
                        tabla.addCell(resultado.getString(8));
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
    }//GEN-LAST:event_btnGenerarReporteMouseClicked

    private void btnGenerarReporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseEntered
        GenerarReporteBtn.setBackground(new Color(3, 105, 160));
    }//GEN-LAST:event_btnGenerarReporteMouseEntered

    private void btnGenerarReporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarReporteMouseExited
        GenerarReporteBtn.setBackground(new Color(2, 75, 115));
    }//GEN-LAST:event_btnGenerarReporteMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GenerarReporteBtn;
    private javax.swing.JLabel btnGenerarReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
