
package app.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Images complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Images"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="image" type="{http://it.nure.ua/social}Image" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Images", namespace = "http://it.nure.ua/social", propOrder = {
    "image"
})
public class Images {

    @XmlElement(namespace = "http://it.nure.ua/social")
    protected List<Image> image;

    /**
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Image }
     * 
     * 
     */
    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

    @Override
    public String toString() {
        return "Images{" +
                "image=" + image +
                '}';
    }
}
