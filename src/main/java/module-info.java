module pl.kk.quizmon {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.logging;
    requires java.desktop;
    requires com.google.gson;
    requires com.google.common;
    requires java.sql;

    opens pl.kk.quizmon to javafx.fxml;
    opens pl.kk.quizmon.controllers to javafx.fxml, com.google.common;
    opens pl.kk.quizmon.controllers.components to javafx.fxml, com.google.common;
    opens pl.kk.quizmon.services to com.google.gson;

    exports pl.kk.quizmon;
    exports pl.kk.quizmon.controllers;
    exports pl.kk.quizmon.controllers.components;
    exports pl.kk.quizmon.events;
    exports pl.kk.quizmon.models;
    exports pl.kk.quizmon.infrastructure;
    exports pl.kk.quizmon.services;
}
