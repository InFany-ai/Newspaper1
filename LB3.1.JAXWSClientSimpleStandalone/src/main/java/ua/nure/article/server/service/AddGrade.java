
package ua.nure.article.server.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.article.entity.Grade;


/**
 * <p>Java class for addGrade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addGrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://article.nure.ua/entity}Grade" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addGrade", propOrder = {
    "grade"
})
public class AddGrade {

    @XmlElement(name = "Grade", namespace = "http://article.nure.ua/entity")
    protected Grade grade;

    /**
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link Grade }
     *     
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grade }
     *     
     */
    public void setGrade(Grade value) {
        this.grade = value;
    }

}
