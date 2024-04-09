package com.usue.svetlyakov.coursework.scenes;

import com.usue.svetlyakov.coursework.tools.SceneTools;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import com.usue.svetlyakov.coursework.scenes.BottomScene;

public class MainScene {
    private static final double min_window_width = 650;
    private static final double min_window_height = 450;
    BorderPane pane;
    BottomScene bottom;
    public MainScene() {
        pane = new BorderPane();
        pane.setMinHeight(min_window_height);
        pane.setMinWidth(min_window_width);
        bottom = new BottomScene();
        pane.setBottom(bottom.GetNode());
    }

    public Scene GetScene() {
        return pane.getScene();
    }
    public Node GetNode() {
        return pane;
    }
}
