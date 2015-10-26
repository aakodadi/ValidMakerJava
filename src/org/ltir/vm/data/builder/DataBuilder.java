/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data.builder
 * File: DataBuilder.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 10:33:57 AM
 */
package org.ltir.vm.data.builder;

import org.ltir.vm.data.Network;
import org.ltir.vm.data.TreeNode;

abstract public class DataBuilder {
    Network network;   
    
    abstract public void buildPart(TreeNode tn) ;
}
