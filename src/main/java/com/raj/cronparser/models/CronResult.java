package com.raj.cronparser.models;

public class CronResult {
    private int[] minute;
    private int[] hour;
    private int[] dayOfMonth;
    private int[] month;
    private int[] dayOfWeek;

    public CronResult(int[] minute, int[] hour, int[] dayOfMonth, int[] month, int[] dayOfWeek) {
        this.minute = minute;
        this.hour = hour;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
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


//    public void setCommand(String command) {
//        this.command = command;
//    }
}
