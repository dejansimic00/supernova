module org.supernovaklijent {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.supernovaklijent to javafx.fxml;
    exports org.supernovaklijent;
    exports org.supernovaklijent.controllers;
}