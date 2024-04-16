package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.scenes.calculator.CalculatorsScene;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class CenterScene {
    TabPane tabPane;
    CalculatorsScene calculatorsScene;
    public CenterScene() {
        Init();
        InitCalculators();
    }

    private void Init() {
        tabPane = new TabPane();
        tabPane.getStyleClass().add(Styles.TABS_CLASSIC);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
    }

    private void InitCalculators() {
        calculatorsScene = new CalculatorsScene();
        Tab tab = new Tab("Инструменты", calculatorsScene.GetNode());
        tabPane.getTabs().add(tab);
    }

    public Scene GetScene() { return tabPane.getScene(); }
    public Node GetNode() { return tabPane; }
}
