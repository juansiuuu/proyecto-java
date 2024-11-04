package co.edu.uniquindio.poo.viewController;
import java.time.LocalDate;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudreservasController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="fechainicio"
    private DatePicker fechainicio; // Value injected by FXMLLoader

    @FXML // fx:id="Fechafin"
    private DatePicker Fechafin; // Value injected by FXMLLoader

    @FXML // fx:id="costoCalculado"
    private TextField costoCalculado; // Value injected by FXMLLoader

    @FXML // fx:id="seleccionarCliente"
    private ChoiceBox<Cliente> seleccionarCliente; // Value injected by FXMLLoader

    @FXML // fx:id="listareservas"
    private TableView<Reserva> listareservas; // Value injected by FXMLLoader

    @FXML // fx:id="seleccionarVehiculo"
    private ChoiceBox<Vehiculo> seleccionarVehiculo; // Value injected by FXMLLoader

    private Empresa empresa; // Instancia de la empresa

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        cargarClientes();
        cargarVehiculos();
    }

    @FXML
    void CalcularCosto(ActionEvent event) {
        LocalDate inicio = fechainicio.getValue();
        LocalDate fin = Fechafin.getValue();
        if (inicio != null && fin != null) {
            int diasReserva = (int) (java.time.Duration.between(inicio.atStartOfDay(), fin.atStartOfDay()).toDays());
            Vehiculo vehiculo = seleccionarVehiculo.getValue();
            if (vehiculo != null) {
                double costo = vehiculo.calcularCostoReserva(diasReserva);
                costoCalculado.setText(String.valueOf(costo));
            }
        }
    }

    @FXML
    void agregarReserva(ActionEvent event) {
        LocalDate inicio = fechainicio.getValue();
        LocalDate fin = Fechafin.getValue();
        Cliente cliente = seleccionarCliente.getValue();
        Vehiculo vehiculo = seleccionarVehiculo.getValue();

        if (inicio != null && fin != null && cliente != null && vehiculo != null) {
            int diasReserva = (int) (java.time.Duration.between(inicio.atStartOfDay(), fin.atStartOfDay()).toDays());
            Reserva nuevaReserva = new Reserva(vehiculo, cliente, diasReserva);
            empresa.agregarReserva(nuevaReserva);
            // Actualizar la tabla de reservas
            listareservas.getItems().add(nuevaReserva);
        }
    }

    @FXML
    void actualizarReserca(ActionEvent event) {
        // Lógica para actualizar la reserva seleccionada
        // Aquí deberías obtener la reserva seleccionada de la tabla y actualizarla
    }

    @FXML
    void eliminarReserva(ActionEvent event) {
        Reserva reservaSeleccionada = listareservas.getSelectionModel().getSelectedItem();
        if (reservaSeleccionada != null) {
            empresa.eliminarReserva(reservaSeleccionada);
            listareservas.getItems().remove(reservaSeleccionada);
        }
    }

    private void cargarClientes() {
        // Carga los clientes en el ChoiceBox
        seleccionarCliente.getItems().addAll(empresa.getClientes()); // Suponiendo que tienes un método getClientes()
    }

    private void cargarVehiculos() {
        // Carga los vehículos en el ChoiceBox
        seleccionarVehiculo.getItems().addAll(empresa.getVehiculos()); // Suponiendo que tienes un método getVehiculos()
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert fechainicio != null : "fx:id=\"fechainicio\" was not injected: check your FXML file 'CrudReservas.fxml'.";
        assert Fechafin != null : "fx:id=\"Fechafin\" was not injected: check your FXML file 'CrudReservas.fxml'.";
        assert costoCalculado != null : "fx:id=\"costoCalculado\" was not injected: check your FXML file 'CrudReservas.fxml'.";
        assert seleccionarCliente != null : "fx:id=\"seleccionarCliente\" was not injected: check your FXML file 'CrudReservas.fxml'.";
        assert listareservas != null : "fx:id=\"listareservas\" was not injected: check your FXML file 'CrudReservas.fxml'.";
        assert seleccionarVehiculo != null : "fx:id=\"seleccionarVehiculo\" was not injected: check your FXML file 'CrudReservas.fxml'.";
    }
}
