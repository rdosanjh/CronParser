package com.raj.cronparser;

import com.raj.cronparser.models.CronResult;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("This application takes one argument. For more details enter help");
            return;
        }
        String input = args[0];

        if(input.equals("help")){
            showHelp();
            return;
        }

        String[] parts = input.split(" ");
        String command = parts[parts.length -1];
        String cron = String.join(" ",Arrays.copyOf(parts, parts.length-1));
        CronParser parser = new CronParser();

        CronResult result = parser.parse(cron);
        System.out.println(formatOutput("minute", result.getMinute()));
        System.out.println(formatOutput("hour", result.getHour()));
        System.out.println(formatOutput("day of month", result.getDayOfMonth()));
        System.out.println(formatOutput("month",result.getMonth()));
        System.out.println(formatOutput("day of week", result.getDayOfWeek()));
        System.out.println(formatOutput("command",command));
    }

    private static void showHelp(){
        System.out.println("This application takes one argument.");
        System.out.println("The layout should be {cron} {command}");
        System.out.println("For example: */15 0 1,15 * 1-5 /usr/bin/find");
    }

    private static String formatOutput(String title, int[] result){
        String spaces = getSpaces(title);
        String[] stringArray = Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new);
        String formatted = title + spaces + String.join(" ", stringArray);
        return formatted;
    }

    private static String getSpaces(String title) {
        int spacesAmount = 14 - title.length();
        return IntStream.range(0, spacesAmount)
                .mapToObj(x -> " ")
                .collect(Collectors.joining());

    }

    private static String formatOutput(String title, String result){
        String spaces = getSpaces(title);
        return title + spaces + result;
    }
}
