package com.usue.svetlyakov.coursework.widgets;

public class CurrencyRow {
    public String charCode_;
    public String name_;
    public int nominal_;
    public double value_;
    public double valueRate_;
    public double available_;
    public double availableToBuy_;

    public CurrencyRow(String charCode,
                       String name,
                       int nominal,
                       double value,
                       double valueRate,
                       double available,
                       double availableToBuy)
    {
        charCode_ = charCode;
        name_ = name;
        nominal_ = nominal;
        value_ = value;
        valueRate_ = valueRate;
        available_ = available;
        availableToBuy_ = availableToBuy;
    }
}
