package com.usue.svetlyakov.coursework.windows;

import com.usue.svetlyakov.coursework.scenes.settings.SettingsScene;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SettingsWindow {
    private static final double window_width = 400;
    private static final double window_height = 260;
    Stage stage;
    SettingsScene settingsScene;
    public SettingsWindow(Stage parentStage) {
        Init(parentStage);
        InitScene();
    }
    private void Init(Stage parentStage) {
        stage = new Stage();
        stage.initOwner(parentStage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
    }
    private void InitScene() {
        settingsScene = new SettingsScene();
        Scene scene = new Scene((Parent) settingsScene.GetNode(), window_width, window_height);
        scene.getStylesheets().add(Application.getUserAgentStylesheet());
        stage.setScene(scene);
    }

    public void ShowAndWait() {
        stage.showAndWait();
    }
}
