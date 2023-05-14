package braid.society.secret.drsreloaded.api.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import braid.society.secret.drsreloaded.internal.settings.SettingManager;
import braid.society.secret.drsreloaded.internal.settings.SettingUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SettingManagerTest {

  @AfterAll
  static void afterAll() throws IOException {
    Files.deleteIfExists(Path.of(SettingUtil.getSettingFileName()));
  }

  @Test
  void test() {
    ISettingManager settingManager = new SettingManager();

    List<ISettingProp> list = settingManager.readSettings();

    assertEquals(4, list.size());
    assertTrue(Files.exists(Path.of(SettingUtil.getSettingFileName())));
  }
}
