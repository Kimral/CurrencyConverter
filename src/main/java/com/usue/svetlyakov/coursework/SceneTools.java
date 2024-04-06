package com.usue.svetlyakov.coursework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneTools {
    public static Scene LoadScene(String scene_fxml_path, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(scene_fxml_path));
        return new Scene(fxmlLoader.load(), width, height);
    }
}
