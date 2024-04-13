package com.usue.svetlyakov.coursework.scenes;

import com.usue.svetlyakov.coursework.GlobalConstants;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class AppHeaderScene {
    HBox mainPane;
    Button idk;
    HBox emptySpace;
    WindowControlScene control;

    public AppHeaderScene() {
        InitMainPane();
        AddIDK();
        AddEmptySpace();
        AddControl();
    }

    private void InitMainPane() {
        mainPane = new HBox();
        mainPane.setPadding(new Insets(GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding));
        mainPane.setStyle("-fx-background-color: -color-neutral-muted;");
    }

    private void AddIDK() {
        idk = new Button("Logo here");
        mainPane.getChildren().add(idk);
    }

    private void AddEmptySpace() {
        emptySpace = new HBox();
        HBox.setHgrow(emptySpace, Priority.ALWAYS);
        mainPane.getChildren().add(emptySpace);
    }

    private void AddControl() {
        control = new WindowControlScene();
        mainPane.getChildren().add(control.GetNode());
    }

    public Scene GetScene() {
        return mainPane.getScene();
    }

    public Node GetNode() {
        return mainPane;
    }
}
