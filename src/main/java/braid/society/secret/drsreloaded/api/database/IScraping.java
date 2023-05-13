package braid.society.secret.drsreloaded.api.database;

import java.util.List;

public interface IScraping {

  List<Song> scrape();

  String getUrl();

}
