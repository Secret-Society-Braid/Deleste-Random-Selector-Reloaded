package braid.society.secret.drsreloaded.internal.database;

import braid.society.secret.drsreloaded.api.database.IDatabaseManager;
import braid.society.secret.drsreloaded.api.database.IScraping;
import braid.society.secret.drsreloaded.api.database.Song;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatabaseManager implements IDatabaseManager {

  protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  protected static final ObjectMapper MAPPER = new ObjectMapper();

  public DatabaseManager() {
    log.info("Start initializing database manager.");
    Path dbPath = Path.of(DatabaseUtil.getDatabaseFileName());
    if (Files.notExists(dbPath)) {
      log.info("No database file found. Creating new one.");
      IScraping scraping = new Scraping();
      List<Song> data = scraping.scrape();
      this.writeLocalDatabase(data);
    }
  }

  @Override
  public String getLastUpdateDate() {
    // check if file exists
    Path path = Path.of(DatabaseUtil.getLastUpdateDateRecordFileName());
    if (Files.notExists(path)) {
      log.warn("No last update date record found. Returning empty string.");
      return "";
    }
    return readFirstLine(path);
  }

  @Override
  public void writeLocalDatabase(List<Song> songs) {
    Path path = Path.of(DatabaseUtil.getDatabaseFileName());
    try {
      MAPPER.writeValue(path.toFile(), songs);
      // set last update date
      this.writeLastUpdateDate(DATE_FORMAT.format(new Date()));
    } catch (IOException e) {
      log.error("Error while writing local database.", e);
    }
  }

  @Override
  public List<Song> readLocalDatabase() {
    Path path = Path.of(DatabaseUtil.getDatabaseFileName());
    try {
      return MAPPER.readValue(path.toFile(),
          MAPPER.getTypeFactory().constructCollectionType(List.class, Song.class));
    } catch (IOException e) {
      log.error("Error while reading local database.", e);
      return Collections.emptyList();
    }
  }

  @Override
  public void writeLastUpdateDate(String date) {
    Path path = Path.of(DatabaseUtil.getLastUpdateDateRecordFileName());
    try {
      Files.writeString(path, date);
    } catch (IOException e) {
      log.error("Error while writing last update date record.", e);
    }
  }

  protected String readFirstLine(Path path) {
    try (Stream<String> stream = Files.lines(path)) {
      return stream.findFirst().orElse("");
    } catch (IOException e) {
      log.error("Error while reading last update date record.", e);
      return "";
    }
  }
}
