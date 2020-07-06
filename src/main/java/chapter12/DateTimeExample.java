package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @Author ZhangGJ
 * @Date 2020/07/06 07:59
 */
public class DateTimeExample {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 8);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();

        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        LocalDate today = LocalDate.now();

        int year1 = date.get(ChronoField.YEAR);
    }
}
