package braid.society.secret.drsreloaded.internal.database;

import java.io.File;

public class DatabaseUtil {

  private static final String DB_DIR = "database";

  public static String getLastUpdateDateRecordFileName() {
    return DB_DIR.concat(File.pathSeparator).concat("lastDatabaseUpdateDate");
  }

  public static String getDatabaseFileName() {
    return DB_DIR.concat(File.pathSeparator).concat("database.json");
  }

  public static String getDatabaseDir() {
    return DB_DIR;
  }

  public static String getScrapingSiteLink() {
    return "https://gamerch.com/imascg-slstage-wiki/entry/515998";
  }
}
