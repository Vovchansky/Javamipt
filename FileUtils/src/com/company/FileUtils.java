package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class FileUtils implements AutoCloseable {
    private FileUtils() {
    }

    public static boolean exists(File path) {
        return path.exists();
    }

    public static boolean exists(String path) {
        return exists(new File(path));
    }

    @Override
    public void close() throws Exception {
    }

    public static List<String> readAll(File path) throws IOException {
        if (!exists(path)) throw new FileNotFoundException("File doesn`t exist");
        List<String> returnList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                returnList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }

    public static void writeAll(String path, List<String> lines) throws IOException {
        if (!exists(path)) throw new FileNotFoundException("File doesn`t exist");
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(path))) {
            ListIterator<String> iter = lines.listIterator();
            while (iter.hasNext())
                bf.write(iter.next());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
