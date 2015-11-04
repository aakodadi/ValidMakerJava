/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data.managers
 * File: Manager.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on 3-Nov-2015, 10:43:40 AM
 */
package org.ltir.vm.data.managers;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.ltir.vm.data.Device;
import org.ltir.vm.data.GenericService;
import org.ltir.vm.data.Network;
import org.ltir.vm.data.Rule;
import org.ltir.vm.data.ServiceFamily;
import org.ltir.vm.data.ServiceInstance;

/**
 *
 * @author hp
 */
public interface Manager {

    ObservableList<Network> networkList = FXCollections.observableArrayList();
    ObservableList<GenericService> gnenericServiceList = FXCollections.observableArrayList();
    ObservableList<ServiceInstance> serviceInstanceList = FXCollections.observableArrayList();
    ObservableList<Rule> ruleList = FXCollections.observableArrayList();
    ObservableList<ServiceFamily> serviceFamilyList = FXCollections.observableArrayList();
    ObservableList<Device> deviceList = FXCollections.observableArrayList();

    boolean addNewNetwork(Network network);

    boolean addExistingNetwork(File file);

    boolean removeNetwork(Network network);

    boolean addNewGenericService(GenericService genericService);

    boolean addExistingGenericService(File file);

    boolean removeGenericService(GenericService genericService);

    boolean addNewServiceInstance(ServiceInstance serviceInstance);

    boolean addExistingServiceInstance(File file);

    boolean removeServiceInstance(ServiceInstance serviceInstance);

    boolean addNewRule(Rule rule);

    boolean addExistingRule(File file);

    boolean removeExistingRule(Rule rule);

    boolean addNewServiceFamily(ServiceFamily serviceFamily);

    boolean addExistingServiceFamily(File file);

    boolean removeServiceFamily(ServiceFamily serviceFamily);

    boolean addNewDevice(Device device);

    boolean addExistingDevice(File file);

    boolean removeDevice(Device device);
}
