package braid.society.secret.drsreloaded.api.settings;

import java.util.List;

public interface ISettingManager {

  List<ISettingProp> readSettings();

  void writeSettings(List<ISettingProp> settings);

  void writeSettings(ISettingProp setting);
}
