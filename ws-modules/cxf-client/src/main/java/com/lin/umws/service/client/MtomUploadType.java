
package com.lin.umws.service.client;

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
 * &lt;complexType name="mtomUploadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mtomFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
