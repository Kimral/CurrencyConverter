package com.usue.svetlyakov.coursework.widgets;

import atlantafx.base.theme.Styles;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AppLabel {
    HBox hbox;
    Text text;
    public AppLabel(String string) {
        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        SetText(string);
    }
    public void SetText(String string) {
        hbox.getChildren().clear();
        text = new Text(string);
        text.getStyleClass().add(Styles.TITLE_4);
        hbox.getChildren().add(text);
    }

    public Scene GetScene() { return hbox.getScene(); }
    public Node GetNode() { return hbox; }
}
