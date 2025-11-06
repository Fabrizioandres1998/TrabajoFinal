//package Vistas;
//
//import Modelo.Cliente;
//import Modelo.Consultorio;
//import Modelo.Producto;
//import Modelo.Tratamiento;
//import Persistencia.ClienteData;
//import Persistencia.Conexion;
//import Persistencia.ConsultorioData;
//import Persistencia.ProductoData;
//import Persistencia.TratamientoData;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class SpaEntreTodos {
//
//    public static void main(String[] args) {
//
//        String url = "jdbc:mariadb://localhost:3306/spayrelax";
//        String usuario = "root";
//        String password = "";
//
//        Conexion con = new Conexion(url, usuario, password);
//        Connection conex = (Connection) con.obtenerConexion();
//
//        if (con.obtenerConexion() != null) {
//            System.out.println("Conectado correctamente a la base de datos.");
//        } else {
//            System.out.println("No se pudo conectar.");
//            return; // salir si no hay conexión
//        }
//
//        Scanner sc = new Scanner(System.in);

//        // --- Datos del tratamiento ---
//        System.out.print("Ingrese el nombre del tratamiento: ");
//        String nombre = sc.nextLine();
//
//        System.out.print("Ingrese el tipo ('Masajes','Facial','Corporal','Relajacion','Estetico'): ");
//        String tipo = sc.nextLine();
//        while (!(tipo.equals("Masajes") || tipo.equals("Facial") || tipo.equals("Corporal")
//                || tipo.equals("Relajacion") || tipo.equals("Estetico"))) {
//            System.out.println("Tipo inválido. Ingrese nuevamente:");
//            tipo = sc.nextLine();
//        }
//
//        System.out.print("Ingresa los detalles: ");
//        String detalle = sc.nextLine();
//
//        // --- Selección de productos ---
//        ProductoData productoData = new ProductoData(con);
//        List<Producto> productosActivos = productoData.listarProductosActivos();
//        List<Producto> productosSeleccionados = new ArrayList<>();
//
//        System.out.print("Ingresa el código del producto (0 para salir): ");
//        int codProd = sc.nextInt();
//        sc.nextLine();
//
//        while (codProd != 0) {
//            Producto productoEncontrado = null;
//
//            for (Producto p : productosActivos) {
//                if (p.getCodProd() == codProd) {
//                    productoEncontrado = p;
//                    break;
//                }
//            }
//
//            if (productoEncontrado != null) {
//                productosSeleccionados.add(productoEncontrado);
//                System.out.println("Producto agregado: " + productoEncontrado.getNombre());
//            } else {
//                System.out.println("No se encontró el producto con código " + codProd);
//            }
//
//            System.out.print("Ingresa otro código de producto (0 para salir): ");
//            codProd = sc.nextInt();
//            sc.nextLine();
//        }
//
//        // mostrar los productos elegidos
//        System.out.println("\nProductos seleccionados:");
//        for (Producto p : productosSeleccionados) {
//            System.out.println("- " + p.getNombre() + " ($" + p.getPrecio() + ")");
//        }
//
//        // --- Datos finales del tratamiento ---
//        System.out.print("\nIngrese la duración (en minutos): ");
//        int duracion = sc.nextInt();
//
//        System.out.print("Ingrese el costo: ");
//        double costo = sc.nextDouble();
//
//        sc.nextLine(); // limpiar buffer
//
//        System.out.print("¿Está activo? (true/false): ");
//        boolean activo = sc.nextBoolean();
//
//        // --- Crear y guardar tratamiento ---
//        Tratamiento tratamiento = new Tratamiento();
//        tratamiento.setNombre(nombre);
//        tratamiento.setTipo(tipo);
//        tratamiento.setDetalle(detalle);
//        tratamiento.setProductos(productosSeleccionados);
//        tratamiento.setDuracion(duracion);
//        tratamiento.setCosto(costo);
//        tratamiento.setActivo(activo);
//
//        TratamientoData tratamientoData = new TratamientoData(con);
//        tratamientoData.guardarTratamiento(tratamiento);
//
//        System.out.println("\nTratamiento guardado correctamente.");
//        // --- Datos del cliente ---
//        System.out.print("Ingrese el DNI del cliente: ");
//        int dni = sc.nextInt();
//        sc.nextLine(); // limpiar buffer
//
//        System.out.print("Ingrese el nombre completo: ");
//        String nombre = sc.nextLine();
//
//        System.out.print("Ingrese el teléfono: ");
//        long telefono = sc.nextLong();
//        sc.nextLine();
//
//        System.out.print("Ingrese la edad: ");
//        int edad = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print("Ingrese afecciones (si no tiene, deje en blanco): ");
//        String afecciones = sc.nextLine();
//
//        System.out.print("¿Está activo? (true/false): ");
//        boolean estado = sc.nextBoolean();
//
//        // --- Crear cliente ---
//        Cliente cliente = new Cliente();
//        cliente.setDni(dni);
//        cliente.setNombreCompleto(nombre);
//        cliente.setTelefono(telefono);
//        cliente.setEdad(edad);
//        cliente.setAfecciones(afecciones);
//        cliente.setEstado(estado);
//
//        // --- Guardar cliente ---
//        ClienteData clienteData = new ClienteData(con);
//        clienteData.guardarCliente(cliente);
//
//        System.out.println("\nCliente guardado correctamente con código: " + cliente.getCodCli());
//
//        // --- Listar clientes activos ---
//        System.out.println("\nClientes activos:");
//        List<Cliente> clientes = clienteData.listarClientesActivos();
//        for (Cliente c : clientes) {
//            System.out.println(c.getCodCli() + " - " + c.getNombreCompleto() + " | DNI: " + c.getDni());
//        }
        // --- Datos del consultorio ---
//        System.out.print("Ingrese los usos del consultorio: ");
//        String usos = sc.nextLine();
//
//        System.out.print("Ingrese el equipamiento: ");
//        String equipamiento = sc.nextLine();
//
//        System.out.print("¿Es apto? (true/false): ");
//        boolean apto = sc.nextBoolean();
//
//        // --- Crear y guardar consultorio ---
//        Consultorio consultorio = new Consultorio();
//        consultorio.setUsos(usos);
//        consultorio.setEquipamiento(equipamiento);
//        consultorio.setApto(apto);
//
//        ConsultorioData consultorioData = new ConsultorioData(con);
//        consultorioData.guardarConsultorio(consultorio);
//
//        System.out.println("\nConsultorio guardado correctamente con número: " + consultorio.getNroConsultorio());
//
//        // --- Listar consultorios aptos ---
//        System.out.println("\nConsultorios aptos:");
//        List<Consultorio> consultorios = consultorioData.listarConsultoriosAptos();
//        for (Consultorio c : consultorios) {
//            System.out.println("N° " + c.getNroConsultorio() + " | Usos: " + c.getUsos() + " | Equipamiento: " + c.getEquipamiento());
//        }
//    }
//}
