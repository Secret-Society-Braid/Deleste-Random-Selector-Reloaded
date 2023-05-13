package braid.society.secret.drsreloaded.api.database;

import java.util.List;

public interface IDatabaseManager {

  List<Song> readLocalDatabase();

  void writeLocalDatabase(List<Song> songs);

  String getLastUpdateDate();

  void writeLastUpdateDate(String date);
}
