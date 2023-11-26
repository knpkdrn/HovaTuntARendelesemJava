module com.example.hovatuntarendelesemjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.google.gson;
    requires java.sql;

    opens com.example.hovatuntarendelesemjava to javafx.fxml;
    exports com.example.hovatuntarendelesemjava;

    exports com.example.hovatuntarendelesemjava.model;
    opens com.example.hovatuntarendelesemjava.model to com.google.gson, javafx.fxml;
    exports com.example.hovatuntarendelesemjava.model.base;
    opens com.example.hovatuntarendelesemjava.model.base to com.google.gson, javafx.fxml;
}