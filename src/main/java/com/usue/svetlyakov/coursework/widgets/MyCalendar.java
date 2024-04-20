package com.usue.svetlyakov.coursework.widgets;

import atlantafx.base.controls.Calendar;
import javafx.scene.control.DateCell;

import java.time.LocalDate;

import java.time.*;
import java.time.chrono.ChronoLocalDate;

class CustomDateCell extends DateCell {
    CompareTime timeFlag;
    public CustomDateCell(CompareTime flag) {
        timeFlag = flag;
    }

    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        switch(timeFlag) {
            case None -> setDisable(empty);
            case OnlyPast -> {
                LocalDate minDate = LocalDate.of(1992, 7, 1);
                setDisable(empty ||
                           date.isAfter(ChronoLocalDate.from(ZonedDateTime.now())) ||
                           date.isBefore(ChronoLocalDate.from(minDate)));

            }
            case OnlyFuture -> {
                LocalDate minDate = LocalDate.of(1992, 7, 1);
                setDisable(empty ||
                           date.isBefore(ChronoLocalDate.from(ZonedDateTime.now())) ||
                           date.isBefore(minDate));
            }
        }
    }
}

public class MyCalendar extends DateCell {
    static public Calendar CreateCalendar(CompareTime flag) {
        Calendar calendar = new Calendar((LocalDate) ChronoLocalDate.from(ZonedDateTime.now()));
        calendar.setDayCellFactory(c -> new CustomDateCell(flag));
        return calendar;
    }
}

