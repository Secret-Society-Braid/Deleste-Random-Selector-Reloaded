package braid.society.secret.drsreloaded.internal.controller;

import braid.society.secret.drsreloaded.api.settings.ISettingManager;
import braid.society.secret.drsreloaded.api.settings.ISettingProp;
import braid.society.secret.drsreloaded.internal.settings.SettingManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SettingController {

  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;

  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;

  @FXML // fx:id="btnCancel"
  private Button btnCancel; // Value injected by FXMLLoader

  @FXML // fx:id="btnOk"
  private Button btnOk; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxAutoAppVersionCheck"
  private CheckBox chkboxAutoAppVersionCheck; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxEnableAutoDatabaseUpdate"
  private CheckBox chkboxEnableAutoDatabaseUpdate; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxEnableFetchingSongPropFeature"
  private CheckBox chkboxEnableFetchingSongPropFeature; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxEnableIncludingHigherDifficulty"
  private CheckBox chkboxEnableIncludingHigherDifficulty; // Value injected by FXMLLoader

  @FXML // fx:id="labelBottomCaution"
  private Label labelBottomCaution; // Value injected by FXMLLoader

  private boolean isNoneCheckboxStatusChanged = true;
  private ISettingManager settingManager;
  private List<ISettingProp> settingProps;

  @FXML
  void onBtnCancelPressed(ActionEvent event) {
    log.info("btnCancel pressed");
    log.info("triggered event status: {}", event);
    Scene scene = btnCancel.getScene();
    scene.getWindow().hide();
  }

  @FXML
  void onBtnOkPressed(ActionEvent event) {

    if (this.isNoneCheckboxStatusChanged) {
      log.info("no checkbox status changed");
      log.info("triggered event status: {}", event);
    } else {
      log.info("some checkbox status changed");
      log.info("triggered event status: {}", event);
      this.settingProps.stream().filter(prop -> prop.getKey().equals("enableAutoAppVersionCheck"))
          .findFirst().orElseThrow().setValue(this.chkboxAutoAppVersionCheck.isSelected());
      this.settingProps.stream().filter(prop -> prop.getKey().equals("enableAutoDatabaseUpdate"))
          .findFirst().orElseThrow().setValue(this.chkboxEnableAutoDatabaseUpdate.isSelected());
      this.settingProps.stream()
          .filter(prop -> prop.getKey().equals("enableFetchingSongPropsFeature")).findFirst()
          .orElseThrow().setValue(this.chkboxEnableFetchingSongPropFeature.isSelected());
      this.settingProps.stream()
          .filter(prop -> prop.getKey().equals("enableIncludingHigherDifficulty")).findFirst()
          .orElseThrow().setValue(this.chkboxEnableIncludingHigherDifficulty.isSelected());
      this.settingManager.writeSettings(this.settingProps);
    }

    log.info("attempt to close setting window");
    Scene scene = btnOk.getScene();
    scene.getWindow().hide();
  }

  @FXML
  void onCheckboxStatusChanged(ActionEvent event) {
    log.info("some checkbox status changed");
    log.info("triggered event status: {}", event);
    this.isNoneCheckboxStatusChanged = false;
    this.labelBottomCaution.setText("変更はアプリ再起動後に有効となります");
  }

  @FXML
    // This method is called by the FXMLLoader when initialization is complete
  void initialize() {
    log.debug("initialized resources: {}", resources);
    log.debug("initialized location: {}", location);

    this.isNoneCheckboxStatusChanged = true;
    this.settingManager = new SettingManager();
    this.settingProps = this.settingManager.readSettings();
    // set current setting values
    this.chkboxAutoAppVersionCheck.setSelected(
        this.settingProps.stream().filter(prop -> prop.getKey().equals("enableAutoAppVersionCheck"))
            .findFirst().orElseThrow().getValue());
    this.chkboxEnableAutoDatabaseUpdate.setSelected(
        this.settingProps.stream().filter(prop -> prop.getKey().equals("enableAutoDatabaseUpdate"))
            .findFirst().orElseThrow().getValue());
    this.chkboxEnableFetchingSongPropFeature.setSelected(this.settingProps.stream()
        .filter(prop -> prop.getKey().equals("enableFetchingSongPropsFeature")).findFirst()
        .orElseThrow().getValue());
    this.chkboxEnableIncludingHigherDifficulty.setSelected(this.settingProps.stream()
        .filter(prop -> prop.getKey().equals("enableIncludingHigherDifficulty")).findFirst()
        .orElseThrow().getValue());
  }
}
