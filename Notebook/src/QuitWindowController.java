import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class QuitWindowController {
    @FXML
    public Button yes;
    public Button no;
    public Button cancel;
    public Label quitLabel;

    private FileChooser fc = new FileChooser();

    public void yesClicked() throws IOException {
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
        System.exit(0);
    }

    public void noClicked() {
        System.exit(0);
    }

    public void cancelClicked() {
        MVC.getpStage().setScene(MVC.getpScene());
        MVC.getpStage().show();
        MVC.getpStage().setResizable(true);
    }
}
