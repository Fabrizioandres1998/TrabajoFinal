
package Vistas;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Persistencia.Conexion;
import Persistencia.DiaDeSpaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author vanne
 */
public class GestionDiaDeSpa extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private DiaDeSpa diaActual = null;

    public GestionDiaDeSpa(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        accionesBotones();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jGestiondeDiasdeSpa = new javax.swing.JLabel();
        jCodigoDiadeSpa = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        jCliente = new javax.swing.JLabel();
        jTratamiento = new javax.swing.JLabel();
        jMasajista = new javax.swing.JLabel();
        jtext1 = new javax.swing.JTextField();
        jtext2 = new javax.swing.JTextField();
        jcbCliente = new javax.swing.JComboBox<>();
        jcbTratamiento = new javax.swing.JComboBox<>();
        jcbMasajista = new javax.swing.JComboBox<>();
        jCactive = new javax.swing.JCheckBox();
        jBnuevo = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBbuscar = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        jGestiondeDiasdeSpa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestiondeDiasdeSpa.setForeground(new java.awt.Color(153, 0, 153));
        jGestiondeDiasdeSpa.setText("Gestion de Dias de Spa");

        jCodigoDiadeSpa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCodigoDiadeSpa.setText("Codigo dia de spa :");

        jFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jFecha.setText("Fecha :    ");

        jCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCliente.setText("Cliente :   ");

        jTratamiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTratamiento.setText("Tratamiento :");

        jMasajista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMasajista.setText("Masajista :   ");

        jCactive.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCactive.setText("Activo");

        jBnuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBnuevo.setText("Nuevo");
        jBnuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));

        jBguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBguardar.setText("Guardar");
        jBguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        jBmodificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBmodificar.setText("Modificar");
        jBmodificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));

        jBeliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBeliminar.setText("Eliminar");
        jBeliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        jBbuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));

        jDesktopPane1.setLayer(jGestiondeDiasdeSpa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCodigoDiadeSpa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTratamiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jMasajista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtext1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtext2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTratamiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbMasajista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCactive, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBnuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBguardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBmodificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBeliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBbuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jGestiondeDiasdeSpa))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFecha)
                            .addComponent(jCodigoDiadeSpa)
                            .addComponent(jCliente)
                            .addComponent(jTratamiento)
                            .addComponent(jMasajista))
                        .addGap(32, 32, 32)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCactive)
                            .addComponent(jtext2)
                            .addComponent(jcbCliente, 0, 160, Short.MAX_VALUE)
                            .addComponent(jtext1)
                            .addComponent(jcbTratamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbMasajista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGestiondeDiasdeSpa)
                .addGap(58, 58, 58)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoDiadeSpa)
                    .addComponent(jtext1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFecha)
                    .addComponent(jtext2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCliente)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTratamiento)
                    .addComponent(jcbTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMasajista)
                    .addComponent(jcbMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCactive)
                .addGap(45, 45, 45)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void accionesBotones() {
        jBguardar.addActionListener(e -> guardarDiaDeSpa());
        jBnuevo.addActionListener(e -> limpiarCampos());
    }

     private void guardarDiaDeSpa() {
        try {
            String errores = "";

            if (jtext1.getText().trim().isEmpty()) {
                errores += "- El codigo es obligatorio.\n";
            } else if (!jtext1.getText().matches("\\d+")) {
                errores += "- El codigo solo puede contener numeros.\n";
            }

            if (jtext2.getText().trim().isEmpty()) {
                errores += "- Debe ingresar la fecha.\n";
            } else if (!jtext2.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
                errores += "- Formato de fecha invalido (use YYYY-MM-DD).\n";
            }

            if (jcbCliente.getSelectedItem() == null || jcbCliente.getSelectedItem().toString().isEmpty()) {
                errores += "- Debe seleccionar un cliente.\n";
            }
            if (jcbTratamiento.getSelectedItem() == null || jcbTratamiento.getSelectedItem().toString().isEmpty()) {
                errores += "- Debe seleccionar un tratamiento.\n";
            }
            if (jcbMasajista.getSelectedItem() == null || jcbMasajista.getSelectedItem().toString().isEmpty()) {
                errores += "- Debe seleccionar un masajista.\n";
            }

            if (!errores.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Corrija los siguientes errores:\n" + errores, "Errores de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(jtext1.getText().trim());
            LocalDate fecha = LocalDate.parse(jtext2.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDateTime fechaYHora = fecha.atStartOfDay();

            Cliente cliente = (Cliente) jcbCliente.getSelectedItem();
            boolean activo = jCactive.isSelected();

            DiaDeSpa dia = new DiaDeSpa(codigo, fechaYHora, "Preferencias generales", cliente, activo, null, 0.0);

            DiaDeSpaData diaData = new DiaDeSpaData(conexion);
            diaData.guardarDiaDeSpa(dia);

            JOptionPane.showMessageDialog(this, "dia de Spa guardado correctamente.", "exito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error al guardar dia de Spa: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // eliminar (baja logica)
    private void eliminarDiaDeSpa() {
        try {
            if (jtext1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un codigo de dia de Spa antes de eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(jtext1.getText().trim());

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que desea dar de baja este dia de Spa?",
                    "Confirmar baja",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DiaDeSpaData diaData = new DiaDeSpaData(conexion);
                diaData.bajaLogicaDiaDeSpa(codigo);
                JOptionPane.showMessageDialog(this, "Día de Spa dado de baja correctamente.");
                limpiarCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error al eliminar dia de Spa: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    // limpia los campos
    private void limpiarCampos() {
        jtext1.setText("");
        jtext2.setText("");
        jcbCliente.setSelectedIndex(-1);
        jcbTratamiento.setSelectedIndex(-1);
        jcbMasajista.setSelectedIndex(-1);
        jCactive.setSelected(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JCheckBox jCactive;
    private javax.swing.JLabel jCliente;
    private javax.swing.JLabel jCodigoDiadeSpa;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jGestiondeDiasdeSpa;
    private javax.swing.JLabel jMasajista;
    private javax.swing.JLabel jTratamiento;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbMasajista;
    private javax.swing.JComboBox<String> jcbTratamiento;
    private javax.swing.JTextField jtext1;
    private javax.swing.JTextField jtext2;
    // End of variables declaration//GEN-END:variables
}
