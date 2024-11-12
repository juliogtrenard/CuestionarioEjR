module es.juliogtrenard.cuestionarioejr {
    requires javafx.controls;
    requires javafx.fxml;
    requires es.juliogtrenard.componentetemporizador;

    opens es.juliogtrenard.cuestionarioejr to javafx.fxml;
    exports es.juliogtrenard.cuestionarioejr;
}