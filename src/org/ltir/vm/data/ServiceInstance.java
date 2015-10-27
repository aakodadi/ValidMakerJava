/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: ServiceInstance.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:36:47 AM
 */
package org.ltir.vm.data;

import java.io.BufferedReader;
import java.io.IOException;
import static org.ltir.vm.data.XSerializable.deserialize;

public class ServiceInstance extends XSerializable {

    private String name;
    private String description;
    private GenericService genericService;
    private final TreeNode<Command> commands;

    public ServiceInstance(String name, String description) {
        this(name, description, null);
    }

    public ServiceInstance(String name, String description, GenericService genericService) {
        this.name = name;
        this.description = description;
        this.genericService = genericService;
        this.commands = new TreeNode<>();
    }

    public static ServiceInstance deserializeServiceInstance(BufferedReader br) throws IOException {
        return (ServiceInstance) deserialize(br);
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

    public GenericService getGenericService() {
        return genericService;
    }

    public void setGenericService(GenericService genericService) {
        this.genericService = genericService;
    }

    public TreeNode<Command> getCommand(int index) {
        return commands.get(index);
    }

    public boolean addCommand(TreeNode<Command> node) {
        return commands.add(node);
    }

    public boolean removeCommand(Command c) {
        return commands.remove(c);
    }

}
