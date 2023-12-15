
package shop.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Image complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Image"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://it.nure.ua/social}Entity"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="image_url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="image_content" type="{http://it.nure.ua/social}Base64String"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", namespace = "http://it.nure.ua/social", propOrder = {
    "imageUrl",
    "imageContent"
})
public class Image
    extends Entity
{

    @XmlElement(name = "image_url", namespace = "http://it.nure.ua/social")
    protected String imageUrl;
    @XmlElement(name = "image_content", namespace = "http://it.nure.ua/social")
    protected String imageContent;

    /**
     * Gets the value of the imageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the value of the imageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    /**
     * Gets the value of the imageContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageContent() {
        return imageContent;
    }

    /**
     * Sets the value of the imageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageContent(String value) {
        this.imageContent = value;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageUrl='" + imageUrl + '\'' +
                ", imageContent='" + imageContent + '\'' +
                ", id=" + id +
                ", uuid='" + uuid + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
