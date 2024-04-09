package com.usue.svetlyakov.coursework.scenes;

import atlantafx.base.theme.Styles;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.kordamp.ikonli.feather.Feather;

public class WindowControlScene {
    HBox mainPane;
    IconButton collapse;
    IconButton expand;
    IconButton close;

    boolean expendFlag = false;

    public WindowControlScene() {
        Init();
        InitCollapse();
        InitExpand();
        InitClose();
    }

    private void Init() {
        mainPane = new HBox();
        mainPane.setSpacing(GlobalConstants.defaultSpacing);
    }

    private void InitCollapse() {
        collapse = new IconButton(Styles.BUTTON_ICON, Feather.MINIMIZE);
        collapse.SetAction(actionEvent -> {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setIconified(true);
        });
        mainPane.getChildren().add(collapse.GetNode());
    }

    private void InitExpand() {
        expand = new IconButton(Styles.BUTTON_ICON, Feather.MAXIMIZE);
        expand.SetAction(actionEvent -> {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            if(!expendFlag) {
                stage.setMaximized(true);
                expendFlag = true;
            }
            else {
                stage.setMaximized(false);
                expendFlag = false;
            }

        });
        mainPane.getChildren().add(expand.GetNode());
    }

    private void InitClose() {
        close = new IconButton(Styles.BUTTON_ICON, Feather.X_OCTAGON);
        close.SetAction(actionEvent -> {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        });
        mainPane.getChildren().add(close.GetNode());
    }

    public Scene GetScene() { return mainPane.getScene(); }
    public Node GetNode() {
        return mainPane;
    }
}
