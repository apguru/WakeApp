module com.example.wakeapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    exports com.example.wakeapp;
    opens com.example.wakeapp to javafx.fxml;
}