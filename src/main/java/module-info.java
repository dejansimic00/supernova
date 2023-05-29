module org.supernova {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.supernova to javafx.fxml;
    exports org.supernova;
}