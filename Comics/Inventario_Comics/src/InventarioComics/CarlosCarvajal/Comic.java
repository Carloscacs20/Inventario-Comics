package InventarioComics.CarlosCarvajal;

import java.util.ArrayList;

public class Comic {
    private String titulo;
    private String autor;
    private int stock;

    private static ArrayList<Comic> listaComics = new ArrayList<>();

    public Comic(String titulo, String autor, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void agregarComic(String titulo, String autor, int stock) {
        listaComics.add(new Comic(titulo, autor, stock));
        System.out.println("Cómic agregado exitosamente.");
    }

    public static void mostrarComics() {
        if (listaComics.isEmpty()) {
            System.out.println("No hay cómics en el sistema.");
        } else {
            System.out.println("\n Lista de Cómics");
            for (Comic comic : listaComics) {
                System.out.println("Título: " + comic.getTitulo() + ", Autor: " + comic.getAutor() + ", Stock: " + comic.getStock());
            }
        }
    }

    public static Comic buscarComic(String titulo) {
        for (Comic comic : listaComics) {
            if (comic.getTitulo().equalsIgnoreCase(titulo)) {
                return comic;
            }
        }
        return null;
    }

    public static void comprarComic(String titulo, int cantidad, boolean tieneMembresia, double descuento) {
        Comic comic = buscarComic(titulo);

        if (comic == null) {
            System.out.println("El cómic no se encuentra en el sistema.");
            return;
        }

        if (comic.getStock() < cantidad) {
            System.out.println("No hay suficiente stock del cómic " + titulo + ".");
            return;
        }

        comic.setStock(comic.getStock() - cantidad);

        double precioBase = 15.0; // Precio base por unidad
        double total = precioBase * cantidad;
        if (tieneMembresia) {
            total *= (1 - descuento / 100); // Aplicar descuento
            System.out.println("¡Descuento aplicado por membresia!");
        }
        System.out.println("Compra exitosa. Total a pagar: $" + total);
        System.out.println("Stock restante: " + comic.getStock());
    }
}


