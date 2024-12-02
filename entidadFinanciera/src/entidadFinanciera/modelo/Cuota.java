package entidadFinanciera.modelo;

public class Cuota extends Entidad {
    private int prestamoId;
    private double monto;
    private boolean pagada;

    public Cuota(int id, int prestamoId, double monto) {
        super(id);
        this.prestamoId = prestamoId;
        this.monto = monto;
        this.pagada = false;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void registrarPago(double monto) {
        if (monto >= this.monto) {
            this.pagada = true;
            System.out.println("Cuota ID " + getId() + " ha sido pagada en su totalidad.");
        } else {
            System.out.println("El pago es insuficiente para la cuota ID " + getId());
        }
    }

    public static double calcularCuota(double montoPrestamo, int plazo) {
        double tasaMensual = 0.05 / 12; // Tasa del 5% anual dividida entre 12 meses
        return (montoPrestamo * tasaMensual * Math.pow(1 + tasaMensual, plazo)) /
                (Math.pow(1 + tasaMensual, plazo) - 1);
    }
}

