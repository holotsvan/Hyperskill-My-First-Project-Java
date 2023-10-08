package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        String earnedMessage = """
                Earned amount:
                Bubblegum: $202
                Toffee: $118
                Ice cream: $2250
                Milk chocolate: $1680
                Doughnut: $1075
                Pancake: $80
                """;

        System.out.println(earnedMessage+"\n");

        double income = extractNumbers(earnedMessage).stream().reduce(Integer::sum).orElse(0);
        System.out.format("Income: $%.2f%n",income);

        System.out.println("Staff expenses:");
        int staffExpenses = SCANNER.nextInt();
        System.out.println("Other expenses:");
        int otherExpenses = SCANNER.nextInt();

        System.out.format("Net income: $%s",income-staffExpenses-otherExpenses);
    }
    public static List<Integer> extractNumbers(String text) {
        List<Integer> numbers = new ArrayList<>();
        // Match numbers after '$'
        Pattern pattern = Pattern.compile("(?<=\\$)\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group();
            int number = Integer.parseInt(match);
            numbers.add(number);
        }
        return numbers;
    }
}