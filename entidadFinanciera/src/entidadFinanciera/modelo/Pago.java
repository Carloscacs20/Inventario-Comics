package entidadFinanciera.modelo;

public class Pago extends Entidad {
    private int cuotaId;
    private double monto;

    public Pago(int id, int cuotaId, double monto) {
        super(id);
        this.cuotaId = cuotaId;
        this.monto = monto;
    }

    public int getCuotaId() {
        return cuotaId;
    }

    public void setCuotaId(int cuotaId) {
        this.cuotaId = cuotaId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void registrar(Cuota cuota) {
        if (cuota != null && !cuota.isPagada()) {
            cuota.registrarPago(this.monto);
        } else if (cuota.isPagada()) {
            System.out.println("La cuota ID " + cuota.getId() + " ya está pagada.");
        } else {
            System.out.println("No se encontró la cuota para registrar el pago.");
        }
    }
}


