package co.edu.uniquindio.poo.model;

public class Reserva {
    private Vehiculo vehiculo;
    private Cliente cliente;
    private int diasReserva;

    public Reserva(Vehiculo vehiculo, Cliente cliente, int diasReserva) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.diasReserva = diasReserva;
    }

    public double calcularCostoTotal() {
        return vehiculo.calcularCostoReserva(diasReserva);
    }

    @Override
    public String toString() {
        return "Información de la reserva:\n" +
               "Vehículo: " + vehiculo + "\n" +
               "Cliente: " + cliente.getNombre() + "\n" +
               "Días de reserva: " + diasReserva + "\n" +
               "Costo total: " + calcularCostoTotal() + "\n";   
    }
}
