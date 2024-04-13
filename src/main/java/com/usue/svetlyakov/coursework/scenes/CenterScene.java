package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class CenterScene {
    TabPane tabPane;
    public CenterScene() {
        tabPane = new TabPane();
        tabPane.getStyleClass().add(Styles.TABS_CLASSIC);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
        tabPane.getTabs().add(new Tab("Инструменты"));
    }

    public Scene GetScene() { return tabPane.getScene(); }
    public Node GetNode() { return tabPane; }
}
