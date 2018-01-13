package com.raj.cronparser.models;

public class CronResult {
    private int[] minute;
    private int[] hour;
    private int[] dayOfMonth;
    private int[] month;
    private int[] dayOfWeek;
    private String command;

    public CronResult(int[] minute, int[] hour, int[] dayOfMonth, int[] month, int[] dayOfWeek, String command) {
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.command = command;
    }

    public int[] getMinute() {
        return minute;
    }

//    public void setMinute(int[] minute) {
//        this.minute = minute;
//    }

    public int[] getHour() {
        return hour;
    }

//    public void setHour(int[] hour) {
//        this.hour = hour;
//    }

    public int[] getDayOfMonth() {
        return dayOfMonth;
    }

//    public void setDayOfMonth(int[] dayOfMonth) {
//        this.dayOfMonth = dayOfMonth;
//    }

    public int[] getMonth() {
        return month;
    }

//    public void setMonth(int[] month) {
//        this.month = month;
//    }

    public int[] getDayOfWeek() {
        return dayOfWeek;
    }

//    public void setDayOfWeek(int[] dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }

    public String getCommand() {
        return command;
    }

//    public void setCommand(String command) {
//        this.command = command;
//    }
}
