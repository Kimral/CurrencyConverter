package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.tools.SceneTools;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

public class BottomScene {
    HBox hbox;
    public BottomScene() {
        hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setStyle("-fx-background-color: -color-neutral-muted;");
        IconButton button = new IconButton(Styles.BUTTON_ICON, Feather.MORE_HORIZONTAL);
        hbox.getChildren().add(button.GetNode());
    }

    public Scene GetScene() {
        return hbox.getScene();
    }
    public Node GetNode() {
        return hbox;
    }
}
