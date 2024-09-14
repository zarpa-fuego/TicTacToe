module pe.edu.upeu.tresraya {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens pe.edu.upeu.modelo to javafx.base;
    opens pe.edu.upeu.tresraya to javafx.fxml;
    exports pe.edu.upeu.tresraya;
}