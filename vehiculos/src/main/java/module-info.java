module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.uniquindio.poo; // Asegúrate de que este paquete se exporte
    exports co.edu.uniquindio.poo.viewController; // Exporta el paquete donde está tu controlador

    opens co.edu.uniquindio.poo.viewController to javafx.fxml; // Permite que JavaFX acceda al controlador
}
