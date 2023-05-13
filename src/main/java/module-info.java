module braid.society.secret.drsreloaded {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.slf4j;
    requires lombok;
    requires jsr305;
    requires org.jsoup;
                            
    opens braid.society.secret.drsreloaded to javafx.fxml;
    exports braid.society.secret.drsreloaded;
  exports braid.society.secret.drsreloaded.internal.controller;
  opens braid.society.secret.drsreloaded.internal.controller to javafx.fxml;
}