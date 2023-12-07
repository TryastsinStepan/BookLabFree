package org.example.Lab2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.lang.Integer.parseInt;
import static java.time.temporal.ChronoUnit.DAYS;
/*Создать класс для работы с датой в формате «год.месяц.день». Данные хранятся в
переменных уровня класса: год, месяц, день – целые числа. При разработке класса
использовать рекомендованные правилами инкапсуляции спецификаторы доступа.
Создать минимум 3 конструктора, позволяющих задавать дату строкой, числами и
другой датой.
Реализовать методы:
• добавление дней к дате;
• вычитание дней из даты;
• сравнение дат;
• вычисление количества дней между датами.*/
public class MyDate {
    private int day;
    private int month;
    private int year;
    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public MyDate(String day, String month, String year) {
        this.day = parseInt(day);
        this.month = parseInt(month);
        this.year = parseInt(year);
    }
    public MyDate(String date) {
        String[] parts = date.split("\\.");
        year = parseInt(parts[0]);
        month = parseInt(parts[1]);
        day = parseInt(parts[2]);
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String addDate(int day) {
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("YYYY.MM.dd");
        LocalDate date = LocalDate.of(this.day,month,year);
        return date.plusDays(day).format(dateformatter);
    }
    public String minusDate(int day) {
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("YYYY.MM.dd");
        LocalDate date = LocalDate.of(this.day,month,year);
        return date.minusDays(day).format(dateformatter);
    }
    public String compareDate(MyDate date1, MyDate date2){
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("YYYY.MM.dd");
        LocalDate d1 = LocalDate.of(date1.day,date1.month,date1.year);
        LocalDate d2 = LocalDate.of(date2.day,date2.month,date2.year);
        d1.format(dateformatter);
        d2.format(dateformatter);
        int result = d1.compareTo(d2);
        if(result == 0)
            return "Both dates are equal";
        else if (result < 0)
            return "Date1 is before Date2";
        else
            return "Date1 is after Date2";
    }
    public static long beetDay(MyDate date1, MyDate date2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        LocalDate d1 = LocalDate.of(date1.day,date1.month,date1.year);
        LocalDate d2 = LocalDate.of(date2.day,date2.month,date2.year);
        long daysBetween = DAYS.between(d1, d2);
        return daysBetween;
    }
    @Override
    public String toString() {
        return
                "<<" + day +
                        "." + month +
                        "." + year +
                        ">>";

    }
}
