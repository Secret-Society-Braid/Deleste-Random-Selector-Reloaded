package braid.society.secret.drsreloaded.api.settings;

import javax.annotation.Nonnull;

public interface ISettingProp {

  @Nonnull
  String getKey();

  boolean getValue();

  void setValue(boolean value);

  @Nonnull
  String getComment();

  void setComment(@Nonnull String comment);
}
