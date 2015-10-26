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
import static org.ltir.vm.data.XSerializable.deserialize;

public class ServiceFamily  extends XSerializable{
    ArrayList<ServiceInstance> serviceInstences;
    ArrayList<Rule> rules;

    public ServiceFamily() {
        this.serviceInstences = new ArrayList<>();
        this.rules = new ArrayList<>();
    }
    
    public static ServiceFamily deserializeServiceFamily(BufferedReader br) throws IOException{
        return (ServiceFamily) deserialize(br);
    }
}
