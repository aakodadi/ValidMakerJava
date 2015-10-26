/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: ServiceInstance.java
 * Brief: 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 2:36:47 AM
 */
package org.ltir.vm.data;

public class ServiceInstance {
    String name;
    String description;
    GenericService genericService;
    TreeNode<Command> commands;
}
