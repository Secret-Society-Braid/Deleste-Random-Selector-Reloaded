module braid.society.secret.drsreloaded {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.slf4j;
  requires lombok;
  requires jsr305;
  requires org.jsoup;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.core;
  requires com.fasterxml.jackson.annotation;

  opens braid.society.secret.drsreloaded to javafx.fxml;
  exports braid.society.secret.drsreloaded;
  opens braid.society.secret.drsreloaded.api.database;
  exports braid.society.secret.drsreloaded.internal.settings;
  opens braid.society.secret.drsreloaded.internal.settings to com.fasterxml.jackson.databind;
  exports braid.society.secret.drsreloaded.internal.controller;
  opens braid.society.secret.drsreloaded.internal.controller to javafx.fxml;
}