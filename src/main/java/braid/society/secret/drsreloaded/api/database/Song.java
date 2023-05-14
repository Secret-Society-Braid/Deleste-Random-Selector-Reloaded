package braid.society.secret.drsreloaded.api.database;

public record Song(String name, String type, boolean doesMasterPlusExist, boolean doesWitchExist,
                   boolean doesGrandExist, boolean doesSmartExist, String publishDate) {

}
