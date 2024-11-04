package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    private int numeroPuertas;
    private double tarifaBase=40000;
    
    public Auto(String numeroMatricula, String marca, String modelo, String añoFabricacion, int numeroPuertas,
            double tarifaBase) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.numeroPuertas = numeroPuertas;
        this.tarifaBase = tarifaBase;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }
    
    @Override
    public double calcularCostoReserva(int dias) {
        return tarifaBase*dias;

    }


    //validar numero de puertas y tarifa base
    public void setNumeroPuertas(int numeroPuertas) {
        if (numeroPuertas <= 0) {
            throw new IllegalArgumentException("El número de puertas debe ser mayor que cero.");
        }
        this.numeroPuertas = numeroPuertas;
    }
    
    public void setTarifaBase(double tarifaBase) {
        if (tarifaBase <= 0) {
            throw new IllegalArgumentException("La tarifa base debe ser mayor que cero.");
        }
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String toString() {
        return "Auto [numeroPuertas=" + numeroPuertas + ", tarifaBase=" + tarifaBase + "]";
    }


    


    

    
}
