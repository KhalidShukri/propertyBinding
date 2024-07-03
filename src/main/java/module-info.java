module com.example.propertybindingdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.propertybindingdemo to javafx.fxml;
    exports com.example.propertybindingdemo;
}