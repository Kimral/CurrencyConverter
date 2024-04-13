package com.usue.svetlyakov.coursework.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SettingsScene {
    BorderPane borderPane;
    SettingsHeader settingsHeader;
    public SettingsScene() {
        Init();
        InitTop();
    }

    private void Init() {
        borderPane = new BorderPane();
    }

    private void InitTop() {
        settingsHeader = new SettingsHeader();
        borderPane.setTop(settingsHeader.GetNode());
    }

    public Scene GetScene() { return borderPane.getScene(); }
    public Node GetNode() { return borderPane; }
}
