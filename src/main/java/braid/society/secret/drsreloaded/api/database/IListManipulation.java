package braid.society.secret.drsreloaded.api.database;

import braid.society.secret.drsreloaded.internal.database.Song;
import java.util.List;

public interface IListManipulation {

  List<Song> manipulate();

  IListManipulation setInGameDifficulty(String difficulty);

  IListManipulation setSongListLimit(int limit);
}
