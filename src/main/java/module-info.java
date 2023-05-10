module braid.society.secret.drsreloaded {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.slf4j;
    requires lombok;
    requires java.annotation;
    requires org.jsoup;
                            
    opens braid.society.secret.drsreloaded to javafx.fxml;
    exports braid.society.secret.drsreloaded;
}