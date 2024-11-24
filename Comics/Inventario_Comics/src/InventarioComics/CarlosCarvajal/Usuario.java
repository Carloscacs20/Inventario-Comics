package InventarioComics.CarlosCarvajal;

import java.util.ArrayList;
import java.util.Random;

public class Usuario {
    private int id;
    private String nombre;
    private String telefono;
    private boolean tieneMembresia;

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Usuario(String nombre, String telefono, boolean tieneMembresia) {
        this.id = generarId();
        this.nombre = nombre;
        this.telefono = telefono;
        this.tieneMembresia = tieneMembresia;
    }

    public int getId() {
        return id;
    }

    public boolean tieneMembresia() {
        return tieneMembresia;
    }

    public static void agregarUsuario(String nombre, String telefono, boolean tieneMembresia) {
        listaUsuarios.add(new Usuario(nombre, telefono, tieneMembresia));
        System.out.println("Usuario creado exitosamente.");
    }

    public static Usuario buscarUsuario(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public static void mostrarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\nLista de Usuarios");
            for (Usuario usuario : listaUsuarios) {
                System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.nombre + ", Teléfono: " + usuario.telefono + ", Membresía: " + (usuario.tieneMembresia ? "Sí" : "No"));
            }
        }
    }

    private static int generarId() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }
}

