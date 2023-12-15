
package shop.entity;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Comment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Comment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://it.nure.ua/social}Entity"&gt;
 *       &lt;all&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date" type="{http://it.nure.ua/social}Date"/&gt;
 *         &lt;element name="created_by" type="{http://it.nure.ua/social}Author"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comment", namespace = "http://it.nure.ua/social", propOrder = {
    "text",
    "date",
    "createdBy"
})
public class Comment
    extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected String text;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "created_by", namespace = "http://it.nure.ua/social", required = true)
    protected Author createdBy;

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link Author }
     *     
     */
    public Author getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Author }
     *     
     */
    public void setCreatedBy(Author value) {
        this.createdBy = value;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", createdBy=" + createdBy +
                ", id=" + id +
                ", uuid='" + uuid + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
