package days.day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;


//AOC Day 2 Part 1
public class Day2Part1 {
    /**
     * Count lines from given File.
     * @return counter - counted lines of File.
     */
    public int readFromInputStream(String filePath) throws IOException {
        int result = 0;
        Map<String, Integer> ans = Map.ofEntries(
            Map.entry("blue", 14),
            Map.entry("red", 12),
            Map.entry("green", 13)
        );
    
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splittedLine = line.split(": ");
                String[] drawings = splittedLine[1].split("; ");
                boolean achievable = true;
    
                for (String drawing : drawings) {
                    String[] colorsAndCubes = drawing.split(", ");
                    for (String colorAndCube : colorsAndCubes) {
                        String[] colorAndCubeSplit = colorAndCube.split(" ");
                        String color = colorAndCubeSplit[1].trim();
                        int cubes = Integer.parseInt(colorAndCubeSplit[0].trim());
                        if (ans.get(color) < cubes) {
                            achievable = false;
                            break;
                        }
                    }
                }
    
                if (achievable) {
                    int game = Integer.parseInt(splittedLine[0].split(" ")[1]);
                    result += game;
                }
            }
        }
    
        return result;
    }
    
    
    public static void main(String[] args) throws Exception {
        Day2Part1 day2part1 = new Day2Part1();
        System.out.println(day2part1.readFromInputStream("src\\input\\day2.txt"));
    }
}