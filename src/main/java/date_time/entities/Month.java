package main.java.date_time.entities;

import java.util.ArrayList;
import java.util.List;

public class Month {

    private String name = "";
    private int num;
    private int year;
    private List<Day> days;

    public Month() {
        days = new ArrayList<>();
    }

    public Month(String name, int num, int year, List<Day> days) {

        this.name = name;
        this.num = num;
        this.year = year;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("MONTH\n");
        sb.append("\nName: ").append(name);
        sb.append("\nNum: ").append(num);
        sb.append("\nYear: ").append(year);
        sb.append("\nDAYS:\n\n").append(days);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Month) {

            Month otherMonth = (Month) obj;

            return otherMonth.name.equals(this.name) &&
                    otherMonth.num == this.num &&
                    otherMonth.year == this.year;
        }
        return false;
    }
}
