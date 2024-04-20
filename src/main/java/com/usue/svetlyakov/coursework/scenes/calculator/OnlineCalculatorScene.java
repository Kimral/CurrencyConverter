package com.usue.svetlyakov.coursework.scenes.calculator;

import atlantafx.base.controls.Calendar;
import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import com.usue.svetlyakov.coursework.tools.currency.CurrencyData;
import com.usue.svetlyakov.coursework.tools.currency.CurrencyFetcher;
import com.usue.svetlyakov.coursework.widgets.CompareTime;
import com.usue.svetlyakov.coursework.widgets.CurrenciesTable;
import com.usue.svetlyakov.coursework.widgets.CurrencyRow;
import com.usue.svetlyakov.coursework.widgets.MyCalendar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;

import java.util.*;

public class OnlineCalculatorScene {
    HBox hbox;
    VBox paramsVbox;
    VBox currencyParamsHBox;

    TableView<CurrencyRow> table;

    ComboBox<String> currency;
    TextField currencyCount;
    TextField commissionCount;
    Calendar date;

    public OnlineCalculatorScene() {
        Init();
        InitParams();
        InitTable();
    }

    private void Init() {
        hbox = new HBox();
        hbox.setPadding(new Insets(GlobalConstants.defaultPadding * 2));
        hbox.setSpacing(GlobalConstants.defaultSpacing * 2);
        hbox.setAlignment(Pos.TOP_CENTER);
    }

    private void InitParams() {
        paramsVbox = new VBox();
        paramsVbox.setAlignment(Pos.TOP_CENTER);
        paramsVbox.setMaxWidth(250);
        paramsVbox.setMinWidth(250);
        paramsVbox.setSpacing(GlobalConstants.defaultSpacing * 2);

        InitCalendar();
        InitCurrencyParams();

        hbox.getChildren().add(paramsVbox);
    }

    private void InitTable() {
        table = CurrenciesTable.CreateTable();
        HBox.setHgrow(table, Priority.ALWAYS);
        hbox.getChildren().add(table);
    }

    private void InitCurrencyParams() {
        currencyParamsHBox = new VBox();
        currencyParamsHBox.setAlignment(Pos.CENTER_LEFT);
        currencyParamsHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        InitCurrencyWidgets();
        InitCurrencyCount();
        InitCommission();

        paramsVbox.getChildren().add(currencyParamsHBox);
    }

    private void InitCurrencyWidgets() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_LEFT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Валюта");
        label.getStyleClass().add(Styles.TITLE_4);

        InitCurrency();

        localHBox.getChildren().add(label);
        localHBox.getChildren().add(currency);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCurrency() {
        currency = new ComboBox<>();
        currency.setOnAction(_ -> DataChanged());
        HBox.setHgrow(currency, Priority.ALWAYS);

        InitCurrencyList();
    }

    private void InitCommission() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_LEFT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Комиссия");
        label.getStyleClass().add(Styles.TITLE_4);

        commissionCount = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        commissionCount.setTextFormatter(formatter);
        commissionCount.setOnAction(_ -> DataChanged());

        Text percent = new Text("%");
        percent.getStyleClass().add(Styles.TITLE_4);

        localHBox.getChildren().add(label);
        localHBox.getChildren().add(commissionCount);
        localHBox.getChildren().add(percent);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCurrencyCount() {
        HBox localHBox = new HBox();
        localHBox.setAlignment(Pos.CENTER_RIGHT);
        localHBox.setSpacing(GlobalConstants.defaultSpacing * 2);

        Text label = new Text("Количество");
        label.getStyleClass().add(Styles.TITLE_4);

        currencyCount = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        currencyCount.setTextFormatter(formatter);
        currencyCount.setOnAction(_ -> DataChanged());

        localHBox.getChildren().add(label);
        localHBox.getChildren().add(currencyCount);

        currencyParamsHBox.getChildren().add(localHBox);
    }

    private void InitCalendar() {
        date = MyCalendar.CreateCalendar(CompareTime.OnlyPast);
        date.valueProperty().addListener((_, _, _) -> {
            InitCurrencyList();
            DataChanged();
        });
        paramsVbox.getChildren().add(date);
    }

    public Scene GetScene() {
        return hbox.getScene();
    }
    public Node GetNode() {
        return hbox;
    }

    private void InitCurrencyList() {
        String oldValue = currency.getValue();
        currency.getItems().clear();
        Map<String, CurrencyData> currenciesData = CurrencyFetcher.GetForDate(date.getValue());
        Vector<String> currencyTitles = new Vector<>();
        for(Map.Entry<String, CurrencyData> data : currenciesData.entrySet()) {
            currencyTitles.add(data.getValue().charCode_ +" | " + data.getValue().name_);
        }
        Collections.sort(currencyTitles);
        currency.getItems().addAll(currencyTitles);

        if(!(oldValue == null)) {
            if(currencyTitles.contains(oldValue)) {
                currency.setValue(oldValue);
            }
            else {
                table.getItems().clear();
            }
        }
    }

    private void DataChanged() {
        String code = currency.getValue();
        if(!IsDataValid()) {
            table.getItems().clear();
            return;
        }
        if(code == null || code.isEmpty())
            return;
        RefillTable();
    }

    private void RefillTable() {
        table.getItems().clear();

        String code = currency.getValue().substring(0, 3);
        Map<String, CurrencyData> currenciesData = CurrencyFetcher.GetForDate(date.getValue());

        CurrencyData currentCurrency = null;
        for(Map.Entry<String, CurrencyData> currency : currenciesData.entrySet()) {
            if (Objects.equals(currency.getValue().charCode_, code)) {
                currentCurrency = currency.getValue();
                break;
            }
        }

        if(currentCurrency == null)
            return;

        double count = 0.0;
        double commission = 0.0;
        try {
            count = Double.parseDouble(currencyCount.getText());
            commission = Double.parseDouble(commissionCount.getText());
        } catch (Exception error) {
            return;
        }

        for(Map.Entry<String, CurrencyData> currency : currenciesData.entrySet()) {
            if(Objects.equals(currency.getValue().charCode_, code))
                continue;

            double relation = currentCurrency.valueRate_ / currency.getValue().valueRate_;
            double rawAvailable = relation * count;
            double available = (rawAvailable - (commission / 100) * rawAvailable);
            double availableToBuy = available / currency.getValue().nominal_;

            CurrencyRow row = new CurrencyRow(
                currency.getValue().charCode_,
                currency.getValue().name_,
                currency.getValue().nominal_,
                currency.getValue().value_,
                currency.getValue().valueRate_,
                available,
                availableToBuy
            );

            table.getItems().add(row);
        }
    }

    private boolean ValidateDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    private boolean ValidateField(TextField field, Double min, Double max) {
        if(!ValidateDouble(field.getText())) {
            field.pseudoClassStateChanged(Styles.STATE_DANGER, true);
            return false;
        }
        else {
            double value = Double.parseDouble(field.getText());
            if(value >= min && value <= max) {
                field.pseudoClassStateChanged(Styles.STATE_DANGER, false);
            }
            else {
                field.pseudoClassStateChanged(Styles.STATE_DANGER, true);
                return false;
            }
        }
        return true;
    }

    private boolean IsDataValid() {
        boolean flag = true;
        flag = ValidateField(currencyCount, 0.0, Double.MAX_VALUE) && flag;
        flag = ValidateField(commissionCount, 0.0, 100.0) && flag;
        return flag;
    }
}
