package days.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//AOC Day 1
public class Day1Part2 {

    /**
     * Count lines from given File.
     * @return counter - counted lines of File.
     */
    public int readFromInputStream(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        int result = 0;
        try (BufferedReader br
        = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                result += stringToInt(splitString(line).get(0)) * 10 + stringToInt(splitString(line).get(splitString(line).size()-1));
            }
        }
        return result;
    }

    public static List<String> splitString(String line) {
        List<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
        List<String> split = new ArrayList<>();
        String current = "";

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                split.add(String.valueOf(c));
            } 
            else {
                current += c;
                for (String number : numbers) {
                    if (current.contains(number)) {
                        split.add(number);
                        current = current.substring(current.length()-1);
                    }
                }
            }
        }

        return split;
    }

    public int stringToInt(String number) {
        int result = 0;

        if(number.length() == 1){
            result = Integer.parseInt(number);
        }
        else
        {
            switch (number) {
                case "one":
                    result = 1;
                    break;
                case "two":
                    result = 2;
                    break;
                case "three":
                    result = 3;
                    break;
                case "four":
                    result = 4;
                    break;
                case "five":
                    result = 5;
                    break;
                case "six":
                    result = 6;
                    break;
                case "seven":
                    result = 7;
                    break;
                case "eight":
                    result = 8;
                    break;
                case "nine":
                    result = 9;
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Day1Part2 day1part2 = new Day1Part2();
        System.out.println(day1part2.readFromInputStream("src\\input\\day1.txt"));
    }
}