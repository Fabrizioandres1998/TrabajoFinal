package Vistas;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Modelo.Masajista;
import Modelo.Producto;
import Modelo.Sesion_turno;
import Modelo.Tratamiento;
import Persistencia.Conexion;
import Persistencia.DiaDeSpaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Persistencia.ClienteData;
import Persistencia.MasajistaData;
import Persistencia.TratamientoData;
import Persistencia.TurnoData;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class GestionDiaDeSpa extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private DiaDeSpa diaActual = null;

    public GestionDiaDeSpa(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        cargarCombos();
        jtfMonto.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jGestiondeDiasdeSpa = new javax.swing.JLabel();
        jCodigoDiadeSpa = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        jCliente = new javax.swing.JLabel();
        jMasajista = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfFecha = new javax.swing.JTextField();
        jcbCliente = new javax.swing.JComboBox<>();
        jcbTurnos = new javax.swing.JComboBox<>();
        jcbActivo = new javax.swing.JCheckBox();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jMasajista1 = new javax.swing.JLabel();
        jtfPreferencias = new javax.swing.JTextField();
        jMasajista2 = new javax.swing.JLabel();
        jtfMonto = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        jGestiondeDiasdeSpa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestiondeDiasdeSpa.setForeground(new java.awt.Color(153, 0, 153));
        jGestiondeDiasdeSpa.setText("Gestion de Dias de Spa");

        jCodigoDiadeSpa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCodigoDiadeSpa.setText("Codigo dia de spa :");

        jFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jFecha.setText("Fecha y hora:    ");

        jCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCliente.setText("Cliente :   ");

        jMasajista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMasajista.setText("Turnos :   ");

        jcbActivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcbActivo.setText("Activo");

        jbNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jMasajista1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMasajista1.setText("Preferencias:");

        jMasajista2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMasajista2.setText("Monto:");

        jDesktopPane1.setLayer(jGestiondeDiasdeSpa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCodigoDiadeSpa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jMasajista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTurnos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jMasajista1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfPreferencias, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jMasajista2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfMonto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jGestiondeDiasdeSpa)
                .addGap(153, 153, 153))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFecha)
                            .addComponent(jCodigoDiadeSpa)
                            .addComponent(jCliente)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jMasajista2)
                                .addComponent(jMasajista))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jcbActivo)
                                .addGap(18, 18, 18)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMasajista1)
                        .addGap(18, 18, 18)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPreferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfFecha)
                            .addComponent(jcbCliente, 0, 160, Short.MAX_VALUE)
                            .addComponent(jtfCodigo))
                        .addComponent(jcbTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jGestiondeDiasdeSpa)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCodigoDiadeSpa)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFecha)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCliente)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMasajista)
                    .addComponent(jcbTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPreferencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMasajista1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMasajista2))
                .addGap(18, 18, 18)
                .addComponent(jcbActivo)
                .addGap(51, 51, 51)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        try {
            // verifica si hay un dia de spa cargado; si no, muestra un mensaje de error
            if (diaActual == null) {
                JOptionPane.showMessageDialog(this, "Debes buscar un Día de Spa antes de modificarlo.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // lee los datos ingresados en la interfaz
            String fechaStr = jtfFecha.getText().trim();
            Cliente cliente = (Cliente) jcbCliente.getSelectedItem();
            Sesion_turno turno = (Sesion_turno) jcbTurnos.getSelectedItem();
            boolean estado = jcbActivo.isSelected();

            // valida que los campos obligatorios no esten vacios
            if (fechaStr.isEmpty() || cliente == null || turno == null) {
                JOptionPane.showMessageDialog(this, "Debes completar todos los campos obligatorios.",
                        "Campos vacios", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // convierte la cadena de fecha a un objeto LocalDateTime usando el formato especificado
            LocalDateTime fechaHora = LocalDateTime.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            // crea una lista de sesiones, en este caso solo contiene la seleccionada
            List<Sesion_turno> sesiones = new ArrayList<>();
            sesiones.add(turno);

            // actualiza los datos del diaActual con los nuevos valores
            diaActual.setFechaYHora(fechaHora);
            diaActual.setPreferencias(jtfPreferencias.getText());
            diaActual.setCliente(cliente);
            diaActual.setEstado(estado);
            diaActual.setSesiones(sesiones);

            // calcula el monto total sumando el costo del tratamiento y de los productos asociados
            double montoTotal = 0;
            for (Sesion_turno s : sesiones) {
                double costoTratamiento = s.getTratamiento().getCosto();

                List<Producto> productos = s.getTratamiento().getProductos();
                double costoProductos = 0;
                if (productos != null) {
                    for (Producto p : productos) {
                        costoProductos += p.getPrecio();
                    }
                }

                montoTotal += costoTratamiento + costoProductos;
            }
            diaActual.setMonto(montoTotal);

            // guarda los cambios en la base de datos
            DiaDeSpaData diaData = new DiaDeSpaData(conexion);
            diaData.actualizarDiaDeSpa(diaActual);

            // actualiza el turno para asociarlo al dia de spa modificado
            turno.setDiaDeSpa(diaActual);
            TurnoData turnoData = new TurnoData(conexion);
            turnoData.actualizarTurno(turno);

            // muestra el monto actualizado en la interfaz
            jtfMonto.setText(String.valueOf(montoTotal));

            // notifica que la modificacion fue exitosa y limpia los campos
            JOptionPane.showMessageDialog(this, "Día de Spa modificado correctamente.\nMonto total: $" + montoTotal,
                    "Exito", JOptionPane.INFORMATION_MESSAGE);

            jbNuevoActionPerformed(evt); // limpia campos
        } catch (DateTimeParseException e) {
            // captura errores de formato de fecha y hora
            JOptionPane.showMessageDialog(this, "Formato de fecha y hora invalido. Usa el formato: yyyy-MM-dd HH:mm",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // captura cualquier otro error y lo muestra en consola y en mensaje
            JOptionPane.showMessageDialog(this, "Error al modificar el Día de Spa: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            // lee los datos esenciales de la interfaz
            String fechaStr = jtfFecha.getText().trim();
            Cliente cliente = (Cliente) jcbCliente.getSelectedItem();
            boolean estado = jcbActivo.isSelected();

            // valida que fecha y cliente esten completos
            if (fechaStr.isEmpty() || cliente == null) {
                JOptionPane.showMessageDialog(this,
                        "Debes ingresar la fecha y seleccionar un cliente.",
                        "Campos vacios", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // parsea la fecha ingresada
            LocalDateTime fechaHora = LocalDateTime.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            // obtiene el turno seleccionado si existe
            Sesion_turno turnoSeleccionado = (Sesion_turno) jcbTurnos.getSelectedItem();
            List<Sesion_turno> sesiones = new ArrayList<>();
            if (turnoSeleccionado != null) {
                sesiones.add(turnoSeleccionado);
            }

            // crea un nuevo dia de spa con los datos ingresados
            DiaDeSpa dia = new DiaDeSpa(fechaHora, jtfPreferencias.getText(), cliente, estado, sesiones, 0);

            // calcula el monto total si hay sesiones asociadas
            double montoTotal = dia.calcularMontoTotal();
            dia.setMonto(montoTotal);

            // guarda el dia de spa en la base de datos
            DiaDeSpaData diaData = new DiaDeSpaData(conexion);
            diaData.guardarDiaDeSpa(dia);

            // si hay turno seleccionado, lo asocia al dia guardado
            if (turnoSeleccionado != null) {
                turnoSeleccionado.setDiaDeSpa(dia);
                TurnoData turnoData = new TurnoData(conexion);
                turnoData.actualizarTurno(turnoSeleccionado);
            }

            // muestra el monto total y notifica exito
            jtfMonto.setText(String.format("%.2f", montoTotal));
            JOptionPane.showMessageDialog(this,
                    "Día de spa guardado correctamente.\nCodigo: " + dia.getCodPack()
                    + "\nMonto total: $" + montoTotal,
                    "Exito", JOptionPane.INFORMATION_MESSAGE);

            jbNuevoActionPerformed(evt); // limpia campos
        } catch (DateTimeParseException e) {
            // captura errores de formato de fecha
            JOptionPane.showMessageDialog(this,
                    "Formato de fecha y hora invalido. Usa el formato: yyyy-MM-dd HH:mm",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // captura otros errores
            JOptionPane.showMessageDialog(this,
                    "Error al guardar el Día de Spa: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // limpia todos los campos de la interfaz y resetea diaActual
        jtfCodigo.setText("");
        jtfFecha.setText("");
        jtfPreferencias.setText("");
        jcbCliente.setSelectedIndex(-1);
        jcbTurnos.setSelectedIndex(-1);
        jcbActivo.setSelected(false);
        diaActual = null;
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            // verifica que haya un dia de spa cargado
            if (diaActual == null) {
                JOptionPane.showMessageDialog(this, "Debes buscar un Día de Spa antes de eliminarlo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // solicita confirmacion para eliminar
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este Día de Spa?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            // elimina el dia de spa de la base de datos
            DiaDeSpaData diaData = new DiaDeSpaData(conexion);
            diaData.bajaFisicaDiaDeSpa(diaActual.getCodPack());
            JOptionPane.showMessageDialog(this, "Día de Spa eliminado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);

            jbNuevoActionPerformed(evt); // limpia campos
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el Día de Spa: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            // obtiene el codigo ingresado y valida que no este vacio
            String codigoStr = jtfCodigo.getText().trim();
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes ingresar el codigo del Dia de Spa",
                        "Buscar", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // convierte el codigo a entero
            int codPack = Integer.parseInt(codigoStr);

            // busca el dia de spa en la base de datos
            DiaDeSpaData diaData = new DiaDeSpaData(conexion);
            DiaDeSpa dia = diaData.buscarDiaDeSpa(codPack);

            if (dia == null) {
                JOptionPane.showMessageDialog(this, "No se encontro un Dia de Spa con ese codigo.",
                        "Buscar", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // llena los campos de la interfaz con los datos del dia encontrado
            jtfFecha.setText(dia.getFechaYHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            jtfPreferencias.setText(dia.getPreferencias());
            jtfMonto.setText(String.valueOf(dia.getMonto()));
            jcbActivo.setSelected(dia.isEstado());

            // selecciona el cliente en el combo correspondiente
            Cliente cliente = dia.getCliente();
            for (int i = 0; i < jcbCliente.getItemCount(); i++) {
                if (((Cliente) jcbCliente.getItemAt(i)).getCodCli() == cliente.getCodCli()) {
                    jcbCliente.setSelectedIndex(i);
                    break;
                }
            }

            // carga solo los turnos asociados al cliente
            TurnoData turnoData = new TurnoData(conexion);
            List<Sesion_turno> turnosCliente = new ArrayList<>();
            for (Sesion_turno t : turnoData.listarTurnosActivos()) {
                if (t.getDiaDeSpa() != null && t.getDiaDeSpa().getCodPack() == dia.getCodPack()) {
                    turnosCliente.add(t);
                }
            }

            // llena el combo de turnos con los filtrados
            jcbTurnos.removeAllItems();
            for (Sesion_turno t : turnosCliente) {
                jcbTurnos.addItem(t);
            }
            jcbTurnos.setEnabled(true); // habilita combo

            // selecciona el turno asociado al dia de spa
            if (dia.getSesiones() != null && !dia.getSesiones().isEmpty()) {
                Sesion_turno turnoDia = dia.getSesiones().get(0);
                for (int i = 0; i < jcbTurnos.getItemCount(); i++) {
                    if (((Sesion_turno) jcbTurnos.getItemAt(i)).getCodSesion() == turnoDia.getCodSesion()) {
                        jcbTurnos.setSelectedIndex(i);
                        break;
                    }
                }
            }

            // asigna diaActual para permitir modificaciones posteriores
            diaActual = dia;

            JOptionPane.showMessageDialog(this, "Dia de Spa cargado correctamente.",
                    "Buscar", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            // captura errores si el codigo no es un numero
            JOptionPane.showMessageDialog(this, "El codigo debe ser un numero valido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // captura otros errores
            JOptionPane.showMessageDialog(this, "Error al buscar el Dia de Spa: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void cargarCombos() {
        try {
            // valida que la conexion no sea nula
            if (this.conexion == null) {
                JOptionPane.showMessageDialog(this, "Error: la conexion es null.", "Error conexion", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // carga los clientes activos en el combo
            ClienteData clienteData = new ClienteData(conexion);
            List<Cliente> clientes = clienteData.listarClientesActivos();
            jcbCliente.removeAllItems();
            if (clientes != null && !clientes.isEmpty()) {
                for (Cliente c : clientes) {
                    jcbCliente.addItem(c);
                }
            } else {
                System.out.println("INFO: No hay clientes activos.");
            }

            // deja el combo de turnos vacio y deshabilitado
            jcbTurnos.removeAllItems();
            jcbTurnos.setEnabled(false);

            // sin seleccion inicial en cliente
            jcbCliente.setSelectedIndex(-1);
        } catch (Exception e) {
            // captura errores al cargar clientes
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCliente;
    private javax.swing.JLabel jCodigoDiadeSpa;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jGestiondeDiasdeSpa;
    private javax.swing.JLabel jMasajista;
    private javax.swing.JLabel jMasajista1;
    private javax.swing.JLabel jMasajista2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JComboBox<Cliente> jcbCliente;
    private javax.swing.JComboBox<Sesion_turno> jcbTurnos;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfMonto;
    private javax.swing.JTextField jtfPreferencias;
    // End of variables declaration//GEN-END:variables
}
