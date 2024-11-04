package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ControladorReserva {

    @FXML
    private DatePicker fechainicio;

    @FXML
    private DatePicker Fechafin;

    @FXML
    private ChoiceBox<Cliente> seleccionarCliente;

    @FXML
    private ChoiceBox<Vehiculo> seleccionarVehiculo;

    @FXML
    private TextField costoCalculado;

    @FXML
    private TableView<Reserva> listareservas;

    private Empresa empresa; // Suponiendo que tienes una instancia de empresa

    // Método para establecer la empresa
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        cargarClientes();
        cargarVehiculos();
    }

    @FXML
    public void initialize() {
        // Configura la fuente de los elementos si es necesario
        // Ejemplo: si tienes un label para el título
        // gestionReservasLabel.setFont(Font.font("System", FontWeight.BOLD, 18));
    }

    private void cargarClientes() {
        seleccionarCliente.getItems().addAll(empresa.getClientes());
    }

    private void cargarVehiculos() {
        seleccionarVehiculo.getItems().addAll(empresa.getVehiculos());
    }

    @FXML
    public void CalcularCosto() {
        LocalDate inicio = fechainicio.getValue();
        LocalDate fin = Fechafin.getValue();

        if (inicio == null || fin == null) {
            costoCalculado.setText("Seleccione fechas válidas");
            return;
        }

        if (!inicio.isBefore(fin)) {
            costoCalculado.setText("La fecha de inicio debe ser antes de la fecha de fin");
            return;
        }

        int diasReserva = (int) (java.time.Duration.between(inicio.atStartOfDay(), fin.atStartOfDay()).toDays());
        Vehiculo vehiculo = seleccionarVehiculo.getValue();

        if (vehiculo != null) {
            double costo = vehiculo.calcularCostoReserva(diasReserva);
            costoCalculado.setText(String.valueOf(costo));
        } else {
            costoCalculado.setText("Seleccione un vehículo");
        }
    }

    @FXML
    public void agregarReserva() {
        // Lógica para agregar reserva
    }

    @FXML
    public void actualizarReserva() {
        // Lógica para actualizar reserva
    }

    @FXML
    public void eliminarReserva() {
        // Lógica para eliminar reserva
    }
}
