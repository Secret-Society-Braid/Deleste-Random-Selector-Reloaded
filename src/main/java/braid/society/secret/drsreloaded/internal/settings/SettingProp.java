package braid.society.secret.drsreloaded.internal.settings;

import braid.society.secret.drsreloaded.api.settings.ISettingProp;
import javax.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SettingProp implements ISettingProp {

  protected final String key;
  protected boolean value;
  protected String comment;

  public SettingProp(String key) {
    log.debug("new setting prop with key: {}", key);
    this.key = key;
  }

  public SettingProp(@Nonnull String key, boolean value, @Nonnull String comment) {
    log.debug("new setting prop with key: {}, value: {}, comment: {}", key, value, comment);
    this.key = key;
    this.value = value;
    this.comment = comment;
  }

  @Nonnull
  @Override
  public String getKey() {
    return this.key;
  }

  @Override
  public boolean getValue() {
    return this.value;
  }

  @Override
  public void setValue(boolean value) {
    this.value = value;
  }

  @Nonnull
  @Override
  public String getComment() {
    return this.comment;
  }

  @Override
  public void setComment(@Nonnull String comment) {
    this.comment = comment;
  }
}
