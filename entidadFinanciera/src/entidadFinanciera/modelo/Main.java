package entidadFinanciera.modelo;

public class Main {
    public static void main(String[] args) {


        Usuario usuario = new Usuario();
        System.out.println("*** Ingreso de Información del Usuario ***");
        usuario.ingresarInformacionUsuario();
        usuario.mostrarInformacionUsuario();

        
        System.out.println("\n*** Solicitud de Préstamo ***");
        Prestamo prestamo = usuario.solicitarPrestamo();
        if (prestamo == null) {
            System.out.println("El préstamo no fue aprobado. No se generaron cuotas.");
            return;
        }

        System.out.println("\n*** Detalles del Préstamo ***");
        System.out.println(prestamo.mostrarInformacionPrestamo());


        System.out.println("\n*** Cuotas Generadas ***");
        prestamo.mostrarCuotas();


        System.out.println("\n*** Registro de Pago ***");
        Cuota primeraCuota = prestamo.getCuotas().get(0);
        Pago pago = new Pago(1, primeraCuota.getId(), primeraCuota.getMonto());
        pago.registrar(primeraCuota);


        System.out.println("\n*** Estado de las Cuotas Después del Pago ***");
        prestamo.mostrarCuotas();
    }
}




