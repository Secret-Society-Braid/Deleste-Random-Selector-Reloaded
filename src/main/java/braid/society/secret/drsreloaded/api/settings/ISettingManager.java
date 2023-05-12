package braid.society.secret.drsreloaded.api.settings;

import javax.annotation.Nonnull;
import java.util.List;

public interface ISettingManager {

  @Nonnull
  List<ISettingProp> readSettings();

  void writeSettings(List<ISettingProp> settings);

  void writeSettings(ISettingProp setting);
}
