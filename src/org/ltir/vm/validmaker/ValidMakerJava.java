/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: ValidMakerJava.java
 * Brief: The main program
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 25, 2015, 12:21:00 AM
 */
package org.ltir.vm.validmaker;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ltir.vm.data.Cardinality;
import org.ltir.vm.data.Command;
import org.ltir.vm.data.GenericService;
import org.ltir.vm.data.Network;
import org.ltir.vm.data.TreeNode;

public class ValidMakerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello ValidMaker!");
        TreeNode<String> tree = new TreeNode<>("zero");
        tree.setRoot(tree);
        TreeNode<String> oneNode;
        TreeNode<String> twoNode;
        tree.add(oneNode = new TreeNode<>("one"));
        tree.add(twoNode = new TreeNode<>("two"));
        tree.add(new TreeNode<>("three"));
        oneNode.add(new TreeNode<>("one-one"));
        oneNode.add(new TreeNode<>("one-two"));
        twoNode.add(new TreeNode<>("two-one"));
        twoNode.add(new TreeNode<>("two-two"));
        twoNode.add(tree);
        
        try {
            FileWriter fw = new FileWriter(new File("test.xml"));
            tree.serialize(fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tree = null;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.xml"));
            tree = tree.deserializeTree(br);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (TreeNode<String> node : tree) {
            System.out.println(node.getElement());
            for (TreeNode<String> innernode : node) {
                System.out.println("-" + innernode.getElement());
                for (TreeNode<String> innerinnernode : innernode) {
                    System.out.println("--" + innerinnernode.getElement());
                }
            }
        }
        
        Network n = new Network("UQAM", "UQAM LAN Network", ".");
        GenericService gs = new GenericService("Switching", "Switching Parameters");
        Command c = new Command(Cardinality.CARD_1_0, null, "interface", null);
        gs.addCommand(new TreeNode<Command>(c));
        n.addGenericService(gs);
        
        
        try {
            FileWriter fw = new FileWriter(new File("uqam_network.xml"));
            n.serialize(fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        n = null;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("uqam_network.xml"));
            n =  n.deserializeNetwork(br);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
