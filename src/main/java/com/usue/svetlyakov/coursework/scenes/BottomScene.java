package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.widgets.IconButton;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import org.kordamp.ikonli.feather.Feather;

public class BottomScene {
    HBox hbox;
    public BottomScene() {
        hbox = new HBox();
        hbox.setPadding(new Insets(GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding));
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
