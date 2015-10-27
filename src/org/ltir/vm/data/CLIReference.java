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

public class CLIReference {
    private String name;
    private String version;
    private String description;
    private TreeNode<Command> commande;

    public CLIReference(String name, String version, String description) {
        this.name = name;
        this.version = version;
        this.description = description;
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
    
    

    public TreeNode<Command> getCommand(int index) {
        return commande.get(index);
    }

    public boolean addCommand(TreeNode<Command> node) {
        return commande.add(node);
    }

    public boolean removeCommand(Command c) {
        return commande.remove(c);
    }
}
