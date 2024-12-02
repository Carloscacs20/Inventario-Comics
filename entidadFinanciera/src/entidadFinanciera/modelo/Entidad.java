package entidadFinanciera.modelo;

import java.util.Scanner;

public class Entidad {
    protected int id;

    public Entidad() {
        // Constructor vacío
    }

    public Entidad(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void leerInformacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID: ");
        this.setId(scanner.nextInt());
    }

    public String mostrarInformacion(){
        String sb = "El id es " + getId();
        return sb;
    }

}
