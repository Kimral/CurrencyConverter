package com.usue.svetlyakov.coursework;

import com.usue.svetlyakov.coursework.scenes.MainScene;
import com.usue.svetlyakov.coursework.tools.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    MainScene scene = null;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new MainScene();
        SetScene(stage, scene.GetScene());
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