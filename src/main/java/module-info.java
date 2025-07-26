module com.example.proyecto_final_ada_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto_final_ada_gui to javafx.fxml;
    exports com.example.proyecto_final_ada_gui;
}