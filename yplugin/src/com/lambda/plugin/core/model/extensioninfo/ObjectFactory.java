//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.10.08 at 11:02:58 PM CEST 
//


package com.lambda.plugin.core.model.extensioninfo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lambda.plugin.core.model.extensioninfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lambda.plugin.core.model.extensioninfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequiresExtensionType }
     * 
     */
    public RequiresExtensionType createRequiresExtensionType() {
        return new RequiresExtensionType();
    }

    /**
     * Create an instance of {@link Extensioninfo }
     * 
     */
    public Extensioninfo createExtensioninfo() {
        return new Extensioninfo();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link CoremoduleType }
     * 
     */
    public CoremoduleType createCoremoduleType() {
        return new CoremoduleType();
    }

    /**
     * Create an instance of {@link HmcmoduleType }
     * 
     */
    public HmcmoduleType createHmcmoduleType() {
        return new HmcmoduleType();
    }

    /**
     * Create an instance of {@link WebmoduleType }
     * 
     */
    public WebmoduleType createWebmoduleType() {
        return new WebmoduleType();
    }

}
