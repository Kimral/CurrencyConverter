package com.usue.svetlyakov.coursework.scenes;

import com.usue.svetlyakov.coursework.SceneTools;
import javafx.scene.Scene;

public class MainScene {
    private static final double min_window_width = 650;
    private static final double min_window_height = 450;
    Scene scene = null;

    public MainScene() throws Exception {
        scene = SceneTools.LoadScene("hello-view.fxml", min_window_width, min_window_height);
    }

    public Scene GetScene() {
        return scene;
    }
}
