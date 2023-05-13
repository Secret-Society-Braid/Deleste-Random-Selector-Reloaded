package braid.society.secret.drsreloaded.internal.settings;

import braid.society.secret.drsreloaded.api.settings.ISettingManager;
import braid.society.secret.drsreloaded.api.settings.ISettingProp;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SettingManager implements ISettingManager {

  protected static final ObjectMapper MAPPER = new ObjectMapper();
  protected List<ISettingProp> settings;

  public SettingManager() {
    log.info("SettingManager created");
    this.settings = Collections.emptyList();
  }

  protected static List<ISettingProp> createDefaults() {
    return List.of(
        new SettingProp("enableAutoDatabaseUpdate", true,
            "アプリケーション起動時に自動的にデータベースを更新するかどうか"),
        new SettingProp("enableAutoAppVersionCheck", true,
            "アプリケーション起動時に自動的にアプリケーションのバージョンを確認するかどうか"),
        new SettingProp("enableIncludingAdvancedDifficulty", false,
            "Master+以上の高難易度を含めるかどうか"),
        new SettingProp("enableFetchingSongPropsFeature", true,
            "曲詳細情報を外部のAPIより取得する機能の有効化")
    );
  }

  @Nonnull
  @Override
  public List<ISettingProp> readSettings() {
    Path p = Path.of(SettingUtil.getSettingFileName());
    if (Files.notExists(p)) {
      log.info("Setting file not found. Creating default settings.");
      this.settings = createDefaults();
      this.writeSettings(this.settings);
    }

    try {
      this.settings = MAPPER.readValue(p.toFile(),
          MAPPER.getTypeFactory().constructCollectionType(List.class, SettingProp.class));
      return this.settings;
    } catch (IOException e) {
      log.error("Failed to read settings file.", e);
      return Collections.emptyList();
    }
  }

  @Override
  public void writeSettings(List<ISettingProp> settings) {
    Path p = Path.of(SettingUtil.getSettingFileName());
    try {
      MAPPER.writeValue(p.toFile(), settings);
    } catch (IOException e) {
      log.error("Failed to write settings file.", e);
    }
  }

  @Override
  public void writeSettings(ISettingProp setting) {
    List<ISettingProp> settings = this.readSettings();
    settings.removeIf(s -> s.getKey().equals(setting.getKey()));
    settings.add(setting);
    this.writeSettings(settings);
  }

}
