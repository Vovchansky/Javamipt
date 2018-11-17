package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(FileUtils.readAll(new File("src/com/company/input")));
            List<String> lines = Arrays.asList("XO4Y B C6EP6AHK!");
            FileUtils.writeAll("src/com/company/output", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
