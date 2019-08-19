package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSVReader {

    public List<String> readingCSV(String fileName){
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()){
                String data = inputStream.next();
                String[] values = data.split(",");
                double closingPrice = Double.parseDouble(values[1]);


                lines.add(String.valueOf(closingPrice));
            }

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
        /*for (String line : lines){
            System.out.println(line);
        }*/
    }
}
