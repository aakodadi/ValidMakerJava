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

import java.util.ArrayList;

public class Network {
    String name;
    String description;
    String path;
    ArrayList<GenericService> genericServices;
    ArrayList<ServiceInstance> serviceInstances;
    ArrayList<ServiceFamily> serviceFamilies;
    ArrayList<Device> devices;
    
}
