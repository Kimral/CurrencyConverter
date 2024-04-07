package com.usue.svetlyakov.coursework.controllers;

import com.usue.svetlyakov.coursework.tools.SceneTools;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node scene  = SceneTools.LoadAsNode("BottomScene.fxml");
        borderPane.setBottom(scene);
    }
}
