/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: Command.java
 * Brief: defining MetaCLI and devices' commands
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:28:15 AM
 */
package org.ltir.vm.data;

public class Command {
    private Cardinality cardinality;
    private Command familiy;
    private String command;
    private String argument;

    public Command(Cardinality cardinality, Command familiy, String command, String argument) {
        this.cardinality = cardinality;
        this.familiy = familiy;
        this.command = command;
        this.argument = argument;
    }

    public Cardinality getCardinality() {
        return cardinality;
    }

    public void setCardinality(Cardinality cardinality) {
        this.cardinality = cardinality;
    }

    public Command getFamiliy() {
        return familiy;
    }

    public void setFamiliy(Command familiy) {
        this.familiy = familiy;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
