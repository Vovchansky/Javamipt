import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class FileUtils {
    private FileUtils() {
    }

    public static boolean exists(File path) {
        return path.exists();
    }

    public static List<String> readAll(File path) throws IOException {
        if (!exists(path)) throw new FileNotFoundException("File doesn`t exist");
        List<String> returnList = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                returnList.add(line);
                returnList.add("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }

    public static void writeAll(File path, List<String> lines) throws IOException {
        if (!exists(path)) throw new FileNotFoundException("File doesn`t exist");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            ListIterator<String> iter = lines.listIterator();
            while (iter.hasNext())
                bw.write(iter.next());
        }
    }
}
