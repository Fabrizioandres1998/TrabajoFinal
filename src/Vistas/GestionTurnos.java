/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Consultorio;
import Modelo.DiaDeSpa;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Sesion_turno;
import Modelo.Tratamiento;
import Persistencia.Conexion;
import Persistencia.ConsultorioData;
import Persistencia.DiaDeSpaData;
import Persistencia.InstalacionData;
import Persistencia.MasajistaData;
import Persistencia.TratamientoData;
import Persistencia.TurnoData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GestionTurnos extends javax.swing.JInternalFrame {

    private Conexion conexion;

    public GestionTurnos(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        cargarCombos();
        cargarTurnosActivos();
    }

    private void cargarCombos() {
        // llama a los metodos para cargar todos los combos de la interfaz
        cargarComboTratamientos();
        cargarComboConsultorios();
        cargarComboMasajistas();
        cargarComboInstalaciones();
        cargarComboDiasDeSpa();
    }

    private void cargarComboTratamientos() {
        try {
            // obtiene los tratamientos activos desde la base de datos
            TratamientoData td = new TratamientoData(conexion);
            List<Tratamiento> tratamientos = td.listarTratamientosActivos();
            jcbTratamiento.removeAllItems();
            jcbTratamiento.addItem(null); // agrega opcion vacia
            for (Tratamiento t : tratamientos) {
                jcbTratamiento.addItem(t);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tratamientos: " + e.getMessage());
        }
    }

    public void centrarEnDesktop(javax.swing.JDesktopPane desktopPane) {
        int x = (desktopPane.getWidth() - this.getWidth()) / 2;
        int y = (desktopPane.getHeight() - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    private void cargarTurnosActivos() {
        try {
            TurnoData td = new TurnoData(conexion);
            List<Sesion_turno> turnos = td.listarTurnosActivos();
            jcbTurnosActivos.removeAllItems();
            jcbTurnosActivos.addItem(null); // opción vacía
            for (Sesion_turno t : turnos) {
                jcbTurnosActivos.addItem(t);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar turnos activos: " + e.getMessage());
        }
    }

    private void actualizarValorTurno() {
        Tratamiento tratamiento = (Tratamiento) jcbTratamiento.getSelectedItem();
        Instalacion instalacion = (Instalacion) jcbInstalacion.getSelectedItem();

        double total = 0;

        if (tratamiento != null) {
            total += tratamiento.getCosto();
        }

        if (instalacion != null) {
            total += instalacion.getPrecio30m(); // suma el precio de la instalacion
        }

        jtfValor.setText(String.valueOf(total));
    }

    private void cargarComboConsultorios() {
        try {
            // obtiene consultorios aptos desde la base de datos
            ConsultorioData cd = new ConsultorioData(conexion);
            List<Consultorio> consultorios = cd.listarConsultoriosAptos();
            jcbConsultorio.removeAllItems();
            jcbConsultorio.addItem(null); // agrega opcion vacia
            for (Consultorio c : consultorios) {
                jcbConsultorio.addItem(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar consultorios: " + e.getMessage());
        }
    }

    private void cargarComboMasajistas() {
        try {
            // obtiene masajistas activos desde la base de datos
            MasajistaData md = new MasajistaData(conexion);
            List<Masajista> masajistas = md.listarMasajistasActivos();
            jcbMasajista.removeAllItems();
            jcbMasajista.addItem(null); // agrega opcion vacia
            for (Masajista m : masajistas) {
                jcbMasajista.addItem(m);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar masajistas: " + e.getMessage());
        }
    }

    private void cargarComboInstalaciones() {
        try {
            // obtiene instalaciones desde la base de datos
            InstalacionData id = new InstalacionData(conexion);
            List<Instalacion> instalaciones = id.listarInstalaciones();
            jcbInstalacion.removeAllItems();
            jcbInstalacion.addItem(null); // agrega opcion vacia
            for (Instalacion i : instalaciones) {
                jcbInstalacion.addItem(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar instalaciones: " + e.getMessage());
        }
    }

    private void cargarComboDiasDeSpa() {
        try {
            // obtiene dias de spa activos desde la base de datos
            DiaDeSpaData dd = new DiaDeSpaData(conexion);
            List<DiaDeSpa> dias = dd.listarDiasDeSpaActivos();
            jcbDiaDeSpa.removeAllItems();
            jcbDiaDeSpa.addItem(null); // agrega opcion vacia
            for (DiaDeSpa d : dias) {
                jcbDiaDeSpa.addItem(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar dias de spa: " + e.getMessage());
        }
    }

    Sesion_turno turnoActual = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jGestionTurnos = new javax.swing.JLabel();
        jCodigoTurno = new javax.swing.JLabel();
        jCliente = new javax.swing.JLabel();
        jMasajista = new javax.swing.JLabel();
        jFecha = new javax.swing.JLabel();
        jHora = new javax.swing.JLabel();
        jEstado = new javax.swing.JLabel();
        jcbActivo = new javax.swing.JCheckBox();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jtfCodigoTurno = new javax.swing.JTextField();
        jcbMasajista = new javax.swing.JComboBox<>();
        jEstado1 = new javax.swing.JLabel();
        jcbInstalacion = new javax.swing.JComboBox<>();
        jEstado2 = new javax.swing.JLabel();
        jcbDiaDeSpa = new javax.swing.JComboBox<>();
        jtfFechaHoraInicio = new javax.swing.JTextField();
        jtfValor = new javax.swing.JTextField();
        jcbTratamiento = new javax.swing.JComboBox<>();
        jcbConsultorio = new javax.swing.JComboBox<>();
        jEstado3 = new javax.swing.JLabel();
        jtfFechaHoraFin1 = new javax.swing.JTextField();
        jEstado4 = new javax.swing.JLabel();
        jcbTurnosActivos = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));

        jGestionTurnos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestionTurnos.setForeground(new java.awt.Color(102, 0, 153));
        jGestionTurnos.setText("Gestion Turnos");

        jCodigoTurno.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCodigoTurno.setText("Codigo turno :");

        jCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCliente.setText("Fecha y hora inicio :   ");

        jMasajista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMasajista.setText("Fecha y hora fin :  ");

        jFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jFecha.setText("Tratamiento:");

        jHora.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jHora.setText("Consultorio :    ");

        jEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jEstado.setText("Masajista :        ");

        jcbActivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcbActivo.setText("Activo");
        jcbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbActivoActionPerformed(evt);
            }
        });

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
        jbGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
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
        jbEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
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

        jEstado1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jEstado1.setText("Instalacion:");

        jcbInstalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInstalacionActionPerformed(evt);
            }
        });

        jEstado2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jEstado2.setText("Dia de spa:");

        jcbDiaDeSpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDiaDeSpaActionPerformed(evt);
            }
        });

        jcbTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTratamientoActionPerformed(evt);
            }
        });

        jcbConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbConsultorioActionPerformed(evt);
            }
        });

        jEstado3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jEstado3.setText("Valor:");

        jEstado4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jEstado4.setText("Turnos activos");

        jcbTurnosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTurnosActivosActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jGestionTurnos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCodigoTurno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jMasajista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jHora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCodigoTurno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbMasajista, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jEstado1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbInstalacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jEstado2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbDiaDeSpa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfFechaHoraInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfValor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTratamiento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbConsultorio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jEstado3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfFechaHoraFin1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jEstado4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jcbTurnosActivos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jEstado4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addComponent(jGestionTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(jcbActivo)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCliente)
                                    .addComponent(jMasajista)
                                    .addComponent(jCodigoTurno)
                                    .addComponent(jFecha)
                                    .addComponent(jHora)
                                    .addComponent(jEstado)
                                    .addComponent(jEstado1)
                                    .addComponent(jEstado2)
                                    .addComponent(jEstado3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jtfFechaHoraFin1)
                                        .addGap(55, 55, 55))
                                    .addComponent(jcbTratamiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbConsultorio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jcbMasajista, 0, 203, Short.MAX_VALUE)
                                                .addComponent(jtfCodigoTurno)
                                                .addComponent(jcbInstalacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jcbDiaDeSpa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfFechaHoraInicio))
                                            .addComponent(jcbTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGestionTurnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCodigoTurno)
                            .addComponent(jtfCodigoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCliente)
                        .addComponent(jtfFechaHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMasajista)
                    .addComponent(jtfFechaHoraFin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFecha)
                    .addComponent(jcbTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHora)
                    .addComponent(jcbConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstado)
                    .addComponent(jcbMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstado1)
                    .addComponent(jcbInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbDiaDeSpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEstado2))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstado3)
                    .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEstado4)
                    .addComponent(jcbTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jcbActivo)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void jcbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbActivoActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // limpia todos los campos de la interfaz y resetea turnoActual
        jtfCodigoTurno.setText("");
        jtfFechaHoraInicio.setText("");
        jtfFechaHoraFin1.setText("");
        jtfValor.setText("");
        jcbTratamiento.setSelectedIndex(-1);
        jcbConsultorio.setSelectedIndex(-1);
        jcbMasajista.setSelectedIndex(-1);
        jcbInstalacion.setSelectedIndex(-1);
        jcbDiaDeSpa.setSelectedIndex(-1);
        jcbActivo.setSelected(false);
        turnoActual = null;
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            // valida que todos los campos obligatorios esten completos
            if (jtfFechaHoraInicio.getText().isEmpty() || jtfValor.getText().isEmpty()
                    || jcbTratamiento.getSelectedIndex() == -1 || jcbConsultorio.getSelectedIndex() == -1
                    || jcbMasajista.getSelectedIndex() == -1 || jcbDiaDeSpa.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "debes completar todos los campos", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // expresion regular para validar formato de fecha y hora
            String regexFechaHora = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$";

            // valida formato de fecha y hora inicio
            if (!jtfFechaHoraInicio.getText().matches(regexFechaHora)) {
                JOptionPane.showMessageDialog(this, "formato de fecha y hora inicio invalido. usa: aaaa-mm-dd hh:mm", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida formato de fecha y hora fin
            if (!jtfFechaHoraFin1.getText().matches(regexFechaHora)) {
                JOptionPane.showMessageDialog(this, "formato de fecha y hora fin invalido. usa: aaaa-mm-dd hh:mm", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // parsea fechas
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime fechaInicio = LocalDateTime.parse(jtfFechaHoraInicio.getText(), dtf);
            LocalDateTime fechaFin = LocalDateTime.parse(jtfFechaHoraFin1.getText(), dtf);

            // obtiene objetos seleccionados
            Tratamiento tratamiento = (Tratamiento) jcbTratamiento.getSelectedItem();
            Consultorio consultorio = (Consultorio) jcbConsultorio.getSelectedItem();
            Masajista masajista = (Masajista) jcbMasajista.getSelectedItem();
            DiaDeSpa diaDeSpa = (DiaDeSpa) jcbDiaDeSpa.getSelectedItem();
            Instalacion instalacion = (Instalacion) jcbInstalacion.getSelectedItem();
            List<Instalacion> instalaciones = new ArrayList<>();
            instalaciones.add(instalacion);
            boolean estado = jcbActivo.isSelected();

            // crea el turno con los datos ingresados
            Sesion_turno turno = new Sesion_turno(fechaInicio, fechaFin, tratamiento, consultorio, masajista, instalaciones, diaDeSpa, estado);

            // guarda el turno en la base de datos
            TurnoData td = new TurnoData(conexion);
            td.guardarTurno(turno);

            // calcula y actualiza el monto del dia de spa
            DiaDeSpaData dd = new DiaDeSpaData(conexion);
            double valorFinal = 0;
            if (tratamiento != null) {
                valorFinal += tratamiento.getCosto();
            }
            if (instalacion != null) {
                valorFinal += instalacion.getPrecio30m();
            }
            diaDeSpa.setMonto(valorFinal);
            dd.actualizarDiaDeSpa(diaDeSpa);

            // muestra mensaje de exito
            JOptionPane.showMessageDialog(this, "turno guardado correctamente");
            jbNuevoActionPerformed(evt);
            cargarTurnosActivos();
        } catch (Exception e) {
            // captura cualquier error al guardar
            JOptionPane.showMessageDialog(this, "error al guardar turno: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jcbConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbConsultorioActionPerformed

    private void jcbInstalacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInstalacionActionPerformed
        actualizarValorTurno();
    }//GEN-LAST:event_jcbInstalacionActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        try {
            // valida que haya un turno cargado
            if (turnoActual == null) {
                JOptionPane.showMessageDialog(this, "debes buscar un turno antes de modificarlo", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida que todos los campos obligatorios esten completos
            if (jtfFechaHoraInicio.getText().isEmpty() || jtfValor.getText().isEmpty()
                    || jcbTratamiento.getSelectedIndex() == -1 || jcbConsultorio.getSelectedIndex() == -1
                    || jcbMasajista.getSelectedIndex() == -1 || jcbDiaDeSpa.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "debes completar todos los campos", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // expresion regular para validar formato de fecha y hora
            String regexFechaHora = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}$";

            // valida formato de fecha inicio y fin
            if (!jtfFechaHoraInicio.getText().matches(regexFechaHora)) {
                JOptionPane.showMessageDialog(this, "formato de fecha y hora inicio invalido. usa: aaaa-mm-dd hh:mm", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!jtfFechaHoraFin1.getText().matches(regexFechaHora)) {
                JOptionPane.showMessageDialog(this, "formato de fecha y hora fin invalido. usa: aaaa-mm-dd hh:mm", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // parsea fechas
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime fechaInicio = LocalDateTime.parse(jtfFechaHoraInicio.getText(), dtf);
            LocalDateTime fechaFin = LocalDateTime.parse(jtfFechaHoraFin1.getText(), dtf);

            // obtiene objetos seleccionados
            Tratamiento tratamientoNuevo = (Tratamiento) jcbTratamiento.getSelectedItem();
            Consultorio consultorio = (Consultorio) jcbConsultorio.getSelectedItem();
            Masajista masajista = (Masajista) jcbMasajista.getSelectedItem();
            DiaDeSpa diaDeSpa = (DiaDeSpa) jcbDiaDeSpa.getSelectedItem();
            Instalacion instalacion = (Instalacion) jcbInstalacion.getSelectedItem();
            List<Instalacion> instalaciones = new ArrayList<>();
            instalaciones.add(instalacion);
            boolean estado = jcbActivo.isSelected();

            // actualiza los datos del turno existente
            turnoActual.setFechaHoraInicio(fechaInicio);
            turnoActual.setFechaHoraFin(fechaFin);
            turnoActual.setTratamiento(tratamientoNuevo);
            turnoActual.setConsultorio(consultorio);
            turnoActual.setMasajista(masajista);
            turnoActual.setDiaDeSpa(diaDeSpa);
            turnoActual.setInstalaciones(instalaciones);
            turnoActual.setEstado(estado);

            // guarda cambios en la base de datos
            TurnoData td = new TurnoData(conexion);
            td.actualizarTurno(turnoActual);

            // recalcula y actualiza el monto del dia de spa
            DiaDeSpaData dd = new DiaDeSpaData(conexion);
            double valorFinal = 0;
            if (tratamientoNuevo != null) {
                valorFinal += tratamientoNuevo.getCosto();
            }
            if (instalacion != null) {
                valorFinal += instalacion.getPrecio30m();
            }
            diaDeSpa.setMonto(valorFinal);
            dd.actualizarDiaDeSpa(diaDeSpa);

            // muestra mensaje de exito
            JOptionPane.showMessageDialog(this, "turno modificado correctamente");
            jbNuevoActionPerformed(evt);
            cargarTurnosActivos();
        } catch (Exception e) {
            // captura cualquier error al modificar
            JOptionPane.showMessageDialog(this, "error al modificar turno: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            // valida que haya un turno cargado
            if (turnoActual == null) {
                JOptionPane.showMessageDialog(this, "Debes buscar un turno antes de eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // solicita confirmacion al usuario antes de eliminar
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Seguro que deseas eliminar este turno?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            // elimina turno de la base de datos
            TurnoData td = new TurnoData(conexion);
            td.eliminarTurno(turnoActual.getCodSesion());

            JOptionPane.showMessageDialog(this, "Turno eliminado correctamente");
            jbNuevoActionPerformed(evt); // limpia campos
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            String codigoStr = jtfCodigoTurno.getText().trim();
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes ingresar el codigo del turno", "Buscar", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codTurno = Integer.parseInt(codigoStr);

            TurnoData td = new TurnoData(conexion);
            turnoActual = td.buscarTurno(codTurno);

            if (turnoActual == null) {
                JOptionPane.showMessageDialog(this, "No se encontro el turno con el codigo: " + codTurno, "Buscar", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            // FECHAS
            jtfFechaHoraInicio.setText(turnoActual.getFechaHoraInicio().format(dtf));
            jtfFechaHoraFin1.setText(turnoActual.getFechaHoraFin().format(dtf));

            // VALOR DEL TRATAMIENTO
            jtfValor.setText(String.valueOf(turnoActual.getTratamiento().getCosto()));

            // ESTADO
            jcbActivo.setSelected(turnoActual.isEstado());

            // TRATAMIENTO
            Tratamiento tratamiento = turnoActual.getTratamiento();
            for (int i = 0; i < jcbTratamiento.getItemCount(); i++) {
                Object item = jcbTratamiento.getItemAt(i);
                if (item instanceof Tratamiento && ((Tratamiento) item).getCodTratam() == tratamiento.getCodTratam()) {
                    jcbTratamiento.setSelectedIndex(i);
                    break;
                }
            }

            // MASAJISTA
            Masajista masajista = turnoActual.getMasajista();
            for (int i = 0; i < jcbMasajista.getItemCount(); i++) {
                Object item = jcbMasajista.getItemAt(i);
                if (item instanceof Masajista) {
                    Masajista m = (Masajista) item;
                    if (String.valueOf(m.getMatricula()).equals(String.valueOf(masajista.getMatricula()))) {
                        jcbMasajista.setSelectedIndex(i);
                        break;
                    }
                }
            }

            // INSTALACION
            if (!turnoActual.getInstalaciones().isEmpty()) {
                Instalacion instalacion = turnoActual.getInstalaciones().get(0);
                for (int i = 0; i < jcbInstalacion.getItemCount(); i++) {
                    Object item = jcbInstalacion.getItemAt(i);
                    if (item instanceof Instalacion && ((Instalacion) item).getCodInstal() == instalacion.getCodInstal()) {
                        jcbInstalacion.setSelectedIndex(i);
                        break;
                    }
                }
            }

            // CONSULTORIO
            Consultorio consultorio = turnoActual.getConsultorio();
            for (int i = 0; i < jcbConsultorio.getItemCount(); i++) {
                Object item = jcbConsultorio.getItemAt(i);
                if (item instanceof Consultorio && ((Consultorio) item).getNroConsultorio() == consultorio.getNroConsultorio()) {
                    jcbConsultorio.setSelectedIndex(i);
                    break;
                }
            }

            // DIA DE SPA
            DiaDeSpa diaDeSpa = turnoActual.getDiaDeSpa();
            for (int i = 0; i < jcbDiaDeSpa.getItemCount(); i++) {
                Object item = jcbDiaDeSpa.getItemAt(i);
                if (item instanceof DiaDeSpa && ((DiaDeSpa) item).getCodPack() == diaDeSpa.getCodPack()) {
                    jcbDiaDeSpa.setSelectedIndex(i);
                    break;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El codigo del turno debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar turno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcbTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTratamientoActionPerformed
        actualizarValorTurno();
    }//GEN-LAST:event_jcbTratamientoActionPerformed

    private void jcbTurnosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTurnosActivosActionPerformed
        Sesion_turno turnoSeleccionado = (Sesion_turno) jcbTurnosActivos.getSelectedItem();
        if (turnoSeleccionado != null) {
            turnoActual = turnoSeleccionado;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            jtfCodigoTurno.setText(String.valueOf(turnoActual.getCodSesion()));
            jtfFechaHoraInicio.setText(turnoActual.getFechaHoraInicio().format(dtf));
            jtfFechaHoraFin1.setText(turnoActual.getFechaHoraFin().format(dtf));
            jtfValor.setText(String.valueOf(turnoActual.getTratamiento().getCosto()));
            jcbActivo.setSelected(turnoActual.isEstado());

            // Selección de tratamiento
            for (int i = 0; i < jcbTratamiento.getItemCount(); i++) {
                Object item = jcbTratamiento.getItemAt(i);
                if (item instanceof Tratamiento && ((Tratamiento) item).getCodTratam() == turnoActual.getTratamiento().getCodTratam()) {
                    jcbTratamiento.setSelectedIndex(i);
                    break;
                }
            }

            // Selección de masajista
            for (int i = 0; i < jcbMasajista.getItemCount(); i++) {
                Object item = jcbMasajista.getItemAt(i);
                if (item instanceof Masajista && ((Masajista) item).getMatricula().equals(turnoActual.getMasajista().getMatricula())) {
                    jcbMasajista.setSelectedIndex(i);
                    break;
                }
            }

            // Instalación
            if (!turnoActual.getInstalaciones().isEmpty()) {
                Instalacion instalacion = turnoActual.getInstalaciones().get(0);
                for (int i = 0; i < jcbInstalacion.getItemCount(); i++) {
                    Object item = jcbInstalacion.getItemAt(i);
                    if (item instanceof Instalacion && ((Instalacion) item).getCodInstal() == instalacion.getCodInstal()) {
                        jcbInstalacion.setSelectedIndex(i);
                        break;
                    }
                }
            }

            // Consultorio
            for (int i = 0; i < jcbConsultorio.getItemCount(); i++) {
                Object item = jcbConsultorio.getItemAt(i);
                if (item instanceof Consultorio && ((Consultorio) item).getNroConsultorio() == turnoActual.getConsultorio().getNroConsultorio()) {
                    jcbConsultorio.setSelectedIndex(i);
                    break;
                }
            }

            // Día de spa
            for (int i = 0; i < jcbDiaDeSpa.getItemCount(); i++) {
                Object item = jcbDiaDeSpa.getItemAt(i);
                if (item instanceof DiaDeSpa && ((DiaDeSpa) item).getCodPack() == turnoActual.getDiaDeSpa().getCodPack()) {
                    jcbDiaDeSpa.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jcbTurnosActivosActionPerformed

    private void jcbDiaDeSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDiaDeSpaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDiaDeSpaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jCliente;
    private javax.swing.JLabel jCodigoTurno;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jEstado1;
    private javax.swing.JLabel jEstado2;
    private javax.swing.JLabel jEstado3;
    private javax.swing.JLabel jEstado4;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jGestionTurnos;
    private javax.swing.JLabel jHora;
    private javax.swing.JLabel jMasajista;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JComboBox<Consultorio> jcbConsultorio;
    private javax.swing.JComboBox<DiaDeSpa> jcbDiaDeSpa;
    private javax.swing.JComboBox<Instalacion> jcbInstalacion;
    private javax.swing.JComboBox<Masajista> jcbMasajista;
    private javax.swing.JComboBox<Tratamiento> jcbTratamiento;
    private javax.swing.JComboBox<Sesion_turno> jcbTurnosActivos;
    private javax.swing.JTextField jtfCodigoTurno;
    private javax.swing.JTextField jtfFechaHoraFin1;
    private javax.swing.JTextField jtfFechaHoraInicio;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables
}
