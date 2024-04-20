package com.usue.svetlyakov.coursework.scenes.calculator;

import atlantafx.base.theme.Styles;
import com.usue.svetlyakov.coursework.GlobalConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OfflineCalculatorScene {
    VBox vbox;
    HBox countHbox;
    HBox rateHBox;
    HBox commissionHBox;
    HBox resultHBox;

    TextField count;
    TextField rate;
    TextField commission;
    TextField result;

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
            result.pseudoClassStateChanged(Styles.STATE_DANGER, true);
            result.pseudoClassStateChanged(Styles.STATE_SUCCESS, false);
            return false;
        }
        else {
            double value = Double.parseDouble(field.getText());
            if(value >= min && value <= max) {
                field.pseudoClassStateChanged(Styles.STATE_DANGER, false);
            }
            else {
                field.pseudoClassStateChanged(Styles.STATE_DANGER, true);
                result.pseudoClassStateChanged(Styles.STATE_DANGER, true);
                result.pseudoClassStateChanged(Styles.STATE_SUCCESS, false);
                return false;
            }
        }
        return true;
    }

    private boolean IsDataValid() {
        boolean flag = true;
        flag = ValidateField(count, 0.0, Double.MAX_VALUE) && flag;
        flag = ValidateField(rate, 0.0, Double.MAX_VALUE) && flag;
        flag = ValidateField(commission, 0.0, 100.0) && flag;

        if(flag) {
            result.pseudoClassStateChanged(Styles.STATE_DANGER, false);
            result.pseudoClassStateChanged(Styles.STATE_SUCCESS, true);
        }
        return flag;
    }

    private void Recount() {
        if(IsDataValid()) {
            double counterValue = Double.parseDouble(count.getText());
            double rateValue  = Double.parseDouble(rate.getText());
            double commissionValue  = Double.parseDouble(commission.getText());

            double resultValue = counterValue * rateValue * (1 - commissionValue / 100);
            BigDecimal rounded = new BigDecimal(resultValue);
            rounded = rounded.setScale(6, RoundingMode.HALF_UP);
            result.setText(String.valueOf(rounded.doubleValue()));
        } else {
            result.setText("");
        }
    }

    public OfflineCalculatorScene() {
        Init();
        InitCountHbox();
        InitRateHBox();
        InitCommissionHBox();
        InitSpacer();
        InitResult();
    }

    private void Init() {
        vbox = new VBox();
        vbox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.setPadding(new Insets(
            GlobalConstants.defaultPadding * 5,
            GlobalConstants.defaultPadding * 5,
            GlobalConstants.defaultPadding * 5,
            GlobalConstants.defaultPadding * 5)
        );
        vbox.setAlignment(Pos.CENTER);
    }

    private void InitCountHbox() {
        countHbox = new HBox();
        countHbox.setAlignment(Pos.CENTER);
        countHbox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.getChildren().add(countHbox);

        Text label = new Text("Количество");
        label.getStyleClass().add(Styles.TITLE_4);
        countHbox.getChildren().add(label);

        count = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        count.setTextFormatter(formatter);
        count.setAlignment(Pos.CENTER);
        count.textProperty().addListener(_ -> Recount());
        countHbox.getChildren().add(count);
    }

    private void InitRateHBox() {
        rateHBox = new HBox();
        rateHBox.setAlignment(Pos.CENTER);
        rateHBox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.getChildren().add(rateHBox);

        Text label = new Text("Курс на рынке");
        label.getStyleClass().add(Styles.TITLE_4);
        rateHBox.getChildren().add(label);

        rate = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        rate.setTextFormatter(formatter);
        rate.setAlignment(Pos.CENTER);
        rate.textProperty().addListener(_ -> Recount());
        rateHBox.getChildren().add(rate);
    }

    private void InitCommissionHBox() {
        commissionHBox = new HBox();
        commissionHBox.setAlignment(Pos.CENTER);
        commissionHBox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.getChildren().add(commissionHBox);

        Text label = new Text("Комиссия");
        label.getStyleClass().add(Styles.TITLE_4);
        commissionHBox.getChildren().add(label);

        commission = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        commission.setTextFormatter(formatter);
        commission.setAlignment(Pos.CENTER);
        commission.textProperty().addListener(_ -> Recount());
        commissionHBox.getChildren().add(commission);

        Text percent = new Text("%");
        percent.getStyleClass().add(Styles.TITLE_4);
        commissionHBox.getChildren().add(percent);
    }

    private void InitSpacer() {
        Separator separator = new Separator();
        vbox.getChildren().add(separator);
    }

    private void InitResult() {
        resultHBox = new HBox();
        resultHBox.setAlignment(Pos.CENTER);
        resultHBox.setSpacing(GlobalConstants.defaultSpacing * 2);
        vbox.getChildren().add(resultHBox);

        Text label = new Text("Итого");
        label.getStyleClass().add(Styles.TITLE_4);
        resultHBox.getChildren().add(label);

        result = new TextField();
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(), 0.0);
        result.setTextFormatter(formatter);
        result.setEditable(false);
        result.setAlignment(Pos.CENTER);
        resultHBox.getChildren().add(result);
    }

    public Scene GetScene() {
        return vbox.getScene();
    }
    public Node GetNode() {
        return vbox;
    }
}
