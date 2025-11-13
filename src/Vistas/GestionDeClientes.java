package Vistas;

import Modelo.Cliente;
import Persistencia.ClienteData;
import Persistencia.Conexion;
import static Persistencia.Conexion.con;
import Vistas.MenuPrincipal;
import javax.swing.JOptionPane;

public class GestionDeClientes extends javax.swing.JInternalFrame {

    private Conexion conexion;

    public GestionDeClientes(Conexion conexion) {
        initComponents();
        this.conexion = conexion;
        cargarClientesActivos();

        jcbClientesActivos.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarClienteSeleccionado();
            }
        });
    }

    public void centrarEnDesktop(javax.swing.JDesktopPane desktopPane) {
        int x = (desktopPane.getWidth() - this.getWidth()) / 2;
        int y = (desktopPane.getHeight() - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    private void cargarClienteSeleccionado() {
        try {
            if (jcbClientesActivos.getSelectedItem() == null) {
                return;
            }

            String seleccionado = jcbClientesActivos.getSelectedItem().toString();
            String[] partes = seleccionado.split(" - ");
            int codigoCliente = Integer.parseInt(partes[0].trim());

            ClienteData cd = new ClienteData(conexion);
            Cliente c = cd.buscarCliente(codigoCliente);
            if (c != null) {
                clienteActual = c;
                jtfCodigoCliente.setText(String.valueOf(c.getCodCli()));
                jtfDni.setText(String.valueOf(c.getDni()));
                jtfNombreCompleto.setText(c.getNombreCompleto());
                jtfTelefono.setText(String.valueOf(c.getTelefono()));
                jtfEdad.setText(String.valueOf(c.getEdad()));
                jtfAfecciones.setText(c.getAfecciones());
                jcbActivo.setSelected(c.getEstado());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar cliente seleccionado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarClientesActivos() {
        try {
            ClienteData cd = new ClienteData(conexion);
            // Obtener la lista de clientes activos
            java.util.List<Cliente> clientesActivos = cd.listarClientesActivos();

            // Limpiar el combobox antes de agregar los items
            jcbClientesActivos.removeAllItems();

            // Agregar los nombres de los clientes activos
            for (Cliente c : clientesActivos) {
                jcbClientesActivos.addItem(c.getCodCli() + " - " + c.getNombreCompleto());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes activos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane3 = new javax.swing.JDesktopPane();
        jGestiondeClientes9 = new javax.swing.JLabel();
        Jcodigocliente = new javax.swing.JLabel();
        jnombrecompleto = new javax.swing.JLabel();
        jtelefono = new javax.swing.JLabel();
        jedad = new javax.swing.JLabel();
        jtfDni = new javax.swing.JTextField();
        jtfNombreCompleto = new javax.swing.JTextField();
        jtfTelefono = new javax.swing.JTextField();
        jtfEdad = new javax.swing.JTextField();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jcbActivo = new javax.swing.JCheckBox();
        jdni = new javax.swing.JLabel();
        jtfCodigoCliente = new javax.swing.JTextField();
        jafecciones = new javax.swing.JLabel();
        jtfAfecciones = new javax.swing.JTextField();
        jafecciones1 = new javax.swing.JLabel();
        jcbClientesActivos = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);

        jDesktopPane3.setBackground(new java.awt.Color(204, 204, 255));

        jGestiondeClientes9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jGestiondeClientes9.setForeground(new java.awt.Color(153, 0, 153));
        jGestiondeClientes9.setText("Gestion  de Clientes");

        Jcodigocliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jcodigocliente.setText("Codigo cliente :");

        jnombrecompleto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jnombrecompleto.setText("Nombre Completo :");

        jtelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtelefono.setText("Telefono :");

        jedad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jedad.setText("Edad :");

        jtfEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEdadActionPerformed(evt);
            }
        });

        jbNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 1, true));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 204)));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jcbActivo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jcbActivo.setText("Activo");

        jdni.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jdni.setText("DNI:");

        jafecciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jafecciones.setText("Afecciones:");

        jtfAfecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAfeccionesActionPerformed(evt);
            }
        });

        jafecciones1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jafecciones1.setText("Clientes activos");

        jcbClientesActivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDesktopPane3.setLayer(jGestiondeClientes9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(Jcodigocliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jnombrecompleto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jedad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfNombreCompleto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfEdad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jbNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jbGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jbModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jbEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jcbActivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jdni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfCodigoCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jafecciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jtfAfecciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jafecciones1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jcbClientesActivos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jGestiondeClientes9))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(jdni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtelefono)
                                    .addComponent(jedad)
                                    .addComponent(jafecciones))
                                .addGap(102, 102, 102)
                                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfAfecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbClientesActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(jnombrecompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(Jcodigocliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jafecciones1)
                            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                                .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jcbActivo)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jGestiondeClientes9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnombrecompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jtelefono)
                        .addGap(18, 18, 18)
                        .addComponent(jedad))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane3Layout.createSequentialGroup()
                        .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jafecciones)
                    .addComponent(jtfAfecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbActivo)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jafecciones1)
                    .addComponent(jcbClientesActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEdadActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        jtfCodigoCliente.setText("");
        jtfDni.setText("");
        jtfNombreCompleto.setText("");
        jtfTelefono.setText("");
        jtfEdad.setText("");
        jtfAfecciones.setText("");
        jcbActivo.setSelected(false);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jtfAfeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAfeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAfeccionesActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // expresiones regulares
        String regexDni = "^[0-9]{8}$"; // exactamente 8 digitos
        String regexTelefono = "^[0-9]+$"; // solo numeros
        String regexEdad = "^[0-9]+$"; // solo numeros
        String regexNombre = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"; // solo letras y espacios

        try {
            String textoDni = jtfDni.getText().trim();
            String nombreCompleto = jtfNombreCompleto.getText().trim();
            String textoTelefono = jtfTelefono.getText().trim();
            String textoEdad = jtfEdad.getText().trim();
            String afecciones = jtfAfecciones.getText().trim();
            boolean estado = jcbActivo.isSelected();

            // verifica que los campos obligatorios no esten vacios
            if (textoDni.isEmpty() || nombreCompleto.isEmpty() || textoTelefono.isEmpty() || textoEdad.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "debes rellenar todos los campos obligatorios.",
                        "campos vacios",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida formato de dni
            if (!textoDni.matches(regexDni)) {
                JOptionPane.showMessageDialog(this,
                        "el dni debe contener exactamente 8 digitos numericos (ejemplo: 41084990).",
                        "dni invalido",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida nombre completo
            if (!nombreCompleto.matches(regexNombre)) {
                JOptionPane.showMessageDialog(this,
                        "el nombre solo puede contener letras y espacios.",
                        "nombre invalido",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida telefono y edad
            if (!textoTelefono.matches(regexTelefono) || !textoEdad.matches(regexEdad)) {
                JOptionPane.showMessageDialog(this,
                        "telefono y edad deben contener solo numeros.",
                        "formato invalido",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int dni = Integer.parseInt(textoDni);
            long telefono = Long.parseLong(textoTelefono);
            int edad = Integer.parseInt(textoEdad);

            // crea el cliente y lo guarda en la base de datos
            Cliente c = new Cliente(dni, nombreCompleto, telefono, edad, afecciones, estado);
            ClienteData cd = new ClienteData(conexion);
            cd.guardarCliente(c);
            JOptionPane.showMessageDialog(this, "cliente guardado correctamente.");

            // limpia los campos
            jtfCodigoCliente.setText("");
            jtfDni.setText("");
            jtfNombreCompleto.setText("");
            jtfTelefono.setText("");
            jtfEdad.setText("");
            jtfAfecciones.setText("");
            jcbActivo.setSelected(false);

            // actualiza el combo con los clientes activos
            cargarClientesActivos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "ocurrio un error: " + e.getMessage(),
                    "error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private Cliente clienteActual;

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // expresiones regulares
        String regexDni = "^[0-9]{8}$"; // exactamente 8 digitos
        String regexNumerico = "^[0-9]+$"; // solo numeros
        String regexNombre = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"; // solo letras y espacios

        try {
            // verifica que haya un cliente seleccionado
            if (clienteActual == null) {
                JOptionPane.showMessageDialog(this, "primero debes buscar un cliente", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String textoDni = jtfDni.getText().trim();
            String nombreCompleto = jtfNombreCompleto.getText().trim();
            String textoTelefono = jtfTelefono.getText().trim();
            String textoEdad = jtfEdad.getText().trim();
            String afecciones = jtfAfecciones.getText().trim();
            boolean estado = jcbActivo.isSelected();

            // verifica que los campos obligatorios no esten vacios
            if (textoDni.isEmpty() || nombreCompleto.isEmpty() || textoTelefono.isEmpty() || textoEdad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "debes rellenar todos los campos obligatorios", "campos vacios", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida que el dni tenga exactamente 8 digitos
            if (!textoDni.matches(regexDni)) {
                JOptionPane.showMessageDialog(this, "el dni debe tener exactamente 8 digitos numericos (ejemplo: 41084990)", "dni invalido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida que el nombre solo contenga letras y espacios
            if (!nombreCompleto.matches(regexNombre)) {
                JOptionPane.showMessageDialog(this, "el nombre solo puede contener letras y espacios", "nombre invalido", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // valida que telefono y edad sean numericos
            if (!textoTelefono.matches(regexNumerico) || !textoEdad.matches(regexNumerico)) {
                JOptionPane.showMessageDialog(this, "telefono y edad deben contener solo numeros", "error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int dni = Integer.parseInt(textoDni);
            long telefono = Long.parseLong(textoTelefono);
            int edad = Integer.parseInt(textoEdad);

            // actualiza los datos del cliente actual
            clienteActual.setDni(dni);
            clienteActual.setNombreCompleto(nombreCompleto);
            clienteActual.setTelefono(telefono);
            clienteActual.setEdad(edad);
            clienteActual.setAfecciones(afecciones);
            clienteActual.setEstado(estado);

            // guarda los cambios en la base de datos
            ClienteData cd = new ClienteData(conexion);
            cd.actualizarCliente(clienteActual);

            JOptionPane.showMessageDialog(this, "cliente actualizado correctamente");

            // limpia los campos
            jtfDni.setText("");
            jtfNombreCompleto.setText("");
            jtfTelefono.setText("");
            jtfEdad.setText("");
            jtfAfecciones.setText("");
            jcbActivo.setSelected(false);
            clienteActual = null;

            // refresca el combo con los clientes activos
            cargarClientesActivos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ocurrio un error: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            String textoCodigoCliente = jtfCodigoCliente.getText();

            int codigoCliente = Integer.parseInt(textoCodigoCliente);

            if (textoCodigoCliente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un código de cliente", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ClienteData cd = new ClienteData(conexion);

            Cliente c = cd.buscarCliente(codigoCliente);
            clienteActual = c;

            jtfDni.setText(String.valueOf(c.getDni()));
            jtfNombreCompleto.setText(c.getNombreCompleto());
            jtfTelefono.setText(String.valueOf(c.getTelefono()));
            jtfEdad.setText(String.valueOf(c.getEdad()));
            jtfAfecciones.setText(c.getAfecciones());
            jcbActivo.setSelected(c.getEstado());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (clienteActual == null) {
                JOptionPane.showMessageDialog(this, "Debes buscar un cliente antes de eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "Seguro que deseas dar de baja este cliente?",
                    "Confirmar baja",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                ClienteData cd = new ClienteData(conexion);
                cd.bajaFisicaCliente(clienteActual.getCodCli());
                JOptionPane.showMessageDialog(this, "Cliente dado de baja correctamente");

                jtfCodigoCliente.setText("");
                jtfDni.setText("");
                jtfNombreCompleto.setText("");
                jtfTelefono.setText("");
                jtfEdad.setText("");
                jtfAfecciones.setText("");
                jcbActivo.setSelected(false);

                clienteActual = null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al eliminar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jcodigocliente;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jGestiondeClientes9;
    private javax.swing.JLabel jafecciones;
    private javax.swing.JLabel jafecciones1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JCheckBox jcbActivo;
    private javax.swing.JComboBox<String> jcbClientesActivos;
    private javax.swing.JLabel jdni;
    private javax.swing.JLabel jedad;
    private javax.swing.JLabel jnombrecompleto;
    private javax.swing.JLabel jtelefono;
    private javax.swing.JTextField jtfAfecciones;
    private javax.swing.JTextField jtfCodigoCliente;
    private javax.swing.JTextField jtfDni;
    private javax.swing.JTextField jtfEdad;
    private javax.swing.JTextField jtfNombreCompleto;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables
}
