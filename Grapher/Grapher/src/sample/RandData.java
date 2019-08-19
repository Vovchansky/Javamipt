package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class RandData {

    public static void makeData(){
        try (PrintWriter writer = new PrintWriter(new File("src/sample/test.csv"))) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 100; i++){
                Random rnd = new Random();
                int number = rnd.nextInt(100);
                sb.append(i);
                sb.append(",");
                sb.append(number);
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
