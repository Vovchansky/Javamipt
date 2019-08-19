import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class NotebookController {
    @FXML
    public RadioMenuItem exit;
    public RadioMenuItem save;
    public RadioMenuItem saveAs;
    public RadioMenuItem create;
    public RadioMenuItem open;
    public TextArea text;

    private String oldText = "";
    private FileChooser fc = new FileChooser();
    public boolean isSaved = false;
    public File myFile;

    public void exitClicked() {
        System.exit(0);
    }

    public void openClicked() throws IOException {
        fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fc.getExtensionFilters().add(filter);
        Stage newStage = MVC.getpStage();
        myFile = fc.showOpenDialog(newStage);
        newStage.setTitle(myFile.getName() + " - Блокнот");
        List<String> lines = FileUtils.readAll(myFile);
        text.setText("");
        int i = 0;
        while (i < lines.size()) {
            String tempText = text.getText();
            text.setText(tempText + lines.get(i++));
        }
        oldText = text.getText();
    }

    public void createClicked() {
        Stage newStage = MVC.getpStage();
        newStage.setTitle("Безымянный - Блокнот");
        text.setText("");
    }

    public void saveClicked() throws IOException {
        if (MVC.noteCtrl.myFile == null) {
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fc.getExtensionFilters().add(filter);
            File file = fc.showSaveDialog(MVC.getpStage());
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.println(MVC.noteCtrl.text.getText());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FileUtils.writeAll(MVC.noteCtrl.myFile, Arrays.asList(MVC.noteCtrl.text.getText()));
        }
        isSaved = true;
    }

    public void saveAsClicked() {
        String textToWrite = MVC.noteCtrl.text.getText();
        if (MVC.noteCtrl.myFile == null) {
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fc.getExtensionFilters().add(filter);
            File file = fc.showSaveDialog(MVC.getpStage());
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.println(textToWrite);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isSaved = true;
        }
    }

    public String getOldText() {
        return oldText;
    }
}
