package Vistas;

import Persistencia.Conexion;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    
    private Conexion conexion;

    String url = "jdbc:mariadb://localhost:3306/spayrelax";
    String usuario = "root";
    String password = "";

    public MenuPrincipal() {
        initComponents();
          ImageIcon icon = new ImageIcon(getClass().getResource("/Vistas/imagenes/spa.jpg"));
    Image image = icon.getImage();

   
     
    jDesktopPane1.setBorder(BorderFactory.createEmptyBorder()); 
    jDesktopPane1 = new javax.swing.JDesktopPane() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };
   
    this.setContentPane(jDesktopPane1);

        conexion = new Conexion(url, usuario, password);
        Connection conex = conexion.obtenerConexion();

        if (conex == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jGestion = new javax.swing.JMenu();
        jmiCliente = new javax.swing.JMenuItem();
        jmiMasajista = new javax.swing.JMenuItem();
        jmiTratamiento = new javax.swing.JMenuItem();
        jmiDiaDeSpa = new javax.swing.JMenuItem();
        jmiTurnos = new javax.swing.JMenuItem();
        jmiInstalaciones = new javax.swing.JMenuItem();
        jmiConsultorios = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jConsultas = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jGestion.setForeground(new java.awt.Color(102, 0, 204));
        jGestion.setText("Gestion ");
        jGestion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGestionActionPerformed(evt);
            }
        });

        jmiCliente.setText("Cliente");
        jmiCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClienteActionPerformed(evt);
            }
        });
        jGestion.add(jmiCliente);

        jmiMasajista.setText("Masajista");
        jmiMasajista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMasajistaActionPerformed(evt);
            }
        });
        jGestion.add(jmiMasajista);

        jmiTratamiento.setText("Tratamiento");
        jGestion.add(jmiTratamiento);

        jmiDiaDeSpa.setText("Dia de spa");
        jmiDiaDeSpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDiaDeSpaActionPerformed(evt);
            }
        });
        jGestion.add(jmiDiaDeSpa);

        jmiTurnos.setText("Turnos");
        jmiTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTurnosActionPerformed(evt);
            }
        });
        jGestion.add(jmiTurnos);

        jmiInstalaciones.setText("Instalaciones");
        jGestion.add(jmiInstalaciones);

        jmiConsultorios.setText("Consultorios");
        jGestion.add(jmiConsultorios);
        jGestion.add(jSeparator1);

        jMenuBar1.add(jGestion);

        jConsultas.setForeground(new java.awt.Color(153, 0, 204));
        jConsultas.setText("Consultas");
        jConsultas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItem6.setText("Listar Clientes");
        jConsultas.add(jMenuItem6);

        jMenuItem7.setText("Listar Masajistas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jConsultas.add(jMenuItem7);

        jMenuItem8.setText("Listar Tratamientos");
        jConsultas.add(jMenuItem8);

        jMenuItem9.setText("Listar Turnos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jConsultas.add(jMenuItem9);

        jMenuBar1.add(jConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiMasajistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMasajistaActionPerformed
        GestiondeMasajistas gdm = new GestiondeMasajistas(conexion);
        jdpMenuPrincipal.add(gdm);
        gdm.setVisible(true);
    }//GEN-LAST:event_jmiMasajistaActionPerformed

    private void jmiDiaDeSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDiaDeSpaActionPerformed
<<<<<<< HEAD
        GestionDiaDeSpa gds = new GestionDiaDeSpa(conexion);
        jdpMenuPrincipal.add(gds);
        gds.setVisible(true);
=======
          jDesktopPane1.removeAll();
    jDesktopPane1.repaint();

    GestionDiaDeSpa vistaDia = new GestionDiaDeSpa(conexion); 
    vistaDia.setVisible(true);
    jDesktopPane1.add(vistaDia);
    jDesktopPane1.moveToFront(vistaDia);

>>>>>>> 6122fccd7ef499ceb3057c4e2588a6ac13514bdd
    }//GEN-LAST:event_jmiDiaDeSpaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jGestionActionPerformed

    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClienteActionPerformed
        GestionDeClientes gc = new GestionDeClientes(conexion);
        jDesktopPane1.add(gc);
        gc.setVisible(true);
    }//GEN-LAST:event_jmiClienteActionPerformed

    private void jmiTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTurnosActionPerformed
        GestionTurnos gt = new GestionTurnos(conexion);
        jdpMenuPrincipal.add(gt);
        gt.setVisible(true);
    }//GEN-LAST:event_jmiTurnosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jConsultas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jGestion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiConsultorios;
    private javax.swing.JMenuItem jmiDiaDeSpa;
    private javax.swing.JMenuItem jmiInstalaciones;
    private javax.swing.JMenuItem jmiMasajista;
    private javax.swing.JMenuItem jmiTratamiento;
    private javax.swing.JMenuItem jmiTurnos;
    // End of variables declaration//GEN-END:variables
}
