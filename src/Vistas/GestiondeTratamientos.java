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

    public GestiondeTratamientos(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        cargarTiposTratamiento();
        cargarTratamientosActivos();
        jbNuevoActionPerformed(null);
    }

    private void cargarTratamientosActivos() {
        try {
            TratamientoData td = new TratamientoData(conexion);
            List<Tratamiento> tratamientos = td.listarTratamientosActivos();

            jcbTratamientosActivos.removeAllItems();

            for (Tratamiento t : tratamientos) {
                jcbTratamientosActivos.addItem(t);
            }

            jcbTratamientosActivos.setSelectedIndex(-1); // sin selección inicial
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tratamientos activos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void cargarTiposTratamiento() {
        jcbTipo.removeAllItems();
        jcbTipo.addItem("Facial");
        jcbTipo.addItem("Corporal");
        jcbTipo.addItem("Masajes");
        jcbTipo.addItem("Estetico");
        jcbTipo.addItem("Relajacion");
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
        jtfDuracion = new javax.swing.JTextField();
        jtfCosto = new javax.swing.JTextField();
        jcbActivo = new javax.swing.JCheckBox();
        jBnuevo = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBbuscar = new javax.swing.JButton();
        jDescripcion1 = new javax.swing.JLabel();
        jtfDetalle = new javax.swing.JTextField();
        jcbTipo = new javax.swing.JComboBox<>();
        jCosto1 = new javax.swing.JLabel();
        jcbTratamientosActivos = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jGestionDeTratamientos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestionDeTratamientos.setForeground(new java.awt.Color(153, 0, 153));
        jGestionDeTratamientos.setText("Gestion de Tratamientos");

        jCodigoTratamiento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCodigoTratamiento.setText("Codigo tratamiento :");

        jNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jNombre.setText("Nombre : ");

        jDescripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jDescripcion.setText("Tipo:");

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
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });

        jBguardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBguardar.setText("Guardar ");
        jBguardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 153)));
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jBmodificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBmodificar.setText("Modificar");
        jBmodificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });

        jBbuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 153)));
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jDescripcion1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jDescripcion1.setText("Detalle:");

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoActionPerformed(evt);
            }
        });

        jCosto1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCosto1.setText("Tratamientos activos");

        jcbTratamientosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTratamientosActivosActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jGestionDeTratamientos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCodigoTratamiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDuracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDuracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCosto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBnuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBguardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBmodificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jBbuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDescripcion1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfDetalle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCosto1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTratamientosActivos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jcbActivo))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jGestionDeTratamientos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodigoTratamiento)
                                    .addComponent(jNombre)
                                    .addComponent(jDescripcion)
                                    .addComponent(jDuracion)
                                    .addComponent(jCosto))
                                .addGap(60, 60, 60)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTratamientosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(jtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(jtfCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(jtfDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(jcbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jCosto1))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jDescripcion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
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
                    .addComponent(jDescripcion)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescripcion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDuracion))
                .addGap(27, 27, 27)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCosto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbActivo)
                .addGap(11, 11, 11)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCosto1)
                    .addComponent(jcbTratamientosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
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
            String tipo = (String) jcbTipo.getSelectedItem();
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
            jcbTipo.setSelectedIndex(-1);
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
                jcbTipo.setSelectedItem(t.getTipo());
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
            String tipo = (String) jcbTipo.getSelectedItem();
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
            jcbTipo.setSelectedIndex(-1);
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
                jcbTipo.setSelectedIndex(-1);
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
        jtfDetalle.setText("");
        jtfCodigo.setText("");
        jtfNombre.setText("");
        jtfCodigo.setText("");
        jcbTipo.setSelectedIndex(-1);
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

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        try {
            String nombre = jtfNombre.getText().trim();
            String tipo = (String) jcbTipo.getSelectedItem();
            String detalle = jtfDetalle.getText().trim();
            String duracionStr = jtfDuracion.getText().trim();
            String costoStr = jtfCosto.getText().trim();
            boolean activo = jcbActivo.isSelected();

            if (nombre.isEmpty() || tipo.isEmpty() || duracionStr.isEmpty() || costoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar los campos obligatorios (Nombre, Tipo, Duración, Costo).", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String regexEntero = "^[0-9]+$";
            String regexDecimal = "^[0-9]+(\\.[0-9]+)?$";

            if (!duracionStr.matches(regexEntero)) {
                JOptionPane.showMessageDialog(this, "Duración debe ser un número entero (en minutos).", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!costoStr.matches(regexDecimal)) {
                JOptionPane.showMessageDialog(this, "Costo debe ser numérico (puede tener decimales).", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int duracion = Integer.parseInt(duracionStr);
            double costo = Double.parseDouble(costoStr);

            TratamientoData td = new TratamientoData(conexion);

            if (tratamientoActual == null) {
                Tratamiento t = new Tratamiento();
                t.setNombre(nombre);
                t.setTipo(tipo);
                t.setDetalle(detalle);
                t.setDuracion(duracion);
                t.setCosto(costo);
                t.setActivo(activo);
                t.setProductos(new ArrayList<>());
                td.guardarTratamiento(t);
                JOptionPane.showMessageDialog(this, "Tratamiento guardado correctamente.");
            } else {
                tratamientoActual.setNombre(nombre);
                tratamientoActual.setTipo(tipo);
                tratamientoActual.setDetalle(detalle);
                tratamientoActual.setDuracion(duracion);
                tratamientoActual.setCosto(costo);
                tratamientoActual.setActivo(activo);
                td.actualizarTratamiento(tratamientoActual);
                JOptionPane.showMessageDialog(this, "Tratamiento actualizado correctamente.");
            }

            jBnuevoActionPerformed(evt);
            cargarTratamientosActivos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
        jtfCodigo.setText("");
        jtfNombre.setText("");
        jcbTipo.setSelectedIndex(-1);
        jtfDetalle.setText("");
        jtfDuracion.setText("");
        jtfCosto.setText("");
        jcbActivo.setSelected(false);
        tratamientoActual = null;
    }//GEN-LAST:event_jBnuevoActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        try {
            int codigo = Integer.parseInt(jtfCodigo.getText().trim());
            TratamientoData td = new TratamientoData(conexion);
            tratamientoActual = td.buscarTratamiento(codigo);

            if (tratamientoActual != null) {
                jtfNombre.setText(tratamientoActual.getNombre());
                jcbTipo.setSelectedItem(tratamientoActual.getTipo());
                jtfDetalle.setText(tratamientoActual.getDetalle());
                jtfDuracion.setText(String.valueOf(tratamientoActual.getDuracion()));
                jtfCosto.setText(String.valueOf(tratamientoActual.getCosto()));
                jcbActivo.setSelected(tratamientoActual.isActivo());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ningún tratamiento con ese código.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el tratamiento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
        try {
            if (tratamientoActual == null) {
                JOptionPane.showMessageDialog(this, "Primero debes buscar un tratamiento", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombre = jtfNombre.getText().trim();
            String tipo = (String) jcbTipo.getSelectedItem();
            String detalle = jtfDetalle.getText().trim();
            String duracionTxt = jtfDuracion.getText().trim();
            String costoTxt = jtfCosto.getText().trim();
            boolean activo = jcbActivo.isSelected();

            if (nombre.isEmpty() || tipo == null || duracionTxt.isEmpty() || costoTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar todos los campos obligatorios", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int duracion = Integer.parseInt(duracionTxt);
            double costo = Double.parseDouble(costoTxt);

            tratamientoActual.setNombre(nombre);
            tratamientoActual.setTipo(tipo);
            tratamientoActual.setDetalle(detalle);
            tratamientoActual.setDuracion(duracion);
            tratamientoActual.setCosto(costo);
            tratamientoActual.setActivo(activo);

            TratamientoData td = new TratamientoData(conexion);
            td.actualizarTratamiento(tratamientoActual);

            JOptionPane.showMessageDialog(this, "Tratamiento modificado correctamente.");
            cargarTratamientosActivos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Duración y costo deben ser numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el tratamiento: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBmodificarActionPerformed

    private void jcbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoActionPerformed

    private void jcbTratamientosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTratamientosActivosActionPerformed
        Tratamiento seleccionado = (Tratamiento) jcbTratamientosActivos.getSelectedItem();
        if (seleccionado != null) {
            jtfCodigo.setText(String.valueOf(seleccionado.getCodTratam()));
            jtfNombre.setText(seleccionado.getNombre());
            jcbTipo.setSelectedItem(seleccionado.getTipo());
            jtfDetalle.setText(seleccionado.getDetalle());
            jtfDuracion.setText(String.valueOf(seleccionado.getDuracion()));
            jtfCosto.setText(String.valueOf(seleccionado.getCosto()));
            jcbActivo.setSelected(seleccionado.isActivo());
            tratamientoActual = seleccionado;
        }
    }//GEN-LAST:event_jcbTratamientosActivosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JLabel jCodigoTratamiento;
    private javax.swing.JLabel jCosto;
    private javax.swing.JLabel jCosto1;
    private javax.swing.JLabel jDescripcion;
    private javax.swing.JLabel jDescripcion1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jDuracion;
    private javax.swing.JLabel jGestionDeTratamientos;
    private javax.swing.JLabel jNombre;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JComboBox<Tratamiento> jcbTratamientosActivos;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCosto;
    private javax.swing.JTextField jtfDetalle;
    private javax.swing.JTextField jtfDuracion;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
