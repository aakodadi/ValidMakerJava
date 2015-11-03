/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.gui
 * File: MainGUIController.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Nov 1, 2015, 9:14:38 PM
 */
package org.ltir.vm.gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author <a href="mailto:akodadi.abdelhakim@gmail.com">Abdelhakim Akodadi</a>
 */
public class MainGUIController implements Initializable {

    private static Window primaryWindow;
    private static Stage primaryStage;
    private static Scene primaryScene;
    public TreeView<String> networksTreeView;
    public TextArea outputTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public static void initController(Stage stage) {
        primaryStage = stage;
        primaryScene = stage.getScene();
        primaryWindow = primaryScene.getWindow();
    }

    public void newFileAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(primaryWindow);
        if (file != null) {
            System.out.println(file.getAbsolutePath());
            outputln("[NOTE] " + file.getAbsolutePath() + " was selected.");
        }

        TreeItem<String> root = new TreeItem();
        root.setExpanded(true);

        TreeItem<String> network = addBranch("Net1", root);
        TreeItem<String> genericServices = addBranch("Generic Services", network);
        TreeItem<String> serviceInstences = addBranch("Service Instences", network);
        TreeItem<String> serviceFamilies = addBranch("Service Families", network);

        addBranch("GS MPLS", genericServices);
        addBranch("GS VLAN", genericServices);

        addBranch("SI MPLS - 1", serviceInstences);
        addBranch("SI MPLS - 2", serviceInstences);
        addBranch("SI MPLS - 3", serviceInstences);

        addBranch("SI VLAN - 1", serviceInstences);
        addBranch("SI VLAN - 2", serviceInstences);
        addBranch("SI VLAN - 3", serviceInstences);
        addBranch("SI VLAN - 4", serviceInstences);

        networksTreeView.setRoot(root);
        networksTreeView.setShowRoot(false);
        outputln("[NOTE] Networks Tree Rendred.");
    }

    private TreeItem<String> addBranch(String text, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(text);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    private void outputln(String line) {
        output(line + "\n");
    }

    private void output(String line) {
        outputTextArea.appendText(line);
    }
}
