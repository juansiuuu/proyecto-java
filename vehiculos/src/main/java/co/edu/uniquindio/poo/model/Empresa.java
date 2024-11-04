package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<Reserva> reservas;
    private LinkedList<Cliente> clientes; // Lista de clientes

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new LinkedList<>(); // Inicializar la lista de vehículos
        this.reservas = new LinkedList<>(); // Inicializar la lista de reservas
        this.clientes = new LinkedList<>(); // Inicializar la lista de clientes
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes; // Método para obtener la lista de clientes
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            System.out.println("Cliente agregado: " + cliente);
        } else {
            System.out.println("El cliente ya existe en la lista.");
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (!vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            System.out.println("Vehículo agregado: " + vehiculo);
        } else {
            System.out.println("El vehículo ya existe en la lista.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    @Override
    public String toString() {
        return "Empresa " + nombre + "\nVehiculos de la empresa: \n" + vehiculos + "\nReservas realizadas: " + reservas + "\nClientes: " + clientes + "]";
    }
}
