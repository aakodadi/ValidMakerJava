/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data.managers
 * File: FileManager.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on 3-Nov-2015, 10:46:34 AM
 */
package org.ltir.vm.data.managers;

import java.io.File;
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
public class FileManager implements Manager{

    @Override
    public boolean addNewNetwork(Network network) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingNetwork(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeNetwork(Network network) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewGenericService(GenericService genericService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingGenericService(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeGenericService(GenericService genericService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewServiceInstance(ServiceInstance serviceInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingServiceInstance(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeServiceInstance(ServiceInstance serviceInstance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewRule(Rule rule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingRule(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeExistingRule(Rule rule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewServiceFamily(ServiceFamily serviceFamily) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingServiceFamily(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeServiceFamily(ServiceFamily serviceFamily) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNewDevice(Device device) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addExistingDevice(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeDevice(Device device) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    static public boolean checkIfFileIsNetwork(File file) {
        boolean result = false;

       //take network.xml file into account
        result = file.isDirectory();

        if (!result) {
            return result;
        }

        File gsDir = new File(file.getAbsolutePath() + File.pathSeparator + "Generic Services");

        File siDir = new File(file.getAbsolutePath() + File.pathSeparator + "Services Instances");

        File rDir = new File(file.getAbsolutePath() + File.pathSeparator + "Rules");

        result = (gsDir.exists() && gsDir.isDirectory()) && (siDir.exists() && siDir.isDirectory()) && (rDir.exists() && rDir.isDirectory());

        return result;
    }
}
