/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data.managers
 * File: ObjectManager.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on 3-Nov-2015, 10:46:17 AM
 */
package org.ltir.vm.data.managers;

import java.io.File;
import java.io.FilenameFilter;
import javafx.collections.ListChangeListener;
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
public class ObjectManager implements Manager {
    
    static{
        Manager.networkList.addListener(new ListChangeListener<Network>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends Network> change) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Manager.gnenericServiceList.addListener(new ListChangeListener<GenericService>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends GenericService> change) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Manager.serviceInstanceList.addListener(new ListChangeListener<ServiceInstance>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends ServiceInstance> change) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Manager.ruleList.addListener(new ListChangeListener<Rule>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends Rule> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Manager.serviceFamilyList.addListener(new ListChangeListener<ServiceFamily>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends ServiceFamily> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Manager.deviceList.addListener(new ListChangeListener<Device>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends Device> c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    public boolean addNewNetwork(Network network) {
        boolean result = true;

        for (Network e : Manager.networkList) {
            if (e.equals(network)) {
                result = false;
                break;
            }
        }

        if (result) {
            Manager.networkList.add(network);
        }

        return result;
    }

    @Override
    public boolean addExistingNetwork(File file) {
        boolean result = true;

        if (FileManager.checkIfFileIsNetwork(file)) {
            Network network = new Network(file);

            for (Network e : Manager.networkList) {
                if (e.equals(network)) {
                    result = false;
                    break;
                }
            }

            if (result) {
                Manager.networkList.add(network);
            }

            File gsFolder = new File(file.getAbsolutePath() + File.pathSeparator + "Generic Services");
            File siFolder = new File(file.getAbsolutePath() + File.pathSeparator + "Service Instances");
            File rFolder = new File(file.getAbsolutePath() + File.pathSeparator + "Rules");
            File sfFolder = new File(file.getAbsolutePath() + File.pathSeparator + "Service Families");
            File dFolder = new File(file.getAbsolutePath() + File.pathSeparator + "Devices");

            for (File f : gsFolder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.startsWith("GI_")) return true;
                    else return false;
                }
            })) {
                this.addExistingGenericService(f);
            }

            for (File f : siFolder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.startsWith("SI_")) return true;
                    else return false;
                }
            })) {
                this.addExistingServiceInstance(f);
            }

            for (File f : rFolder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.startsWith("R_")) return true;
                    else return false;
                }
            })) {
                this.addExistingRule(f);
            }
            
            for (File f : sfFolder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.startsWith("SF_")) return true;
                    else return false;
                }
            })) {
                this.addExistingServiceFamily(f);
            }

            for (File f : dFolder.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if(name.startsWith("D_")) return true;
                    else return false;
                }
            })) {
                this.addExistingDevice(f);
            }
        }

        return result;
    }

    @Override
    public boolean removeNetwork(Network network) {
        boolean result = false;

        for (Network e : Manager.networkList) {
            if (e.equals(network)) {
                result = true;
                Manager.networkList.remove(e);
                break;
            }
        }

        return result;

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

}
