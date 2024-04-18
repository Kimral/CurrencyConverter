package com.usue.svetlyakov.coursework.scenes.calculator;

import atlantafx.base.controls.Calendar;
import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.widgets.CompareTime;
import com.usue.svetlyakov.coursework.widgets.CurrenciesTable;
import com.usue.svetlyakov.coursework.widgets.CurrencyRow;
import com.usue.svetlyakov.coursework.widgets.MyCalendar;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OnlineCalculatorScene {
    VBox vbox;
    HBox paramsHbox;
    VBox currencyParamsHBox;

    ComboBox<String> currency;
    TextField currencyCount;
    TextField commission;
    Calendar date;

    public OnlineCalculatorScene() {
        Init();
        InitParams();
        InitTable();
    }

    private void Init() {
        vbox = new VBox();
        vbox.setPadding(new Insets(GlobalConstants.defaultPadding * 2));
        vbox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.setAlignment(Pos.TOP_CENTER);
    }

    private void InitParams() {
        paramsHbox = new HBox();
        paramsHbox.setAlignment(Pos.CENTER);
        paramsHbox.setSpacing(GlobalConstants.defaultSpacing * 2);

        InitCalendar();
        InitCurrencyParams();

        vbox.getChildren().add(paramsHbox);
    }

    private void InitTable() {
        TableView<CurrencyRow> table = CurrenciesTable.CreateTable();
        VBox.setVgrow(table, Priority.ALWAYS);
        vbox.getChildren().add(table);
    }

    private void InitCurrencyParams() {
        currencyParamsHBox = new VBox();
        currencyParamsHBox.setAlignment(Pos.CENTER_RIGHT);
        currencyParamsHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        InitCurrency();
        InitCurrencyCount();
        InitCommission();

        paramsHbox.getChildren().add(currencyParamsHBox);
    }

    private void InitCurrency() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_RIGHT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Валюта");
        label.getStyleClass().add(Styles.TITLE_4);

        currency = new ComboBox<String>();
        currency.getItems().add("Test");
        currency.setMaxWidth(200);
        HBox.setHgrow(currency, Priority.ALWAYS);

        localHBox.getChildren().add(label);
        localHBox.getChildren().add(currency);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCommission() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_RIGHT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Комиссия");
        label.getStyleClass().add(Styles.TITLE_4);

        commission = new TextField();
        localHBox.getChildren().add(label);
        localHBox.getChildren().add(commission);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCurrencyCount() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_RIGHT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Количество");
        label.getStyleClass().add(Styles.TITLE_4);

        currencyCount = new TextField();
        localHBox.getChildren().add(label);
        localHBox.getChildren().add(currencyCount);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCalendar() {
        date = MyCalendar.CreateCalendar(CompareTime.OnlyPast);
        paramsHbox.getChildren().add(date);
    }

    public Scene GetScene() {
        return vbox.getScene();
    }
    public Node GetNode() {
        return vbox;
    }
}
