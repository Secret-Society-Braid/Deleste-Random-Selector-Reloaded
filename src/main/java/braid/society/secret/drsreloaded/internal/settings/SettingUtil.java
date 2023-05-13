package braid.society.secret.drsreloaded.internal.settings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SettingUtil {

  private static final String SETTING_FILE_NAME = "settings.json";

  public static String getSettingFileName() {
    return SETTING_FILE_NAME;
  }
}
