package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.kordamp.ikonli.feather.Feather;

public class AppHeaderScene  {
    HBox mainPane;
    Button idk;
    HBox emptySpace;
    Button closeBtn;

    public AppHeaderScene() {
        InitMainPane();
        AddIDK();
        AddEmptySpace();
        AddCloseButton();
    }

    private void InitMainPane() {
        mainPane = new HBox();
        mainPane.setPadding(new Insets(5, 5, 5, 5));
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

    private void AddCloseButton() {
        closeBtn = new Button("Close");
        closeBtn.setOnAction(actionEvent -> {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        });
        mainPane.getChildren().add(closeBtn);
    }

    public Scene GetScene() { return mainPane.getScene(); }
    public Node GetNode() {
        return mainPane;
    }
}
