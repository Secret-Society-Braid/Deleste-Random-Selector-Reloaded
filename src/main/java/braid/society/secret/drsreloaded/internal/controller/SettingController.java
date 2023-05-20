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

  @FXML // fx:id="chkboxEnableDebuggingFeature"
  private CheckBox chkboxEnableDebuggingFeature; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxEnableFetchingSongPropFeature"
  private CheckBox chkboxEnableFetchingSongPropFeature; // Value injected by FXMLLoader

  @FXML // fx:id="chkboxEnableIncludingHigherDifficulty"
  private CheckBox chkboxEnableIncludingHigherDifficulty; // Value injected by FXMLLoader

  @FXML // fx:id="enableAutoFetchingSongProp"
  private CheckBox enableAutoFetchingSongProp; // Value injected by FXMLLoader

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
    assert btnCancel
        != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'setting.fxml'.";
    assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'setting.fxml'.";
    assert chkboxAutoAppVersionCheck
        != null : "fx:id=\"chkboxAutoAppVersionCheck\" was not injected: check your FXML file 'setting.fxml'.";
    assert chkboxEnableAutoDatabaseUpdate
        != null : "fx:id=\"chkboxEnableAutoDatabaseUpdate\" was not injected: check your FXML file 'setting.fxml'.";
    assert chkboxEnableDebuggingFeature
        != null : "fx:id=\"chkboxEnableDebuggingFeature\" was not injected: check your FXML file 'setting.fxml'.";
    assert chkboxEnableFetchingSongPropFeature
        != null : "fx:id=\"chkboxEnableFetchingSongPropFeature\" was not injected: check your FXML file 'setting.fxml'.";
    assert chkboxEnableIncludingHigherDifficulty
        != null : "fx:id=\"chkboxEnableIncludingHigherDifficulty\" was not injected: check your FXML file 'setting.fxml'.";
    assert enableAutoFetchingSongProp
        != null : "fx:id=\"enableAutoFetchingSongProp\" was not injected: check your FXML file 'setting.fxml'.";
    assert labelBottomCaution
        != null : "fx:id=\"labelBottomCaution\" was not injected: check your FXML file 'setting.fxml'.";

    log.debug("initialized resources: {}", resources);
    log.debug("initialized location: {}", location);

    this.isNoneCheckboxStatusChanged = true;
    this.settingManager = new SettingManager();
    this.settingProps = this.settingManager.readSettings();

  }
}
