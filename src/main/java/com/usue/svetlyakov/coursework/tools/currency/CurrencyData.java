package com.usue.svetlyakov.coursework.tools.currency;

public class CurrencyData {
    public String id_;
    public int numCode_;
    public String charCode_;
    public int nominal_;
    public String name_;
    public double value_;
    public double valueRate_;
    public CurrencyData(String id, int numCode, String charCode, int nominal, String name, double value, double valueRate) {
        id_ = id;
        numCode_ = numCode;
        charCode_ = charCode;
        nominal_ = nominal;
        name_ = name;
        value_ = value;
        valueRate_ = valueRate;
    }
}
