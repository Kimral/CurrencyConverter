package com.usue.svetlyakov.coursework.tools;

import com.usue.svetlyakov.coursework.App;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneTools {
    public static Stage GetStageByEvent(Event event) {
        Node node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }
}
