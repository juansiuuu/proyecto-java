package co.edu.uniquindio.poo.model;

public class Camioneta extends Vehiculo {
    private double capacidadCarga;
    private double tarifaBase=60000;
    private double porcentajeAdicional=0.1;
  
    public Camioneta(String numeroMatricula, String marca, String modelo, String añoFabricacion, double capacidadCarga,
            double tarifaBase, double porcentajeAdicional) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.capacidadCarga = capacidadCarga;
        this.tarifaBase = tarifaBase;
        this.porcentajeAdicional = porcentajeAdicional;
    }
    public double getCapacidadCarga() {
        return capacidadCarga;
    }
    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public double getTarifaBase() {
        return tarifaBase;
    }
    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getPocentajeAdicional() {
        return porcentajeAdicional;
    }
    public void setPocentajeAdicional(double pocentajeAdicional) {
        this.porcentajeAdicional = pocentajeAdicional;
    }
    

    @Override
    public double calcularCostoReserva(int dias) {
        double costoReserva = tarifaBase * dias; // Cálculo básico
        costoReserva += (capacidadCarga * porcentajeAdicional) * tarifaBase * dias; // Cálculo adicional por capacidad
        return costoReserva; // Retornar el costo total
    }
    @Override
    public String toString() {
        return "capacidadCarga: " + capacidadCarga + ", tarifaBase=" + tarifaBase + ", porcentajeAdicional="
                + porcentajeAdicional + "]";
    }



    
}
