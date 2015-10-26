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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NetworksManager extends XSerializable{
    String workspace;
    List<Network> networks;
    List<CLIReference> metaCLIs;

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
    
    
    
}
