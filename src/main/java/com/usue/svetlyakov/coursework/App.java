package com.usue.svetlyakov.coursework;

import com.usue.svetlyakov.coursework.scenes.MainScene;
import com.usue.svetlyakov.coursework.tools.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    MainScene mainScene = null;

    @Override
    public void start(Stage stage) throws Exception {
        mainScene = new MainScene();
        Scene scene = new Scene((Parent) mainScene.GetNode());
        stage.initStyle(StageStyle.UNDECORATED);
        SetScene(stage, scene);
        AppTheme.SetAppTheme(AppThemes.Dracula);
    }

    private void SetScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("Конвертер валют");
        stage.show();
        stage.setMinWidth(scene.getWidth());
        stage.setMinHeight(scene.getHeight());
    }

    public static void main(String[] args) {
        launch();
    }
}