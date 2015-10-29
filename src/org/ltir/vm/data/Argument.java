/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: Argument.java
 * Brief: Command arguments
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 29, 2015, 2:41:51 PM
 */
package org.ltir.vm.data;

public class Argument {
    private String name;
    private String value;
    private String argRegEX;

    public Argument(String name, String value, String argRegEX) {
        this.name = name;
        this.value = value;
        this.argRegEX = argRegEX;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getArgRegEX() {
        return argRegEX;
    }

    public void setArgRegEX(String argRegEX) {
        this.argRegEX = argRegEX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean valid(){
        return value.matches(argRegEX);
    }
}
