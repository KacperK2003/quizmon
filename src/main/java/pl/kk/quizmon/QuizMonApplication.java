package pl.kk.quizmon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.kk.quizmon.infrastructure.ViewManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class QuizMonApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Properties config = prepareConfig();

        if (config == null) {
            Logger.getGlobal().severe("Failed to load configuration file!");
            Platform.exit();
            return;
        }

        int width = Integer.parseInt(config.getProperty("app.width"));
        int height = Integer.parseInt(config.getProperty("app.height"));
        String title = config.getProperty("app.title");

        Scene scene = prepareMainMenuScene(width, height);

        ViewManager.getInstance().setScene(scene);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private Properties prepareConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getResourceAsStream("config.properties")) {
            if (input == null) {
                return null;
            }
            properties.load(input);
            return properties;
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
            return null;
        }
    }

    private Scene prepareMainMenuScene(int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                ViewManager.View.MainMenu.getFileName()
        ));
        return new Scene(fxmlLoader.load(), width, height);
    }

    public static void main(String[] args) {
        launch();
    }
}