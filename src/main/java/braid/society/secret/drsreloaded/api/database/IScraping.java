package braid.society.secret.drsreloaded.api.database;

import braid.society.secret.drsreloaded.internal.database.Song;
import java.util.List;

public interface IScraping {

  List<Song> scrape();

  String getUrl();

}
