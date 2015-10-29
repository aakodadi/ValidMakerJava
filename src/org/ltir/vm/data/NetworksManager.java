/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: NetworksManager.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:58:12 AM
 */
package org.ltir.vm.data;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NetworksManager extends XSerializable{
    private String workspace;
    private final List<Network> networks;
    @XStreamOmitField
    private final List<CLIReference> metaCLIs;

    public NetworksManager(String workspace) {
        this.workspace = workspace;
        this.networks = new ArrayList<>();
        this.metaCLIs = new ArrayList<>();
    }
    
    public static NetworksManager deserializeNetworksManager(BufferedReader br) throws IOException{
        return (NetworksManager) deserialize(br);
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public boolean addNetwork(Network e) {
        return networks.add(e);
    }

    public boolean removeNetwork(Network n) {
        return networks.remove(n);
    }

    public Network getNetwork(int index) {
        return networks.get(index);
    }

    public void addNetwork(int index, Network element) {
        networks.add(index, element);
    }

    public Network removeNetwork(int index) {
        return networks.remove(index);
    }

    public boolean addMetaCLI(CLIReference e) {
        return metaCLIs.add(e);
    }

    public boolean removeMetaCLI(CLIReference cli) {
        return metaCLIs.remove(cli);
    }

    public CLIReference getMetaCLI(int index) {
        return metaCLIs.get(index);
    }

    public void addMetaCLI(int index, CLIReference element) {
        metaCLIs.add(index, element);
    }

    public CLIReference removeMetaCLI(int index) {
        return metaCLIs.remove(index);
    }
    
}
