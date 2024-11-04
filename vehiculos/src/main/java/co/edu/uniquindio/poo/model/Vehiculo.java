package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    public String numeroMatricula;
    public String marca;
    public String modelo;
    public String añoFabricacion;
    public Vehiculo(String numeroMatricula, String marca, String modelo, String añoFabricacion) {
        this.numeroMatricula = numeroMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAñoFabricacion() {
        return añoFabricacion;
    }
    public void setAñoFabricacion(String añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public abstract double calcularCostoReserva(int dias);
    
    

    
}



