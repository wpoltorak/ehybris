//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 10:57:23 PM CEST 
//


package com.lambda.plugin.core.jaxb.extensioninfo.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Configures an hmc module for the extension. Required directory: /hmc.
 * 
 * <p>Java class for hmcmoduleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hmcmoduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="additionalclasspath" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="extensionclassname" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sourceavailable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hmcmoduleType")
public class HmcmoduleType {

    @XmlAttribute(name = "additionalclasspath")
    protected String additionalclasspath;
    @XmlAttribute(name = "extensionclassname")
    protected String extensionclassname;
    @XmlAttribute(name = "sourceavailable")
    protected Boolean sourceavailable;

    /**
     * Gets the value of the additionalclasspath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalclasspath() {
        return additionalclasspath;
    }

    /**
     * Sets the value of the additionalclasspath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalclasspath(String value) {
        this.additionalclasspath = value;
    }

    /**
     * Gets the value of the extensionclassname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionclassname() {
        return extensionclassname;
    }

    /**
     * Sets the value of the extensionclassname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionclassname(String value) {
        this.extensionclassname = value;
    }

    /**
     * Gets the value of the sourceavailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSourceavailable() {
        return sourceavailable;
    }

    /**
     * Sets the value of the sourceavailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSourceavailable(Boolean value) {
        this.sourceavailable = value;
    }

}
