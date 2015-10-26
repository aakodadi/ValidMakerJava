/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: Network.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:54:36 AM
 */
package org.ltir.vm.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Network extends XSerializable{
    
    @XStreamAlias("name")
    @XStreamAsAttribute
    String name;
    String description;
    @XStreamAlias("path")
    @XStreamAsAttribute
    String path;
    @XStreamOmitField
    List<GenericService> genericServices;
    @XStreamOmitField
    List<ServiceInstance> serviceInstances;
    @XStreamOmitField
    List<ServiceFamily> serviceFamilies;
    @XStreamOmitField
    List<Device> devices;

    public Network(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
        genericServices = new ArrayList<>();
        serviceInstances = new ArrayList<>();
        serviceFamilies = new ArrayList<>();
        devices = new ArrayList<>();
    }
    
    public static Network deserializeNetwork(BufferedReader br) throws IOException{
        return (Network) deserialize(br);
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GenericService getGenericService(int index) {
        return genericServices.get(index);
    }

    public boolean addGenericService(GenericService e) {
        return genericServices.add(e);
    }

    public void addGenericService(int index, GenericService element) {
        genericServices.add(index, element);
    }
    
    
    
}
