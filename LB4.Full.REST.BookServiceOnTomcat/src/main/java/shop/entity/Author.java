
package shop.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Author complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Author"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://it.nure.ua/social}Entity"&gt;
 *       &lt;all&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="image" type="{http://it.nure.ua/social}Image"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Author", namespace = "http://it.nure.ua/social", propOrder = {
    "username",
    "image"
})
public class Author
    extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected String username;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected Image image;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setImage(Image value) {
        this.image = value;
    }

    @Override
    public String toString() {
        return "Author{" +
                "username='" + username + '\'' +
                ", image=" + image +
                ", id=" + id +
                ", uuid='" + uuid + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
