module com.usue.svetlyakov.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires atlantafx.base;
    requires atlantafx.styles;
    requires java.desktop;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.feather;
    requires java.net.http;

    opens com.usue.svetlyakov.coursework to javafx.fxml;
    exports com.usue.svetlyakov.coursework;
    exports com.usue.svetlyakov.coursework.tools;
    opens com.usue.svetlyakov.coursework.tools to javafx.fxml;
    exports com.usue.svetlyakov.coursework.tools.theme;
    opens com.usue.svetlyakov.coursework.tools.theme to javafx.fxml;
    exports com.usue.svetlyakov.coursework.tools.currency;
    opens com.usue.svetlyakov.coursework.tools.currency to javafx.fxml;
}