package InventarioComics.CarlosCarvajal;

import java.util.ArrayList;

public class Factura {
    private int idUsuario;
    private String tituloComic;
    private int cantidad;

    private static ArrayList<Factura> listaFacturas = new ArrayList<>();

    public Factura(int idUsuario, String tituloComic, int cantidad) {
        this.idUsuario = idUsuario;
        this.tituloComic = tituloComic;
        this.cantidad = cantidad;
    }

    public static void generarFactura(int idUsuario, String tituloComic, int cantidad) {
        Usuario usuario = Usuario.buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println("El usuario con ID " + idUsuario + " no existe.");
            return;
        }

        Comic.comprarComic(tituloComic, cantidad, usuario.tieneMembresia(), 10); // Descuento del 10%
        listaFacturas.add(new Factura(idUsuario, tituloComic, cantidad));
    }

    public static void mostrarFacturas() {
        if (listaFacturas.isEmpty()) {
            System.out.println("No hay facturas registradas.");
        } else {
            System.out.println("\nFacturas");
            for (Factura factura : listaFacturas) {
                System.out.println("Usuario ID: " + factura.idUsuario + ", Cómic: " + factura.tituloComic + ", Cantidad: " + factura.cantidad);
            }
        }
    }
}
