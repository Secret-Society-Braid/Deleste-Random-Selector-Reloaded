package braid.society.secret.drsreloaded.api.database;

import braid.society.secret.drsreloaded.internal.database.Song;

import java.util.List;

public interface IDatabaseManager {

  List<Song> readLocalDatabase();

  void writeLocalDatabase(List<Song> songs);

  String getLastUpdateDate();

  void writeLastUpdateDate(String date);
}
