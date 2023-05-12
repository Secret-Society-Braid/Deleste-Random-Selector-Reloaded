package braid.society.secret.drsreloaded.api.database;

import braid.society.secret.drsreloaded.internal.database.Song;

import javax.annotation.Nonnull;
import java.util.List;

public interface IListManipulation {

  @Nonnull
  List<Song> manipulate();

  IListManipulation setInGameDifficulty(String difficulty);

  IListManipulation setSongListLimit(int limit);
}
