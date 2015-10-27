/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: ServiceFamily.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:46:23 AM
 */
package org.ltir.vm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.ltir.vm.data.XSerializable.deserialize;

public class ServiceFamily  extends XSerializable{
    private final List<ServiceInstance> serviceInstences;
    private final List<Rule> rules;

    public ServiceFamily() {
        this.serviceInstences = new ArrayList<>();
        this.rules = new ArrayList<>();
    }
    
    public static ServiceFamily deserializeServiceFamily(BufferedReader br) throws IOException{
        return (ServiceFamily) deserialize(br);
    }

    public boolean addRule(Rule e) {
        return rules.add(e);
    }

    public boolean removeRule(Rule r) {
        return rules.remove(r);
    }

    public Rule getRule(int index) {
        return rules.get(index);
    }

    public void addRule(int index, Rule element) {
        rules.add(index, element);
    }

    public Rule removeRule(int index) {
        return rules.remove(index);
    }

    public boolean addServiceInstance(ServiceInstance e) {
        return serviceInstences.add(e);
    }

    public boolean removeServiceInstance(ServiceInstance si) {
        return serviceInstences.remove(si);
    }

    public ServiceInstance getServiceInstance(int index) {
        return serviceInstences.get(index);
    }

    public void addServiceInstance(int index, ServiceInstance element) {
        serviceInstences.add(index, element);
    }

    public ServiceInstance removeServiceInstance(int index) {
        return serviceInstences.remove(index);
    }
    
    
}
