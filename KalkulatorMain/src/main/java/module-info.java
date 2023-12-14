module com.example.kalkulatormain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalkulatormain to javafx.fxml;
    exports com.example.kalkulatormain;
}