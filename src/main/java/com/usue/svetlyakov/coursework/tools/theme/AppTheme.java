package com.usue.svetlyakov.coursework.tools.theme;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;

import atlantafx.base.theme.Theme;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AppTheme {
    static public AppThemes GetThemeByName(String name) {
        return switch (name) {
            case "Dracula" -> AppThemes.Dracula;
            case "PrimerDark" -> AppThemes.PrimerDark;
            case "PrimerLight" -> AppThemes.PrimerLight;
            case "CupertinoDark" -> AppThemes.CupertinoDark;
            case "CupertinoLight" -> AppThemes.CupertinoLight;
            case "NordDark" -> AppThemes.NordDark;
            case "NordLight" -> AppThemes.NordLight;
            default -> AppThemes.Dracula;
        };
    }

    static private Theme GetThemeById(AppThemes id) {
        switch (id) {
            case PrimerDark -> {
                return new PrimerDark();
            }
            case PrimerLight -> {
                return new PrimerLight();
            }
            case CupertinoDark -> {
                return new CupertinoDark();
            }
            case CupertinoLight -> {
                return new CupertinoLight();
            }
            case Dracula -> {
                return new Dracula();
            }
            case NordDark -> {
                return new NordDark();
            }
            case NordLight -> {
                return new NordLight();
            }
        }
        return new PrimerLight(); // ХЗ просто что сюда писать
    }
    static public void SetAppTheme(AppThemes theme_id) {
        Application.setUserAgentStylesheet(GetThemeById(theme_id).getUserAgentStylesheet());
        // Apply the theme to all existing stages
        for (Window child : Stage.getWindows()) {
            Scene scene = child.getScene();
            if (scene != null) {
                scene.getStylesheets().clear();
                scene.getStylesheets().add(Application.getUserAgentStylesheet());
            }
        }
    }
}
