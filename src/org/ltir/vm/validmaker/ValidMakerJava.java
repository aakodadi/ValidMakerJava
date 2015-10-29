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
import org.ltir.vm.data.CLIReference;
import org.ltir.vm.data.Cardinality;
import org.ltir.vm.data.Command;
import org.ltir.vm.data.CommandType;
import org.ltir.vm.data.GenericService;
import org.ltir.vm.data.TreeNode;

public class ValidMakerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
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
        */
        
        CLIReference ioReference = new CLIReference("Default MetaCLI reference", "none", "Cisco IOS command reference (all versions)");
        
        /* 
         * global mode commands --------------
         * mode set to null
         */
        Command c = new Command(Cardinality.CARD_1_0, null, "hostname", CommandType.COMMAND, "$hostname", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, null, "version", CommandType.COMMAND, "$version", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, null, "ip cef", CommandType.COMMAND, "[accounting $type | load-sharing algorithm $algorithm | table $type | traffic-statistics]", ".+");
        ioReference.addCommand(c);
        
        /* 
         * modes -----------------------------
         */
        
        /* interface */
        Command interfaceMode = new Command(Cardinality.CARD_1_N, null, "interface", CommandType.MODE, "$type$number [$name-tag]", ".+");
        ioReference.addCommand(interfaceMode);
        
        /* vrf */
        Command vrfMode = new Command(Cardinality.CARD_1_N, null, "ip vrf", CommandType.MODE, "$vrf-name", ".+");
        ioReference.addCommand(vrfMode);
        
        /* isis */
        Command isisMode = new Command(Cardinality.CARD_1_N, null, "router isis", CommandType.MODE, "[$area-tag]", ".+");
        ioReference.addCommand(isisMode);
        
        /* interface mode commands */
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip vrf forwarding", CommandType.COMMAND, "$vrf-name", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip directed-broadcast", CommandType.COMMAND, "[$access-list-number] | [$extended access-list-number]", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "no ip address", CommandType.COMMAND, null, null);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip address", CommandType.COMMAND, "$ip-address mask $mask [secondary]", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "encapsulation", CommandType.COMMAND, "$encapsulation-type", "gre|vxlan");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "fair-queue", CommandType.COMMAND, "$encapsulation-type", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip router isis", CommandType.COMMAND, "$encapsulation-type", ".+");
        ioReference.addCommand(c);
        
        /* vrf mode commands */
        c = new Command(Cardinality.CARD_1_0, vrfMode, "rd", CommandType.COMMAND, "$route-distinguisher", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, vrfMode, "route-target import", CommandType.COMMAND, "$route-target-ext-community", ".+");
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, vrfMode, "route-target export", CommandType.COMMAND, "$route-target-ext-community", ".+");
        ioReference.addCommand(c);
        
        try {
            FileWriter fw = new FileWriter(new File("DefaultIOReference.xml"));
            ioReference.serialize(fw);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        ioReference = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("DefaultIOReference.xml"));
            ioReference = CLIReference.deserializeCLIReference(br);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ioReference.getName());
    }
}
