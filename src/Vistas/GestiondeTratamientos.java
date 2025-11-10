
package Vistas;
import Modelo.Tratamiento;
import Persistencia.TratamientoData;
import Persistencia.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GestiondeTratamientos extends javax.swing.JInternalFrame {
    private Conexion conexion;
    private Tratamiento tratamientoActual;
    
    public GestiondeTratamientos() {
        initComponents();
         this.conexion = conexion;
    }

   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jGestionDeTratamientos = new javax.swing.JLabel();
        jCodigoTratamiento = new javax.swing.JLabel();
        jNombre = new javax.swing.JLabel();
        jDescripcion = new javax.swing.JLabel();
        jDuracion = new javax.swing.JLabel();
        jCosto = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfDetalle = new javax.swing.JTextField();
        jtfDuracion = new javax.swing.JTextField();
        jtfCosto = new javax.swing.JTextField();
        jcbActivo = new javax.swing.JCheckBox();
        jBnuevo = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBbuscar = new javax.swing.JButton();

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jGestionDeTratamientos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestionDeTratamientos.setForeground(new java.awt.Color(153, 0, 153));
        jGestionDeTratamientos.setText("Gestion de Tratamientos");

        jCodigoTratamiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCodigoTratamiento.setText("Codigo tratamiento :");

        jNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jNombre.setText("Nombre : ");

        jDescripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jDescripcion.setText("Descripcion : ");

        jDuracion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jDuracion.setText("Duracion (min) :");

        jCosto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCosto.setText("Costo  :   ");

        jtfCodigo.setName(""); // NOI18N
        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jtfDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDuracionActionPerformed(evt);
            }
        });

        jcbActivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcbActivo.setText("Activo");

        jBnuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBnuevo.setText("Nuevo");
        jBnuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));

        jBguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBguardar.setText("Guardar ");
        jBguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 153)));

        jBmodificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBmodificar.setText("Modificar");
        jBmodificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));

        jBeliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBeliminar.setText("Eliminar");
        jBeliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));

        jBbuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 153)));

        jDesktopPane1.setLayer(jGestionDeTratamientos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCodigoTratamiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDuracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDetalle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDuracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBnuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBguardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBmodificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBeliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBbuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jcbActivo))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCodigoTratamiento)
                            .addComponent(jNombre)
                            .addComponent(jDescripcion)
                            .addComponent(jDuracion)
                            .addComponent(jCosto))
                        .addGap(60, 60, 60)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jGestionDeTratamientos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGestionDeTratamientos)
                .addGap(54, 54, 54)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoTratamiento))
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNombre))
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescripcion))
                .addGap(31, 31, 31)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDuracion))
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCosto))
                .addGap(18, 18, 18)
                .addComponent(jcbActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        try {
            String nombre = jtfNombre.getText().trim();
            String tipo = jtfCodigo.getText().trim();
            String detalle = jtfDetalle.getText().trim();
            String duracionStr = jtfDuracion.getText().trim();
            String costoStr = jtfCosto.getText().trim();
            boolean activo = jcbActivo.isSelected();

            if (nombre.isEmpty() || tipo.isEmpty() || duracionStr.isEmpty() || costoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar los campos obligatorios (Nombre, Tipo, Duracion, Costo).", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // validacion de numeros 
            String regexEntero = "^[0-9]+$";
            String regexDecimal = "^[0-9]+(\\.[0-9]+)?$";

            if (!duracionStr.matches(regexEntero)) {
                JOptionPane.showMessageDialog(this, "Duracion debe ser un numero entero (minutos).", "Error formato", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!costoStr.matches(regexDecimal)) {
                JOptionPane.showMessageDialog(this, "Costo debe ser numerico (puede tener decimales).", "Error formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duracion = Integer.parseInt(duracionStr);
            double costo = Double.parseDouble(costoStr);

            Tratamiento t = new Tratamiento();
            t.setNombre(nombre);
            t.setTipo(tipo);
            t.setDetalle(detalle);
            t.setDuracion(duracion);
            t.setCosto(costo);
            t.setActivo(activo);
            t.setProductos(new ArrayList<>());     
            TratamientoData td = new TratamientoData(conexion);
            td.guardarTratamiento(t);

            JOptionPane.showMessageDialog(this, "Tratamiento guardado correctamente.");

            // limpiar campos
            jtfCodigo.setText("");
            jtfNombre.setText("");
            jtfCodigo.setText("");
            jtfDetalle.setText("");
            jtfDuracion.setText("");
            jtfCosto.setText("");
            jcbActivo.setSelected(false);
            tratamientoActual = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                         

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                         

        try {
            String codigoStr = jtfCodigo.getText().trim();
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingresa el codigo del tratamiento para buscar.", "Campo vacio", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(codigoStr);
            TratamientoData td = new TratamientoData(conexion);
            Tratamiento t = td.buscarTratamiento(codigo);

            if (t != null) {
                tratamientoActual = t;
                jtfNombre.setText(t.getNombre());
                jtfCodigo.setText(t.getTipo());
                jtfDetalle.setText(t.getDetalle());
                jtfDuracion.setText(String.valueOf(t.getDuracion()));
                jtfCosto.setText(String.valueOf(t.getCosto()));
                jcbActivo.setSelected(t.isActivo());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro tratamiento con ese codigo.", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Codigo invalido. Debe ser un numero entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al buscar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            if (tratamientoActual == null) {
                JOptionPane.showMessageDialog(this, "Primero busca un tratamiento para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nombre = jtfNombre.getText().trim();
            String tipo = jtfCodigo.getText().trim();
            String detalle = jtfDetalle.getText().trim();
            String duracionStr = jtfDuracion.getText().trim();
            String costoStr = jtfCosto.getText().trim();
            boolean activo = jcbActivo.isSelected();

            if (nombre.isEmpty() || tipo.isEmpty() || duracionStr.isEmpty() || costoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar los campos obligatorios (Nombre, Tipo, Duración, Costo).", "Campos vacios", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String regexEntero = "^[0-9]+$";
            String regexDecimal = "^[0-9]+(\\.[0-9]+)?$";

            if (!duracionStr.matches(regexEntero)) {
                JOptionPane.showMessageDialog(this, "Duracion debe ser un numero entero (minutos).", "Error formato", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!costoStr.matches(regexDecimal)) {
                JOptionPane.showMessageDialog(this, "Costo debe ser numerico (puede tener decimales).", "Error formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duracion = Integer.parseInt(duracionStr);
            double costo = Double.parseDouble(costoStr);

            // actualizar objeto
            tratamientoActual.setNombre(nombre);
            tratamientoActual.setTipo(tipo);
            tratamientoActual.setDetalle(detalle);
            tratamientoActual.setDuracion(duracion);
            tratamientoActual.setCosto(costo);
            tratamientoActual.setActivo(activo);
            if (tratamientoActual.getProductos() == null) {
                tratamientoActual.setProductos(new ArrayList<>());  
            }

            TratamientoData td = new TratamientoData(conexion);
            td.actualizarTratamiento(tratamientoActual);

            JOptionPane.showMessageDialog(this, "Tratamiento actualizado correctamente.");

            // limpiar
            jtfCodigo.setText("");
            jtfNombre.setText("");
            jtfCodigo.setText("");
            jtfDetalle.setText("");
            jtfDuracion.setText("");
            jtfCosto.setText("");
            jcbActivo.setSelected(false);
            tratamientoActual = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error al intentar modificar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                           

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            if (tratamientoActual == null) {
                JOptionPane.showMessageDialog(this, "Primero busca un tratamiento para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que queres dar de baja este tratamiento?", "Confirmar baja", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                TratamientoData td = new TratamientoData(conexion);
                td.bajaLogicaTratamiento(tratamientoActual);
                JOptionPane.showMessageDialog(this, "Tratamiento dado de baja correctamente.");

                jtfCodigo.setText("");
                jtfNombre.setText("");
                jtfCodigo.setText("");
                jtfDetalle.setText("");
                jtfDuracion.setText("");
                jtfCosto.setText("");
                jcbActivo.setSelected(false);
                tratamientoActual = null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        jtfCodigo.setText("");
        jtfNombre.setText("");
        jtfCodigo.setText("");
        jtfDetalle.setText("");
        jtfDuracion.setText("");
        jtfCosto.setText("");
        jcbActivo.setSelected(false);
        tratamientoActual = null;
    }                                       


    
    
    
    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDuracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JLabel jCodigoTratamiento;
    private javax.swing.JLabel jCosto;
    private javax.swing.JLabel jDescripcion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jDuracion;
    private javax.swing.JLabel jGestionDeTratamientos;
    private javax.swing.JLabel jNombre;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCosto;
    private javax.swing.JTextField jtfDetalle;
    private javax.swing.JTextField jtfDuracion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
