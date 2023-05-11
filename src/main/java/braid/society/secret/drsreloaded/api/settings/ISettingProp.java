package braid.society.secret.drsreloaded.api.settings;

public interface ISettingProp {

  String getKey();

  String getValue();

  void setValue(String value);

  String getComment();

  void setComment(String comment);

  default String getDefaultValue() {
    return "";
  }
}
