/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: CLIReference.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:39:42 PM
 */
package org.ltir.vm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.ltir.vm.data.XSerializable.deserialize;

public class CLIReference extends XSerializable {

    private String name;
    private String version;
    private String description;
    private final List<Command> commands;

    public CLIReference(String name, String version, String description) {
        this.name = name;
        this.version = version;
        this.description = description;
        commands = new ArrayList<>();
    }

    public static CLIReference deserializeCLIReference(BufferedReader br) throws IOException {
        return (CLIReference) deserialize(br);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Command getCommand(int index) {
        return commands.get(index);
    }

    public boolean addCommand(Command cmd) {
        return commands.add(cmd);
    }

    public boolean removeCommand(Command cmd) {
        return commands.remove(cmd);
    }
}
