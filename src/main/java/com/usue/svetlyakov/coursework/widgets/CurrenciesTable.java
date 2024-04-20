package com.usue.svetlyakov.coursework.widgets;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrenciesTable {
    static public TableView<CurrencyRow> CreateTable() {
        var col1 = new TableColumn<CurrencyRow, String>("Код");
        col1.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().charCode_)
        );

        var col2 = new TableColumn<CurrencyRow, String>("Название");
        col2.setCellValueFactory(
                c -> new SimpleStringProperty(c.getValue().name_)
        );

        var col3 = new TableColumn<CurrencyRow, String>("Номинал");
        col3.setCellValueFactory(
                c -> new SimpleStringProperty(String.valueOf(c.getValue().nominal_))
        );

        var col4 = new TableColumn<CurrencyRow, String>("Курс за лот");
        col4.setCellValueFactory(
                c -> new SimpleStringProperty(String.valueOf(c.getValue().value_))
        );

        var col5 = new TableColumn<CurrencyRow, String>("Курс (ед.)");
        col5.setCellValueFactory(
                c -> new SimpleStringProperty(String.valueOf(c.getValue().valueRate_))
        );

        var col6 = new TableColumn<CurrencyRow, String>("Доступно (лотов)");

        col6.setCellValueFactory(
            c -> {
                double value = Math.floor(c.getValue().availableToBuy_);
                return new SimpleStringProperty(String.valueOf(value));
            }
        );

        var col7 = new TableColumn<CurrencyRow, String>("Доступно (ед.)");
        col7.setCellValueFactory(
            c -> {
                BigDecimal rounded = new BigDecimal(c.getValue().available_);
                rounded = rounded.setScale(2, RoundingMode.HALF_DOWN);
                return new SimpleStringProperty(String.valueOf(rounded.doubleValue()));
            }
        );

        TableView<CurrencyRow> table = new TableView<>();
        table.getColumns().setAll(col1, col2, col3, col4, col5, col6, col7);
        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN
        );

        return table;
    }
}
