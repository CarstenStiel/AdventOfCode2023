package days.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//AOC Day 1
public class Day1Part1 {

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
        List<String> split = new ArrayList<>();

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                split.add(String.valueOf(c));
            } 
        }
        return split;
    }

    public int stringToInt(String number) {
        int result = 0;

        if(number.length() == 1){
            result = Integer.parseInt(number);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Day1Part1 day1part1 = new Day1Part1();
        System.out.println(day1part1.readFromInputStream("src\\input\\day1.txt"));
    }
}