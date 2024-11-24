package InventarioComics.CarlosCarvajal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Venta de Cómics");
            System.out.println("1. Agregar cómic");
            System.out.println("2. Mostrar cómics");
            System.out.println("3. Buscar cómic");
            System.out.println("4. Crear usuario");
            System.out.println("5. Mostrar usuarios");
            System.out.println("6. Generar factura");
            System.out.println("7. Mostrar facturas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del cómic: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del cómic: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese la cantidad disponible: ");
                    int stock = scanner.nextInt();
                    Comic.agregarComic(titulo, autor, stock);
                    break;
                case 2:
                    Comic.mostrarComics();
                    break;
                case 3:
                    System.out.print("Ingrese el título del cómic a buscar: ");
                    String buscarTitulo = scanner.nextLine();
                    Comic comic = Comic.buscarComic(buscarTitulo);
                    if (comic != null) {
                        System.out.println("Título: " + comic.getTitulo() + ", Autor: " + comic.getAutor() + ", Stock: " + comic.getStock());
                    } else {
                        System.out.println("Cómic no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del usuario: ");
                    String telefono = scanner.nextLine();
                    System.out.print("¿Tiene membresía? (true/false): ");
                    boolean tieneMembresia = scanner.nextBoolean();
                    Usuario.agregarUsuario(nombreUsuario, telefono, tieneMembresia);
                    break;
                case 5:
                    Usuario.mostrarUsuarios();
                    break;
                case 6:
                    System.out.print("Ingrese el ID del usuario: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el título del cómic: ");
                    String tituloComic = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a comprar: ");
                    int cantidad = scanner.nextInt();
                    Factura.generarFactura(idUsuario, tituloComic, cantidad);
                    break;
                case 7:
                    Factura.mostrarFacturas();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}