package com.usue.svetlyakov.coursework.controllers;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.scenes.BottomScene;
import com.usue.svetlyakov.coursework.tools.SceneTools;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BottomScene bottomScene = new BottomScene();
        borderPane.setBottom(bottomScene.GetNode());
    }
}
