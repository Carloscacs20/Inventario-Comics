package entidadFinanciera.modelo;

import java.util.Scanner;

public class Usuario extends Entidad {
    private String nombre;
    private String direccion;

    public Usuario() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void ingresarInformacionUsuario() {
        super.leerInformacion(); // Llama al método de la superclase para leer ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        this.setNombre(scanner.nextLine());
        System.out.print("Ingrese la direccion: ");
        this.setDireccion(scanner.nextLine());
    }

    public void mostrarInformacionUsuario() {
        String info = super.mostrarInformacion();
        info += " Nombre del Usuario: " + getNombre() + "\n" +
                "Direccion del Usuario: " + getDireccion();
        System.out.println(info);
    }

    public Prestamo solicitarPrestamo() {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(this.getId()); // Usar el ID del usuario para el préstamo
        prestamo.ingresarInformacionPrestamo();
        prestamo.aprobar();
        if (!prestamo.isAprobado()) {
            return null;
        }
        return prestamo;
    }
}

