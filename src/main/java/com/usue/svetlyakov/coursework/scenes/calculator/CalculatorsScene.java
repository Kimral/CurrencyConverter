package com.usue.svetlyakov.coursework.scenes.calculator;

import atlantafx.base.theme.Styles;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class CalculatorsScene {
    TabPane tabPane;
    OfflineCalculatorScene offline;
    public CalculatorsScene() {
        Init();
        InitOffline();
        //InitOnline();
    }

    private void Init() {
        tabPane = new TabPane();
        tabPane.getStyleClass().add(Styles.TABS_CLASSIC);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.BOTTOM);
    }

    private void InitOffline() {
        offline = new OfflineCalculatorScene();
        Tab tab = new Tab("Offline", offline.GetNode());
        tabPane.getTabs().add(tab);
    }

    private void InitOnline() {
        tabPane.getTabs().add(new Tab("Online"));
    }

    public Scene GetScene() {
        return tabPane.getScene();
    }
    public Node GetNode() {
        return tabPane;
    }
}
