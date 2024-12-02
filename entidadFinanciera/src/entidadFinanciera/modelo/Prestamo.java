package entidadFinanciera.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prestamo extends Entidad {
    private static final double MONTO_MAXIMO = 50000.0; // Monto máximo permitido
    private static final int PLAZO_MAXIMO = 60; // Plazo máximo en meses
    private double monto;
    private int plazo; // En meses
    private boolean aprobado;
    private List<Cuota> cuotas;

    public Prestamo() {
        super();
        this.aprobado = false;
        this.cuotas = new ArrayList<>();
    }

    public Prestamo(int id) {
        super(id);
        this.aprobado = false;
        this.cuotas = new ArrayList<>();
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void ingresarInformacionPrestamo() {
        Scanner scanner = new Scanner(System.in);
        super.leerInformacion(); // Llama al método de la clase base para leer el ID
        System.out.print("Ingrese el monto del préstamo: ");
        this.monto = scanner.nextDouble();
        System.out.print("Ingrese el plazo (en meses): ");
        this.plazo = scanner.nextInt();
    }

    public void aprobar() {
        if (this.monto <= MONTO_MAXIMO && this.plazo <= PLAZO_MAXIMO) {
            this.aprobado = true;
            generarCuotas();
            System.out.println("El préstamo ha sido aprobado.");
        } else {
            System.out.println("El préstamo no ha sido aprobado debido a que el monto o el plazo exceden los límites permitidos.");
        }
    }

    private void generarCuotas() {
        double montoCuota = Cuota.calcularCuota(this.monto, this.plazo);
        for (int i = 1; i <= plazo; i++) {
            Cuota cuota = new Cuota(i, this.getId(), montoCuota);
            cuotas.add(cuota);
        }
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void mostrarCuotas() {
        for (Cuota cuota : cuotas) {
            System.out.printf("Cuota ID: %d, Monto: %.2f, Pagada: %b\n",
                    cuota.getId(), cuota.getMonto(), cuota.isPagada());
        }
    }


    public String mostrarInformacionPrestamo() {
        return String.format(
                "ID del Préstamo: %d\nMonto del Préstamo: %.2f\nPlazo en Meses: %d\nEstado: %s",
                this.getId(),
                this.getMonto(),
                this.getPlazo(),
                this.aprobado ? "Aprobado" : "No Aprobado"
        );
    }
}




