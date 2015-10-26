/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: XSerializable.java
 * Brief: 
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

public abstract class XSerializable {

    public void serialize(FileWriter fw) throws IOException {
        XStream xs = new XStream();
        xs.autodetectAnnotations(true);
        xs.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
        String XMLres = xs.toXML(this);
        fw.write(XMLres);
    }

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
