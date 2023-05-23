package braid.society.secret.drsreloaded.internal.controller;

import javafx.fxml.FXML;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class PopupController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private void initialize() {
    log.info("initialize PopUp WIndow");
  }
}
