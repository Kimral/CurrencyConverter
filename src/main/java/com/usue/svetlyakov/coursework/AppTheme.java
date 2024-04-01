package com.usue.svetlyakov.coursework;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.Dracula;
import atlantafx.base.theme.NordDark;
import atlantafx.base.theme.NordLight;

import atlantafx.base.theme.Theme;
import javafx.application.Application;

enum AppThemes {
    PrimerDark,
    PrimerLight,
    CupertinoDark,
    CupertinoLight,
    Dracula,
    NordDark,
    NordLight
}
public class AppTheme {
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
    }
}
