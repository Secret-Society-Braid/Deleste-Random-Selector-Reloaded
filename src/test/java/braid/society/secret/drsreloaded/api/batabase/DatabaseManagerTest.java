package braid.society.secret.drsreloaded.api.batabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import braid.society.secret.drsreloaded.api.database.IDatabaseManager;
import braid.society.secret.drsreloaded.api.database.IScraping;
import braid.society.secret.drsreloaded.api.database.Song;
import braid.society.secret.drsreloaded.internal.database.DatabaseManager;
import braid.society.secret.drsreloaded.internal.database.DatabaseUtil;
import braid.society.secret.drsreloaded.internal.database.Scraping;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseManagerTest {

  @AfterAll
  static void afterAll() throws IOException {
    Files.deleteIfExists(Path.of(DatabaseUtil.getDatabaseFileName()));
    Files.deleteIfExists(Path.of(DatabaseUtil.getLastUpdateDateRecordFileName()));
  }

  @Test
  void databaseTest() {
    try (MockedConstruction<Scraping> mock = Mockito.mockConstruction(Scraping.class)) {
      IDatabaseManager databaseManager = new DatabaseManager();
      IScraping scraping = mock.constructed().get(0);
      List<Song> songs = List.of(
          new Song("song1", "All", true, false, false, false, "2022-01-01"),
          new Song("song2", "Cu", false, true, false, false, "2022-01-02"),
          new Song("song3", "Co", false, false, true, false, "2022-01-03"),
          new Song("song4", "Pa", false, false, false, true, "2022-01-04"),
          new Song("song5", "All", false, false, false, false, "2022-01-05"),
          new Song("song6", "All", true, true, true, true, "2022-01-06")
      );
      when(scraping.scrape()).thenReturn(songs);
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      List<Song> songsFromDatabase = databaseManager.readLocalDatabase();
      String date = databaseManager.getLastUpdateDate();

      assertEquals(songs, songsFromDatabase);
      assertEquals(date, sdf.format(new Date()));

      assertTrue(Files.exists(Path.of(DatabaseUtil.getDatabaseFileName())));
      assertTrue(Files.exists(Path.of(DatabaseUtil.getLastUpdateDateRecordFileName())));

      verify(scraping, times(1)).scrape();
    }
  }
}
