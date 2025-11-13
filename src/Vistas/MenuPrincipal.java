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

        jdpMenuPrincipal.setBorder(BorderFactory.createEmptyBorder());
        jdpMenuPrincipal = new javax.swing.JDesktopPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        this.setContentPane(jdpMenuPrincipal);

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

        jdpMenuPrincipal = new javax.swing.JDesktopPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdpMenuPrincipalLayout = new javax.swing.GroupLayout(jdpMenuPrincipal);
        jdpMenuPrincipal.setLayout(jdpMenuPrincipalLayout);
        jdpMenuPrincipalLayout.setHorizontalGroup(
            jdpMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jdpMenuPrincipalLayout.setVerticalGroup(
            jdpMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        jmiTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTratamientoActionPerformed(evt);
            }
        });
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
        jmiInstalaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInstalacionesActionPerformed(evt);
            }
        });
        jGestion.add(jmiInstalaciones);

        jmiConsultorios.setText("Consultorios");
        jmiConsultorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultoriosActionPerformed(evt);
            }
        });
        jGestion.add(jmiConsultorios);
        jGestion.add(jSeparator1);

        jMenuBar1.add(jGestion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpMenuPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpMenuPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiMasajistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMasajistaActionPerformed
        GestiondeMasajistas gdm = new GestiondeMasajistas(conexion);
        jdpMenuPrincipal.add(gdm);
        gdm.setVisible(true);
    }//GEN-LAST:event_jmiMasajistaActionPerformed

    private void jmiDiaDeSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDiaDeSpaActionPerformed
        // Limpiamos el JDesktopPane
        jdpMenuPrincipal.removeAll();
        jdpMenuPrincipal.repaint();

        // Creamos la ventana interna de GestionDiaDeSpa
        GestionDiaDeSpa vistaDia = new GestionDiaDeSpa(conexion);
        vistaDia.setVisible(true);

        // La agregamos al JDesktopPane y la traemos al frente
        jdpMenuPrincipal.add(vistaDia);
        jdpMenuPrincipal.moveToFront(vistaDia);
    }//GEN-LAST:event_jmiDiaDeSpaActionPerformed

    private void jGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGestionActionPerformed

    }//GEN-LAST:event_jGestionActionPerformed

    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClienteActionPerformed
        GestionDeClientes gc = new GestionDeClientes(conexion);
        jdpMenuPrincipal.add(gc);
        gc.setVisible(true);
    }//GEN-LAST:event_jmiClienteActionPerformed

    private void jmiTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTurnosActionPerformed
        GestionTurnos gt = new GestionTurnos(conexion);
        jdpMenuPrincipal.add(gt);
        gt.setVisible(true);
    }//GEN-LAST:event_jmiTurnosActionPerformed

    private void jmiInstalacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInstalacionesActionPerformed
        GestiondeInstalaciones gi = new GestiondeInstalaciones(conexion);
        jdpMenuPrincipal.add(gi);
        gi.setVisible(true);
    }//GEN-LAST:event_jmiInstalacionesActionPerformed

    private void jmiTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTratamientoActionPerformed
        GestiondeTratamientos gt = new GestiondeTratamientos(conexion);
        jdpMenuPrincipal.add(gt);
        gt.setVisible(true);
    }//GEN-LAST:event_jmiTratamientoActionPerformed

    private void jmiConsultoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultoriosActionPerformed
        GestionConsultorios gc = new GestionConsultorios(conexion);
        jdpMenuPrincipal.add(gc);
        gc.setVisible(true);
    }//GEN-LAST:event_jmiConsultoriosActionPerformed

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
    private javax.swing.JMenu jGestion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JDesktopPane jdpMenuPrincipal;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiConsultorios;
    private javax.swing.JMenuItem jmiDiaDeSpa;
    private javax.swing.JMenuItem jmiInstalaciones;
    private javax.swing.JMenuItem jmiMasajista;
    private javax.swing.JMenuItem jmiTratamiento;
    private javax.swing.JMenuItem jmiTurnos;
    // End of variables declaration//GEN-END:variables
}
