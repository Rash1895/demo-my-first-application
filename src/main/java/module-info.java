module lk.rash.demofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.rash.demofx to javafx.fxml;
    exports lk.rash.demofx;
    exports lk.rash.demofx.controller;
    opens lk.rash.demofx.controller to javafx.fxml;
}