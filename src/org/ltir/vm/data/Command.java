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

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.List;

public class Command {
    private Cardinality cardinality;
    private CommandType type;
    private Command mode;
    private String command;
    private final List<Argument> arguments;
    @XStreamAsAttribute
    private boolean negatebale;
    @XStreamAsAttribute
    private boolean negated;

    public Command(Cardinality cardinality, Command mode, String command, CommandType type, boolean negatebale) {
        this.cardinality = cardinality;
        this.mode = mode;
        this.command = command;
        this.type = type;
        this.arguments = new ArrayList<>();
        this.negatebale = negatebale;
        this.negated = false;
    }

    public boolean isNegatebale() {
        return negatebale;
    }

    public void setNegatebale(boolean negatebale) {
        this.negatebale = negatebale;
    }

    public boolean isNegated() {
        return negated;
    }

    public void setNegated(boolean negated) {
        this.negated = negated;
    }
    
    

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
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

    public boolean addArgument(Argument e) {
        return arguments.add(e);
    }

    public boolean removeArgument(Argument a) {
        return arguments.remove(a);
    }

    public Argument getArgument(int index) {
        return arguments.get(index);
    }

    public void addArgument(int index, Argument element) {
        arguments.add(index, element);
    }

    public Argument removeArgument(int index) {
        return arguments.remove(index);
    }
    
}
