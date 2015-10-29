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
    private CommandType type;
    private Command mode;
    private String command;
    private String argument;
    private String argRegEX;

    public Command(Cardinality cardinality, Command mode, String command, CommandType type, String argument, String argRegEX) {
        this.cardinality = cardinality;
        this.mode = mode;
        this.command = command;
        this.type = type;
        this.argument = argument;
        this.argRegEX = argRegEX;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }
    

    public String getArgRegEX() {
        return argRegEX;
    }

    public void setArgRegEX(String argRegEX) {
        this.argRegEX = argRegEX;
    }

    public Cardinality getCardinality() {
        return cardinality;
    }

    public void setCardinality(Cardinality cardinality) {
        this.cardinality = cardinality;
    }

    public Command getMode() {
        return mode;
    }

    public void setMode(Command familiy) {
        this.mode = familiy;
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
