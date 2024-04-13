package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.widgets.AppLabel;
import com.usue.svetlyakov.coursework.widgets.IconButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import org.kordamp.ikonli.feather.Feather;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppHeaderScene {
    HBox mainPane;
    HBox innerPane;
    AppLabel appLabel;
    WindowControlScene control;
    IconButton settingsButton;

    double xOffset, yOffset;
    public AppHeaderScene() {
        InitMainPane();
        InitInnerPane();
        InitSettingButton();
        AddEmptySpace();
        AddControl();
    }

    private void InitSettingButton() {
        settingsButton = new IconButton(Styles.BUTTON_ICON, Feather.MORE_HORIZONTAL);
        innerPane.getChildren().add(settingsButton.GetNode());
    }

    private void InitInnerPane() {
        innerPane = new HBox();
        innerPane.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });
        innerPane.setOnMouseDragged(mouseEvent -> {
            Node node = (Node) mouseEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.setX(mouseEvent.getScreenX() - xOffset);
            stage.setY(mouseEvent.getScreenY() - yOffset);
        });
        innerPane.setSpacing(GlobalConstants.defaultSpacing * 2);
        innerPane.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(innerPane, Priority.ALWAYS);
        mainPane.getChildren().add(innerPane);
    }

    private void InitMainPane() {
        mainPane = new HBox();
        mainPane.setStyle("-fx-background-color: -color-neutral-muted;");
        mainPane.setPadding(new Insets(GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding));
    }

    private void AddEmptySpace() {
        appLabel = new AppLabel("Конвертер валют");
        innerPane.getChildren().add(appLabel.GetNode());
        HBox.setHgrow(appLabel.GetNode(), Priority.ALWAYS);
    }

    private void AddControl() {
        control = new WindowControlScene();
        innerPane.getChildren().add(control.GetNode());
    }

    public Scene GetScene() {
        return mainPane.getScene();
    }
    public Node GetNode() {
        return mainPane;
    }
}
