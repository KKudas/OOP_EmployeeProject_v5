package employee.version2;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDate(){
        String newDay = String.format("%02d", this.day);
        String newMonth = String.format("%02d", this.month);
        String date = newDay + "-" + newMonth + "-" + this.year;
        return date;
    }
}
