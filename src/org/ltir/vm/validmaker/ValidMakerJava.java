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
import org.ltir.vm.data.TreeNode;

public class ValidMakerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello ValidMaker!");
        GenericService gs = new GenericService("MPLS", "MPLS Generic Service");
        gs.addCommand(new TreeNode<Command>(new Command(Cardinality.CARD_1_0, null, "interface", null)));
        try {
            FileWriter fw = new FileWriter(new File("test.xml"));
            gs.serialize(fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        gs = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("test.xml"));
            gs = gs.deserializeGenericService(br);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
