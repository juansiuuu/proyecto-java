package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo{
    private TipoCaja tipoCaja;
    private double tarifaBase=20000;


    public Moto(String numeroMatricula, String marca, String modelo, String añoFabricacion, TipoCaja tipoCaja,
            double tarifaBase) {
        super(numeroMatricula, marca, modelo, añoFabricacion);
        this.tipoCaja = tipoCaja;
        this.tarifaBase = tarifaBase;
    }

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        this.tipoCaja = tipoCaja;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
    @Override
    public double calcularCostoReserva(int dias) {
        double costoReserva= tarifaBase*dias;
        if (tipoCaja==TipoCaja.AUTOMATICA){
            costoReserva+=10000;  
        }
        return costoReserva;
    }




    
}
