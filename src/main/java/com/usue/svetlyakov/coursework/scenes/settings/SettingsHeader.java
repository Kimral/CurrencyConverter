package com.usue.svetlyakov.coursework.scenes.settings;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.tools.SceneTools;
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

public class SettingsHeader {
    HBox mainPane;
    HBox innerPane;
    AppLabel appLabel;
    IconButton closeButton;
    double xOffset, yOffset;
    public SettingsHeader() {
        InitMainPane();
        InitInnerPane();
        InitLabel();
        InitEmptySpace();
        InitCloseButton();
    }

    private void InitMainPane() {
        mainPane = new HBox();
        mainPane.setStyle("-fx-background-color: -color-neutral-muted;");
        mainPane.setPadding(new Insets(GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding,
                GlobalConstants.defaultPadding + 5));
    }

    private void InitInnerPane() {
        innerPane = new HBox();
        innerPane.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });
        innerPane.setOnMouseDragged(mouseEvent -> {
            Stage stage = SceneTools.GetStageByEvent(mouseEvent);

            stage.setX(mouseEvent.getScreenX() - xOffset);
            stage.setY(mouseEvent.getScreenY() - yOffset);
        });
        HBox.setHgrow(innerPane,Priority.ALWAYS);
        innerPane.setAlignment(Pos.CENTER_LEFT);
        mainPane.getChildren().add(innerPane);
    }
    private void InitLabel() {
        appLabel = new AppLabel("Настройки");
        innerPane.getChildren().add(appLabel.GetNode());
    }
    private void InitEmptySpace() {
        HBox hbox = new HBox();
        HBox.setHgrow(hbox, Priority.ALWAYS);
        innerPane.getChildren().add(hbox);
    }
    private void InitCloseButton() {
        closeButton = new IconButton(Styles.BUTTON_ICON, Feather.X_OCTAGON);
        closeButton.SetAction(actionEvent -> {
            Stage stage = SceneTools.GetStageByEvent(actionEvent);
            stage.close();
        });
        innerPane.getChildren().add(closeButton.GetNode());
    }
    public Scene GetScene() {
        return mainPane.getScene();
    }
    public Node GetNode() {
        return mainPane;
    }
}
