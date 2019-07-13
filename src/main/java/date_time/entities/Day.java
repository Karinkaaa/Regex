package main.java.date_time.entities;

public class Day {

    private int numInWeek;
    private int numInMonth;
    private String name = "";

    public Day() {
    }

    public Day(int numInWeek, int numInMonth, String name) {
        this.numInWeek = numInWeek;
        this.numInMonth = numInMonth;
        this.name = name;
    }

    public int getNumInWeek() {
        return numInWeek;
    }

    public void setNumInWeek(int numInWeek) {
        this.numInWeek = numInWeek;
    }

    public int getNumInMonth() {
        return numInMonth;
    }

    public void setNumInMonth(int numInMonth) {
        this.numInMonth = numInMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("DAY:\n");
        sb.append("\nNum in week: ").append(numInWeek);
        sb.append("\nNum in month: ").append(numInMonth);
        sb.append("\nName: ").append(name);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Day) {

            Day otherDay = (Day) obj;

            return otherDay.name.equals(this.name) &&
                    otherDay.numInWeek == this.numInWeek &&
                    otherDay.numInMonth == this.numInMonth;
        }
        return false;
    }
}
