package Vistas;

import Modelo.Cliente;
import Persistencia.ClienteData;
import Persistencia.Conexion;
import java.sql.Connection;
import java.util.Scanner;

public class SpaEntreTodos {

    public static void main(String[] args) {

        String url = "jdbc:mariadb://localhost:3306/spayrelax";
        String usuario = "root";
        String password = "";

        Conexion con = new Conexion(url, usuario, password);
        Connection conex = (Connection) con.obtenerConexion();

        if (con.obtenerConexion() != null) {
            System.out.println("Conectado correctamente a la base de datos.");
        } else {
            System.out.println("No se pudo conectar.");
            return; // salir si no hay conexión
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("DNI: ");
        int dni = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombreCompleto = sc.nextLine();

        System.out.print("Telefono: ");
        long telefono = sc.nextLong();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("Afecciones: ");
        String afecciones = sc.nextLine();

        System.out.print("Estado (true/false): ");
        boolean estado = sc.nextBoolean();

        Cliente c = new Cliente(dni, nombreCompleto, telefono, edad, afecciones, estado);

        ClienteData cd = new ClienteData(con);
        cd.guardarCliente(c);
        System.out.println("Cliente guardado exitosamente!");
        
        sc.close();
    }

}
