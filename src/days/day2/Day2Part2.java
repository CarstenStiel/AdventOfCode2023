package days.day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//AOC Day 2 Part 1
public class Day2Part2 {
    /**
     * Count lines from given File.
     * 
     * @return counter - counted lines of File.
     */
    public int readFromInputStream(String filePath) throws IOException {
        int result = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                Map<String, Integer> currentGame = new HashMap<>();
                currentGame.put("blue", 0);
                currentGame.put("red", 0);
                currentGame.put("green", 0);
                String[] splittedLine = line.split(": ");
                String[] drawings = splittedLine[1].split("; ");

                for (String drawing : drawings) {
                    for (String colorAndCube : drawing.split(", ")) {
                        String color = colorAndCube.split(" ")[1];
                        int cubes = Integer.parseInt(colorAndCube.split(" ")[0]);
                        currentGame.put(color, max(currentGame.get(color), cubes));
                    }
                }
                int ans = 1;
                for (String color : currentGame.keySet()) {
                    ans *= currentGame.get(color);
                }
                System.out.println(currentGame);
                System.out.println(ans);
                result += ans;
            }
            return result;
        }
    }

    public int max(int val1, int val2) {
        if (val1 == 0 || val1 < val2) {
            return val2;
        } else {
            return val1;
        }
    }

    public static void main(String[] args) throws Exception {
        Day2Part2 day2part2 = new Day2Part2();
        System.out.println(day2part2.readFromInputStream("src\\input\\day2.txt"));
    }
}