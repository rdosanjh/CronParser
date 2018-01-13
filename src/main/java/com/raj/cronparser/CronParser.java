package com.raj.cronparser;

import com.raj.cronparser.models.CronResult;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CronParser {
    public CronResult parse(String expression){
        String[] parts = expression.split(" ");

        return new CronResult(
                parseMins(parts[0]),
                parseHour(parts[1]),
                parseDayOfMonth(parts[2]),
                new int[0],
                new int[0],
                parts[5]
                );
    }

    private int[] parseDayOfMonth(String expression) {
        int[] all = IntStream.iterate(0, n -> n + 1).limit(31).toArray();
        if(expression.equals("*")){
            return all;
        }
        if(expression.contains(",")){
            String[] days = expression.split(",");
            return Arrays.stream(days).mapToInt(Integer::parseInt).toArray();
        }
        return new int[]{Integer.parseInt(expression)};
    }

    private int[] parseMins(String expression){
        int[] all = IntStream.iterate(0, n -> n + 1).limit(60).toArray();

        if(expression.equals("*")){
            return all;
        }
        if(expression.contains("/")){
            String[] parts = expression.split("/");
            int factor = Integer.parseInt(parts[1]);
            int[] mins = IntStream.iterate(0, n -> n + factor).limit(60/factor).toArray();
            return mins;
        }
        return new int[]{Integer.parseInt(expression)};
    }

    private int[] parseHour(String expression){
        int[] all = IntStream.iterate(0, n -> n + 1).limit(24).toArray();
        if(expression.equals("*")){
            return all;
        }
        if(expression.contains("/")){
            String[] parts = expression.split("/");
            int[] hours = IntStream.iterate(0, n -> n + Integer.parseInt(parts[1])).limit(24).toArray();
            return hours;
        }
        return new int[]{Integer.parseInt(expression)};
    }

}
