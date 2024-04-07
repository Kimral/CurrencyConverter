package com.usue.svetlyakov.coursework.tools;

import com.usue.svetlyakov.coursework.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;

public class SceneTools {
    public static Scene LoadAsScene(String scene_fxml_path, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(scene_fxml_path));
            return new Scene(fxmlLoader.load(), width, height);
        }
        catch (Exception _) {};
        return null;
    }

    public static Node LoadAsNode(String scene_fxml_path, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(scene_fxml_path));
            return new Scene(fxmlLoader.load(), width, height).getRoot();
        }
        catch (Exception _) {}
        return null;
    }

    public static Scene LoadAsScene(String scene_fxml_path) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(scene_fxml_path));
            return new Scene(fxmlLoader.load());
        }
        catch (Exception _) {}
        return null;
    }

    public static Node LoadAsNode(String scene_fxml_path) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(scene_fxml_path));
            return new Scene(fxmlLoader.load()).getRoot();
        }
        catch (Exception _) {}
        return null;
    }
}
