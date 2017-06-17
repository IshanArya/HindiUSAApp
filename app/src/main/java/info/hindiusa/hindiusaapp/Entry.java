package info.hindiusa.hindiusaapp;

/**
 * Created by ishanarya on 11/20/16.
 */

public class Entry {
    private int id;



    private String subject;
    private String message;
    private int month;
    private int date;
    private int year;
    private int hour;
    private int minute;

    public Entry() {

    }

    public Entry(int id, String subject, String message, int month, int date, int year, int hour, int minute) {

        this.id = id;
        this.message = message;
        this.month = month;
        this.date = date;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getFullDate() {
        return String.format("%d/%d/%d - %d:%d", month, date, year, hour, minute);
    }
}
