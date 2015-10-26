/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: Device.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:50:40 AM
 */
package org.ltir.vm.data;

import java.io.BufferedReader;
import java.io.IOException;
import static org.ltir.vm.data.XSerializable.deserialize;


public class Device extends XSerializable{
    String name;
    String version;
    String model;
    String osVersion;
    CLIReference reference;
    TreeNode<Command> commands;

    public Device(String name, String version, String model, String osVersion) {
        this(name, version, model, osVersion, null);
    }

    public Device(String name, String version, String model, String osVersion, CLIReference reference) {
        this.name = name;
        this.version = version;
        this.model = model;
        this.osVersion = osVersion;
        this.reference = reference;
        this.commands = new TreeNode<>();
    }
    
    public static Device deserializeDevice(BufferedReader br) throws IOException{
        return (Device) deserialize(br);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public CLIReference getReference() {
        return reference;
    }

    public void setReference(CLIReference reference) {
        this.reference = reference;
    }
    
    
}
