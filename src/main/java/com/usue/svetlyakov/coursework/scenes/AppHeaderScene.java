package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.widgets.AppLabel;
import eu.hansolo.tilesfx.Test;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppHeaderScene {
    HBox mainPane;
    Button idk;
    AppLabel appLabel;
    WindowControlScene control;

    double xOffset, yOffset;
    public AppHeaderScene() {
        InitMainPane();
        AddIDK();
        AddEmptySpace();
        AddControl();
    }

    private void InitMainPane() {
        mainPane = new HBox();
        mainPane.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });
        mainPane.setOnMouseDragged(mouseEvent -> {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.setX(mouseEvent.getScreenX() - xOffset);
            stage.setY(mouseEvent.getScreenY() - yOffset);
        });
        mainPane.setSpacing(GlobalConstants.defaultSpacing * 2);
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
        appLabel = new AppLabel("Конвертер валют");
        HBox.setHgrow(appLabel.GetNode(), Priority.ALWAYS);
        mainPane.getChildren().add(appLabel.GetNode());
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
