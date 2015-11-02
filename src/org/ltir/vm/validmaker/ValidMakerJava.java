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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ltir.vm.data.Argument;
import org.ltir.vm.data.CLIReference;
import org.ltir.vm.data.Cardinality;
import org.ltir.vm.data.Command;
import org.ltir.vm.data.CommandType;
import org.ltir.vm.gui.MainGUI;

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
        
        CLIReference ioReference = new CLIReference("Default MetaCLI reference", "all-versions", "Cisco IOS command reference");
        
        /* 
         * global mode commands --------------
         * mode set to null
         */
        Command c = new Command(Cardinality.CARD_1_0, null, "hostname", CommandType.COMMAND, false);
        Argument a = new Argument("hostname", "$hostname", Argument.HOSTNAME_REGEX, true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, null, "version", CommandType.COMMAND, false);
        a = new Argument("version", "$version", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, null, "ip cef", CommandType.COMMAND, true);
        a = new Argument("accounting", "accounting $type", "accounting .+", false);
        c.addArgument(a);
        a = new Argument("load-sharing algorithm", "load-sharing algorithm $algorithm", "load-sharing algorithm .+", false);
        c.addArgument(a);
        a = new Argument("table", "table $type", "table .+", false);
        c.addArgument(a);
        a = new Argument("traffic-statistics", "traffic-statistics", "traffic-statistics", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        
        /* 
         * modes -----------------------------
         */
        
        /* interface */
        Command interfaceMode = new Command(Cardinality.CARD_1_N, null, "interface", CommandType.MODE, false);
        a = new Argument("interface", "$interface", ".+", true);
        interfaceMode.addArgument(a);
        a = new Argument("tag-name", "$tag-name", ".+", true);
        interfaceMode.addArgument(a);
        ioReference.addCommand(interfaceMode);
        
        /* vrf */
        Command vrfMode = new Command(Cardinality.CARD_1_N, null, "ip vrf", CommandType.MODE, true);
        a = new Argument("vrf-name", "$vrf-name", ".+", true);
        vrfMode.addArgument(a);
        ioReference.addCommand(vrfMode);
        
        /* router */
        Command routerMode = new Command(Cardinality.CARD_1_N, null, "router isis", CommandType.MODE, true);
        a = new Argument("isis", "isis $area-tag", "isis .+", false);
        routerMode.addArgument(a);
        a = new Argument("bgp", "bgp $as-number", "bgp .+", false);
        routerMode.addArgument(a);
        ioReference.addCommand(routerMode);
        /* router submodes */
        Command addressFamiliySubMode = new Command(Cardinality.CARD_1_N, routerMode, "address-family", CommandType.SUBMODE, true);
        a = new Argument("family", "vpnv4 [unicast] | ipv4 vrf $vrf-name", "(vpnv4)|(vpnv4 unicast)|(ipv4 vrf .+)", true);
        addressFamiliySubMode.addArgument(a);
        ioReference.addCommand(addressFamiliySubMode);
        
        /* interface mode commands */
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip vrf forwarding", CommandType.COMMAND, true);
        a = new Argument("vrf-name", "$vrf-name", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip directed-broadcast", CommandType.COMMAND, true);
        a = new Argument("access-list-number", "$access-list-number", ".+", false);
        c.addArgument(a);
        a = new Argument("extended access-list-number", "extended $access-list-number", "extended .+", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "no ip address", CommandType.COMMAND, false);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip address", CommandType.COMMAND, false);
        a = new Argument("ip-address", "$ip-address", Argument.IPV4_ADDR_REGEX, true);
        c.addArgument(a);
        a = new Argument("mask", "mask 255.192.0.0", "mask " + Argument.IPV4_MASK_REGEX, true);
        c.addArgument(a);
        a = new Argument("secondary", "secondary", "secondary", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "encapsulation", CommandType.COMMAND, true);
        a = new Argument("encapsulation-type", "$encapsulation-type", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "fair-queue", CommandType.COMMAND, true);
        a = new Argument("number-of-dynamic-queues", "$number-of-dynamic-queues", ".+", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "ip router isis", CommandType.COMMAND, true);
        a = new Argument("area-tag", "$area-tag", ".+", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "tag-switching ip", CommandType.COMMAND, true);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "frame-relay interface-dlci", CommandType.COMMAND, true);
        a = new Argument("dlci", "$dlci", ".+", true);
        c.addArgument(a);
        a = new Argument("ietf/cisco", "ietf|cisco", "ietf|cisco", false);
        c.addArgument(a);
        a = new Argument("voice-cir", "voice-cir $cir", "voice-cir .+", false);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, interfaceMode, "bandwidth", CommandType.COMMAND, true);
        a = new Argument("bandwidth", "$bandwidth", ".+", true); // $bandwidth (kilobites)
        c.addArgument(a);
        ioReference.addCommand(c);
        
        /* vrf mode commands */
        c = new Command(Cardinality.CARD_1_0, vrfMode, "rd", CommandType.COMMAND, false);
        a = new Argument("route-distinguisher", "$route-distinguisher", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, vrfMode, "route-target import", CommandType.COMMAND, true);
        a = new Argument("route-target-ext-community", "$route-target-ext-community", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, vrfMode, "route-target export", CommandType.COMMAND, true);
        a = new Argument("route-target-ext-community", "$route-target-ext-community", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        
        /* router mode commands*/
        c = new Command(Cardinality.CARD_1_0, routerMode, "is-type", CommandType.COMMAND, true);
        a = new Argument("level", "$level", "level-1|level-1-2|level-2-only", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, routerMode, "net", CommandType.COMMAND, true);
        a = new Argument("network-entity-title", "$network-entity-title", ".+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, routerMode, "bgp log-neighbor-changes", CommandType.COMMAND, true);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, routerMode, "neighbor remote-as", CommandType.COMMAND, true);
        a = new Argument("ip-address/peer-group-name", "$ip-address | $peer-group-name", ".+", true);
        c.addArgument(a);
        a = new Argument("remote-as", "remote-as as-number $as-number", "remote-as as-number .+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        c = new Command(Cardinality.CARD_1_0, routerMode, "neighbor update-source", CommandType.COMMAND, true);
        a = new Argument("neighbor", "$ip-address | $ipv6-address | $peer-group-name", ".+", true);
        c.addArgument(a);
        a = new Argument("update-source", "update-source interface $interface", "update-source interface .+", true);
        c.addArgument(a);
        ioReference.addCommand(c);
        
        try {
            FileWriter fw = new FileWriter(new File("DefaultIOReference.xml"));
            ioReference.serialize(fw);
            fw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidMakerJava.class.getName()).log(Level.SEVERE, null, ex);
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
        
        MainGUI.main(args);
    }
}
