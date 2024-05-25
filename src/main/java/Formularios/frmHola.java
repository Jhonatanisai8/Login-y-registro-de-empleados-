package Formularios;

import Vistas.Bienvenida;
import Vistas.RegistroUsuario;
import Vistas.ReporteUsuarios;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author Jhonatan
 */
public class frmHola extends javax.swing.JFrame {

    public frmHola() {
        initComponents();
        obtenerFecha();
        FlatMaterialLighterIJTheme.setup();
        frmHola.colocalarPanelEnPrincipal(new Bienvenida());
    }

    private void obtenerFecha() {
        LocalDate fecha = LocalDate.now();
        Locale spanishLocalDate = new Locale("es", "Es");
        lblFecha.setText(fecha.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocalDate)));
    }

    public static void colocalarPanelEnPrincipal(JPanel panel) {
        panel.setSize(845, 465);
        panel.setLocation(0, 0);

        contenido.removeAll();
        contenido.add(panel, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
        panel.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PrincipalBtn = new javax.swing.JPanel();
        btnPrincipal = new javax.swing.JLabel();
        RegistroEmpleadosBtn = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JLabel();
        ReportesBtn = new javax.swing.JPanel();
        btnReportes = new javax.swing.JLabel();
        GraficosBtn = new javax.swing.JPanel();
        btnGraficos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 52, 91));

        jLabel1.setFont(new java.awt.Font("SimSun-ExtB", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jhonatan's");

        PrincipalBtn.setBackground(new java.awt.Color(1, 100, 148));

        btnPrincipal.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        btnPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/PRINCIPAL.png"))); // NOI18N
        btnPrincipal.setText("Principal");
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PrincipalBtnLayout = new javax.swing.GroupLayout(PrincipalBtn);
        PrincipalBtn.setLayout(PrincipalBtnLayout);
        PrincipalBtnLayout.setHorizontalGroup(
            PrincipalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrincipalBtnLayout.setVerticalGroup(
            PrincipalBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        RegistroEmpleadosBtn.setBackground(new java.awt.Color(1, 100, 148));
        RegistroEmpleadosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistroEmpleadosBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistroEmpleadosBtnMouseExited(evt);
            }
        });

        btnRegistro.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/EMPLEADOS (2).png"))); // NOI18N
        btnRegistro.setText("Empleados");
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout RegistroEmpleadosBtnLayout = new javax.swing.GroupLayout(RegistroEmpleadosBtn);
        RegistroEmpleadosBtn.setLayout(RegistroEmpleadosBtnLayout);
        RegistroEmpleadosBtnLayout.setHorizontalGroup(
            RegistroEmpleadosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        RegistroEmpleadosBtnLayout.setVerticalGroup(
            RegistroEmpleadosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        ReportesBtn.setBackground(new java.awt.Color(1, 100, 148));
        ReportesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportesBtnMouseExited(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Reportes.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout ReportesBtnLayout = new javax.swing.GroupLayout(ReportesBtn);
        ReportesBtn.setLayout(ReportesBtnLayout);
        ReportesBtnLayout.setHorizontalGroup(
            ReportesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        ReportesBtnLayout.setVerticalGroup(
            ReportesBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        GraficosBtn.setBackground(new java.awt.Color(1, 100, 148));
        GraficosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GraficosBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GraficosBtnMouseExited(evt);
            }
        });

        btnGraficos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        btnGraficos.setForeground(new java.awt.Color(255, 255, 255));
        btnGraficos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGraficos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/GRAFICOS.png"))); // NOI18N
        btnGraficos.setText("Graficos");
        btnGraficos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGraficos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGraficosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGraficosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGraficosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout GraficosBtnLayout = new javax.swing.GroupLayout(GraficosBtn);
        GraficosBtn.setLayout(GraficosBtnLayout);
        GraficosBtnLayout.setHorizontalGroup(
            GraficosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        GraficosBtnLayout.setVerticalGroup(
            GraficosBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrincipalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegistroEmpleadosBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GraficosBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(PrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegistroEmpleadosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReportesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GraficosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("!Hola, Bienvenido¡");

        Header.setBackground(new java.awt.Color(0, 52, 91));

        lblFecha.setFont(new java.awt.Font("MS Gothic", 1, 25)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Hoy es {dayname} de {day} de {month} de {year}");

        jLabel4.setFont(new java.awt.Font("MS Gothic", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SISTEMA CRUD EMPLEADOS");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        contenido.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Captura de pantalla (938) (2) (1).png"))); // NOI18N
        jLabel3.setText("Jhonatan's");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        frmHola.colocalarPanelEnPrincipal(new Bienvenida());
    }//GEN-LAST:event_btnPrincipalMouseClicked

    private void btnPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseEntered
        PrincipalBtn.setBackground(new Color(1, 84, 124));
    }//GEN-LAST:event_btnPrincipalMouseEntered

    private void btnPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseExited
        PrincipalBtn.setBackground(new Color(1, 100, 148));
    }//GEN-LAST:event_btnPrincipalMouseExited

    private void RegistroEmpleadosBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroEmpleadosBtnMouseEntered
        RegistroEmpleadosBtn.setBackground(new Color(1, 84, 124));
    }//GEN-LAST:event_RegistroEmpleadosBtnMouseEntered

    private void RegistroEmpleadosBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistroEmpleadosBtnMouseExited
        RegistroEmpleadosBtn.setBackground(new Color(1, 100, 148));
    }//GEN-LAST:event_RegistroEmpleadosBtnMouseExited

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        frmHola.colocalarPanelEnPrincipal(new ReporteUsuarios());
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseEntered
        RegistroEmpleadosBtn.setBackground(new Color(1, 84, 124));
    }//GEN-LAST:event_btnRegistroMouseEntered

    private void btnRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseExited
        RegistroEmpleadosBtn.setBackground(new Color(1, 100, 148));
    }//GEN-LAST:event_btnRegistroMouseExited

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        ReportesBtn.setBackground(new Color(1, 84, 124));
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        ReportesBtn.setBackground(new Color(1, 100, 148));
    }//GEN-LAST:event_btnReportesMouseExited

    private void ReportesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportesBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportesBtnMouseEntered

    private void ReportesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportesBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportesBtnMouseExited

    private void btnGraficosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGraficosMouseClicked

    private void btnGraficosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficosMouseEntered
        GraficosBtn.setBackground(new Color(1, 84, 124));
    }//GEN-LAST:event_btnGraficosMouseEntered

    private void btnGraficosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficosMouseExited
        GraficosBtn.setBackground(new Color(1, 100, 148));
    }//GEN-LAST:event_btnGraficosMouseExited

    private void GraficosBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraficosBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_GraficosBtnMouseEntered

    private void GraficosBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraficosBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_GraficosBtnMouseExited
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraficosBtn;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel PrincipalBtn;
    private javax.swing.JPanel RegistroEmpleadosBtn;
    private javax.swing.JPanel ReportesBtn;
    private javax.swing.JLabel btnGraficos;
    private javax.swing.JLabel btnPrincipal;
    private javax.swing.JLabel btnRegistro;
    private javax.swing.JLabel btnReportes;
    private static javax.swing.JPanel contenido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
}
