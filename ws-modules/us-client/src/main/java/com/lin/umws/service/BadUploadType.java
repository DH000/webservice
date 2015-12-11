
package com.lin.umws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>badUploadType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="badUploadType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "badUploadType", propOrder = {
    "file"
})
public class BadUploadType {

    @XmlElement(required = true)
    protected byte[] file;

    /**
     * 获取file属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * 设置file属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFile(byte[] value) {
        this.file = value;
    }

}
