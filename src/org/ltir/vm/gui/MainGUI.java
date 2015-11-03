/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.gui
 * File: MainGUI.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Nov 1, 2015, 9:14:10 PM
 */
package org.ltir.vm.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.ltir.vm.validmaker.ValidMakerJava;

/**
 *
 * @author <a href="mailto:akodadi.abdelhakim@gmail.com">Abdelhakim Akodadi</a>
 */
public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainGUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ValidMaker 1.0");
        Image VMIcon = new Image(getClass().getResourceAsStream("icons/vm.png"));
        primaryStage.getIcons().add(VMIcon);
        primaryStage.show();
        MainGUIController.initController(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValidMakerJava.main(args);
        launch(args);
    }

}
