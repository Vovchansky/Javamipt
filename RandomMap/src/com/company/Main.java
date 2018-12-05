package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        try (FileIterator File = new FileIterator("src/com/company/words")) {
            String lineFromWords = File.next();
            String[] separatedLine = lineFromWords.split(" ");
            int linesLength = RandomUtils.generateNumber();
            int counter = 0;
            while (counter < separatedLine.length) {
                lines.add(separatedLine[counter]);
                counter++;
            }
        } catch (IOException e) {
            System.err.println(e);
            throw new FileNotFoundException("File doesn`t exist");
        }
        List<String> words = RandomUtils.generateStringArrayFrom(lines);
        int[] numbers = RandomUtils.generateIntArray();
        Map randomMap = new HashMap();
        if (numbers.length > words.size()) {
            for (int i = 0; i < numbers.length; i++)
                randomMap.put(numbers[i], (i < words.size()) ? words.get(i) : null);
        } else {
            for (int i = 0; i < words.size(); i++)
                randomMap.put(words.get(i), (i < numbers.length) ? numbers[i] : null);
        }
        randomMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
