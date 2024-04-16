package com.usue.svetlyakov.coursework.scenes.settings;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.tools.theme.AppTheme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

@SuppressWarnings("ALL")
public class SettingsCentreScene {
    HBox mainBox;
    HBox innerBox;
    ComboBox comboBox;
    Text label;

    public SettingsCentreScene() {
        InitBackround();
        InitFront();
    }

    private void InitBackround() {
        mainBox = new HBox();
        mainBox.setStyle("-fx-background-color: -color-neutral-muted;");
        mainBox.setPadding(new Insets(0, 5, 5, 5));
        mainBox.setAlignment(Pos.TOP_CENTER);
    }

    private void InitFront() {
        innerBox = new HBox();
        innerBox.setSpacing(GlobalConstants.defaultSpacing);
        innerBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(innerBox, Priority.ALWAYS);
        innerBox.setStyle("-fx-background-color: -color-bg-inset;");
        mainBox.getChildren().add(innerBox);

        InitLabel();
        InitComboBox();
    }

    private void InitComboBox() {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Dracula", "PrimerDark", "PrimerLight", "CupertinoDark", "CupertinoLight", "NordDark", "NordLight");
        comboBox = new ComboBox(options);
        comboBox.setValue("Dracula");
        comboBox.setOnAction(event -> {
            AppTheme.SetAppTheme(AppTheme.GetThemeByName(comboBox.getValue().toString()));
        });
        innerBox.getChildren().add(comboBox);
    }

    private void InitLabel() {
        label = new Text("Тема приложения");
        label.getStyleClass().add(Styles.TITLE_4);
        innerBox.getChildren().add(label);
    }

    public Scene GetScene() {
        return mainBox.getScene();
    }

    public Node GetNode() {
        return mainBox;
    }
}
