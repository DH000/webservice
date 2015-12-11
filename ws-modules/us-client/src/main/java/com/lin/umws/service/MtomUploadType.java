
package com.lin.umws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>mtomUploadType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="mtomUploadType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mtomFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mtomUploadType", propOrder = {
    "mtomFile"
})
public class MtomUploadType {

    @XmlElement(required = true)
    protected byte[] mtomFile;

    /**
     * 获取mtomFile属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getMtomFile() {
        return mtomFile;
    }

    /**
     * 设置mtomFile属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setMtomFile(byte[] value) {
        this.mtomFile = value;
    }

}
