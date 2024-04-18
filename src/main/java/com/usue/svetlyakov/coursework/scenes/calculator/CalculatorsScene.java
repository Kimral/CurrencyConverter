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
    OnlineCalculatorScene online;
    public CalculatorsScene() {
        Init();
        InitOnline();
        InitOffline();
    }

    private void Init() {
        tabPane = new TabPane();
        tabPane.getStyleClass().add(Styles.TABS_CLASSIC);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.BOTTOM);
    }

    private void InitOffline() {
        offline = new OfflineCalculatorScene();
        Tab tab = new Tab("Простой конвертер", offline.GetNode());
        tabPane.getTabs().add(tab);
    }

    private void InitOnline() {
        online = new OnlineCalculatorScene();
        tabPane.getTabs().add(new Tab("Онлайн конвертер", online.GetNode()));
    }

    public Scene GetScene() {
        return tabPane.getScene();
    }
    public Node GetNode() {
        return tabPane;
    }
}
