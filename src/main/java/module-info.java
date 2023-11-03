module com.example.hovatuntarendelesemjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hovatuntarendelesemjava to javafx.fxml;
    exports com.example.hovatuntarendelesemjava;
}