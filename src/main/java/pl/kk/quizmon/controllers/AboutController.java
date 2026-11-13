package pl.kk.quizmon.controllers;

import javafx.fxml.FXML;
import pl.kk.quizmon.QuizMonApplication;
import pl.kk.quizmon.infrastructure.ViewManager;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.logging.Logger;

public class AboutController {
    @FXML
    protected void onBackButtonClick() {
        ViewManager.getInstance().switchView(ViewManager.View.MainMenu);
    }

    @FXML
    protected void onOFLButtonClick() {
        try (InputStream input = Objects.requireNonNull(
                QuizMonApplication.class.getResourceAsStream("fonts/Audiowide/OFL.txt")
        )) {
            Path tempFile = Files.createTempFile("OFL-", ".txt");
            tempFile.toFile().deleteOnExit();
            Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
            Desktop.getDesktop().open(tempFile.toFile());
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
