module com.example.lab78 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab78 to javafx.fxml;
    exports com.example.lab78;
}