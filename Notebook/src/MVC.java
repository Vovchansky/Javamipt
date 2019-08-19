import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MVC extends Application {
    private static Stage pStage;
    public static Scene pScene;
    public static QuitWindowController quitCtrl;
    public static NotebookController noteCtrl;

    public static Stage getpStage() {
        return pStage;
    }

    public static void setpStage(Stage pStage) {
        MVC.pStage = pStage;
    }

    public static Scene getpScene() {
        return pScene;
    }

    public static void setpScene(Scene pScene) {
        MVC.pScene = pScene;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setpStage(primaryStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotebookView.fxml"));
        Parent root = loader.load();
        noteCtrl = loader.getController();
        noteCtrl.text.setText("");
        Scene scene = new Scene(root);
        setpScene(scene);
        primaryStage.setTitle("Новый текстовый документ");
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getWindow().setOnCloseRequest(ev -> {
            if (noteCtrl.isSaved) {
                System.exit(0);
            }
            if (isChanged()) {
                try {
                    setQuitStage();
                    ev.consume();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Platform.setImplicitExit(true);
            }
        });
    }

    public static boolean isChanged() {
        return !noteCtrl.text.getText().equals(noteCtrl.getOldText());
    }

    public static void setQuitStage() throws IOException {
        FXMLLoader newLoader = new FXMLLoader(MVC.class.getResource("QuitWindow.fxml"));
        Parent newRoot = newLoader.load();
        quitCtrl = newLoader.getController();
        Scene newScene = new Scene(newRoot);
        getpStage().setTitle("Блокнот");
        getpStage().setScene(newScene);
        getpStage().setResizable(false);
        if (isChanged() && noteCtrl.myFile == null) {
            quitCtrl.quitLabel.setText("Вы хотите сохранить изменения в файле Безымянный?");
        } else if (isChanged()) {
            quitCtrl.quitLabel.setText("Вы хотите сохранить изменения в файле " + noteCtrl.myFile.getAbsolutePath() + "?");
        } else {
            Platform.setImplicitExit(true);
        }
        getpStage().show();
    }

}