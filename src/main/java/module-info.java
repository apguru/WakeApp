module com.example.wakeapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.wakeapp to javafx.fxml;
    exports com.example.wakeapp;
}