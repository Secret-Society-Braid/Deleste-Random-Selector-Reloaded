package braid.society.secret.drsreloaded.internal.controller;

import braid.society.secret.drsreloaded.HelloApplication;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        try {
            showSettingWindow();
        } catch (IOException e) {
            log.error("Error while showing setting window", e);
            throw new RuntimeException(e);
        }
    }

    void showSettingWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("popup.fxml"));
        Scene settingScene = new Scene(fxmlLoader.load());
        settingScene.getStylesheets().add(
            Objects.requireNonNull(HelloApplication.class.getResource("style/setting.css"))
                .toExternalForm());
        Stage settingStage = new Stage();
        settingStage.initStyle(StageStyle.UNDECORATED);
        settingStage.setScene(settingScene);
        settingStage.showAndWait();
    }
}