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
import java.util.ArrayList;
import java.util.List;


public class Network{
    
    @XStreamAlias("name")
    @XStreamAsAttribute
    private String name;
    private String description;
    @XStreamAlias("path")
    @XStreamAsAttribute
    String path;
    @XStreamOmitField
    private final List<GenericService> genericServices;
    @XStreamOmitField
    private final List<ServiceInstance> serviceInstances;
    @XStreamOmitField
    private final List<ServiceFamily> serviceFamilies;
    @XStreamOmitField
    private final List<Device> devices;

    public Network(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
        genericServices = new ArrayList<>();
        serviceInstances = new ArrayList<>();
        serviceFamilies = new ArrayList<>();
        devices = new ArrayList<>();
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

    public boolean addServiceFamily(ServiceFamily e) {
        return serviceFamilies.add(e);
    }

    public boolean removeServiceFamily(ServiceFamily sf) {
        return serviceFamilies.remove(sf);
    }

    public ServiceFamily getServiceFamily(int index) {
        return serviceFamilies.get(index);
    }

    public void addServiceFamily(int index, ServiceFamily element) {
        serviceFamilies.add(index, element);
    }

    public ServiceFamily removeServiceFamily(int index) {
        return serviceFamilies.remove(index);
    }

    public boolean addServiceInstance(ServiceInstance e) {
        return serviceInstances.add(e);
    }

    public boolean removeServiceInstance(ServiceInstance si) {
        return serviceInstances.remove(si);
    }

    public ServiceInstance getServiceInstance(int index) {
        return serviceInstances.get(index);
    }

    public void addServiceInstance(int index, ServiceInstance element) {
        serviceInstances.add(index, element);
    }

    public ServiceInstance removeServiceInstance(int index) {
        return serviceInstances.remove(index);
    }
    
    
    
}
