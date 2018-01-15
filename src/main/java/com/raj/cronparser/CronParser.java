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
                parseMonth(parts[3]),
                parseDayOfWeek(parts[4])
                );
    }

    private int[] parseDayOfWeek(String expression){
        return parseGeneral(expression,1,7);
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
        return parseGeneral(expression, 0, 24);
    }

    private int[] parseMonth(String expression){
        return parseGeneral(expression, 1, 12);

    }

    private int[] parseGeneral(String expression, int seed, int max){
        int[] all = IntStream.iterate(seed, n -> n + 1).limit(max).toArray();
        if(expression.equals("*")){
            return all;
        }
        if(expression.contains("-")){
            String[] parts = expression.split("-");
            return IntStream.rangeClosed(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))
                    .toArray();
        }
        if(expression.contains("/")){
            String[] parts = expression.split("/");
            int[] hours = IntStream.iterate(seed, n -> n + Integer.parseInt(parts[1]))
                    .limit(max).toArray();
            return hours;
        }
        return new int[]{Integer.parseInt(expression)};

    }
}
