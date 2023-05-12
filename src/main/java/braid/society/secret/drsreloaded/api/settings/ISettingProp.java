package braid.society.secret.drsreloaded.api.settings;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ISettingProp {

  @Nonnull
  String getKey();

  @Nullable
  String getValue();

  void setValue(@Nullable String value);

  @Nonnull
  String getComment();

  void setComment(@Nonnull String comment);
}
