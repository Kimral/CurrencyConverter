package com.usue.svetlyakov.coursework.scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

public class IconButton {
    Button button = null;
    public IconButton(String style, Feather icon) {
        button = new Button(null, new FontIcon(icon));
        button.getStyleClass().addAll(style);
    }

    public void SetAction(EventHandler<ActionEvent> function) {
        button.setOnAction(function);
    }

    public Scene GetScene() {
        return button.getScene();
    }
    public Node GetNode() {
        return button;
    }
}
