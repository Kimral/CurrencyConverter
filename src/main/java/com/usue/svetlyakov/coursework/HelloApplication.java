package com.usue.svetlyakov.coursework;

import com.almasb.fxgl.scene.SceneService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static final double min_window_width = 650;
    private static final double min_window_height = 450;
    static public int multiply(int a, int b) {
        return a * b;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = LoadScene("hello-view.fxml", min_window_width, min_window_height);
        SetScene(stage, scene);

    }

    private void SetScene(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();
        stage.setMinWidth(scene.getWidth());
        stage.setMinHeight(scene.getHeight());
    }

    private Scene LoadScene(String scene_fxml_path, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(scene_fxml_path));
        return new Scene(fxmlLoader.load(), width, height);
    }


    public static void main(String[] args) {
        launch();
    }
}