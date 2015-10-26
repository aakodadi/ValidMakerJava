/*
 * Project: ValidMakerJava
 * Package: org.ltir.vm.data
 * File: ValidMakerJava.java
 * Brief: The main program
 * 
 * Organization: LTIR UQAM
 * Authors: Amine Rahj, Abdelhakim Akodadi
 * Created on Oct 25, 2015, 12:21:00 AM
 */
package org.ltir.vm.validmaker;

import com.thoughtworks.xstream.XStream;
import org.ltir.vm.data.TreeNode;

public class ValidMakerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello ValidMaker!");
        TreeNode<String> tree = new TreeNode<>("zero");
        tree.setRoot(tree);
        TreeNode<String> oneNode;
        TreeNode<String> twoNode;
        tree.add(oneNode = new TreeNode<>("one"));
        tree.add(twoNode = new TreeNode<>("two"));
        tree.add(new TreeNode<>("three"));
        tree.add(tree);
        oneNode.add(new TreeNode<>("one-one"));
        oneNode.add(new TreeNode<>("one-two"));
        twoNode.add(new TreeNode<>("two-one"));
        twoNode.add(new TreeNode<>("two-two"));

        XStream xstream = new XStream();
        xstream.alias("Node", TreeNode.class);
        xstream.aliasField("name", TreeNode.class, "element");
        xstream.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
        String xml = xstream.toXML(tree);
        System.out.println(xml);
        tree = null;
        tree = (TreeNode<String>) xstream.fromXML(xml);

        for (TreeNode<String> node : tree) {
            System.out.println(node.getElement());
            for (TreeNode<String> innernode : node) {
                System.out.println("-" + innernode.getElement());
                for (TreeNode<String> innerinnernode : innernode) {
                    System.out.println("--" + innerinnernode.getElement());
                }
            }
        }
    }
}
