package com.usue.svetlyakov.coursework.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainScene {
    private static final double min_window_width = 625;
    private static final double min_window_height = 425;
    BorderPane pane;
    CenterScene centre;
    AppHeaderScene appHeader;
    public MainScene() {
        Init();
        InitCenter();
        InitHeader();
    }

    private void Init() {
        pane = new BorderPane();
        pane.setMinHeight(min_window_height);
        pane.setMinWidth(min_window_width);
    }

    private void InitCenter() {
        centre = new CenterScene();
        pane.setCenter(centre.GetNode());
    }

    private void InitHeader() {
        appHeader = new AppHeaderScene();
        pane.setTop(appHeader.GetNode());
    }

    public Scene GetScene() { return pane.getScene(); }
    public Node GetNode() { return pane; }
}
