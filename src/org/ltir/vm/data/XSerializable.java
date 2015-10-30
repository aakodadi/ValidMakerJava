/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: XSerializable.java
 * Brief: Ensure projects persistence and 
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 26, 2015, 12:51:19 AM
 */
package org.ltir.vm.data;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Using XStream framework to persist object using XML files every class
 * extending it must implement a method
 * <code>static ClassName deserializeClassName(BufferedReader br)</code> calling
 * <code>static Object deserialize(BufferedReader br)</code> and casting it's
 * return to ClassName in order to avoid ClassCastExceptions
 *
 * @author Abdelhakim Akodadi <akodadi.abdelhakim@gmail.com>
 * @author Amine Rahj         <aminerahj@gmail.com>
 * @see com.thoughtworks.xstream.XStream
 */
public abstract class XSerializable {

    /**
     * applied on a XSerializable object in order to save its state as an XML
     * file
     *
     * @param fw FileWriter to the XML file where the object will be saved
     *
     * @throws IOException if the writing in fw fails
     */
    public void serialize(FileWriter fw) throws IOException {
        XStream xs = new XStream();
        xs.autodetectAnnotations(true);
        xs.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
        String XMLres = xs.toXML(this);
        fw.write(XMLres);
    }

    /**
     * retrieves an object from the content of the XML file where he was saved
     * before
     *
     * @param br BufferedReader to the XML file where the object was saved
     *
     * @return the object that was saved in the XML file
     *
     * @throws IOException if reading from br fails
     */
    protected static Object deserialize(BufferedReader br) throws IOException {
        XStream xs = new XStream();
        xs.autodetectAnnotations(true);
        xs.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
        String res;
        String XMLres = "";
        while ((res = br.readLine()) != null) {
            XMLres += res;
        }
        return xs.fromXML(XMLres);
    }
}
