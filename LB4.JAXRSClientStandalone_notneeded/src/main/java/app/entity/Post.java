
package app.entity;

import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Post complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Post"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://it.nure.ua/social}Entity"&gt;
 *       &lt;all&gt;
 *         &lt;element name="header"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="120"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="images" type="{http://it.nure.ua/social}Images"/&gt;
 *         &lt;element name="date" type="{http://it.nure.ua/social}Date"/&gt;
 *         &lt;element name="likes" type="{http://it.nure.ua/social}Rating"/&gt;
 *         &lt;element name="created_by" type="{http://it.nure.ua/social}Author"/&gt;
 *         &lt;element name="comments" type="{http://it.nure.ua/social}Comments"/&gt;
 *         &lt;element name="access_level" type="{http://it.nure.ua/social}AccessLevel"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Post", namespace = "http://it.nure.ua/social", propOrder = {
    "header",
    "text",
    "images",
    "date",
    "likes",
    "createdBy",
    "comments",
    "accessLevel"
})
public class Post
    extends Entity
{

    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected String header;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected String text;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected Images images;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(namespace = "http://it.nure.ua/social")
    protected int likes;
    @XmlElement(name = "created_by", namespace = "http://it.nure.ua/social", required = true)
    protected Author createdBy;
    @XmlElement(namespace = "http://it.nure.ua/social", required = true)
    protected Comments comments;
    @XmlElement(name = "access_level", namespace = "http://it.nure.ua/social", required = true)
    @XmlSchemaType(name = "string")
    protected AccessLevel accessLevel;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeader(String value) {
        this.header = value;
    }

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
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link Images }
     *     
     */
    public Images getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link Images }
     *     
     */
    public void setImages(Images value) {
        this.images = value;
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
     * Gets the value of the likes property.
     * 
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Sets the value of the likes property.
     * 
     */
    public void setLikes(int value) {
        this.likes = value;
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

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link Comments }
     *     
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comments }
     *     
     */
    public void setComments(Comments value) {
        this.comments = value;
    }

    /**
     * Gets the value of the accessLevel property.
     * 
     * @return
     *     possible object is
     *     {@link AccessLevel }
     *     
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * Sets the value of the accessLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessLevel }
     *     
     */
    public void setAccessLevel(AccessLevel value) {
        this.accessLevel = value;
    }

    @Override
    public String toString() {
        return "Post{" +
                "\nheader='" + header + '\'' +
                ", \ntext='" + text + '\'' +
                ", \nimages=" + images +
                ", \ndate=" + date +
                ", \nlikes=" + likes +
                ", \ncreatedBy=" + createdBy +
                ", \ncomments=" + comments +
                ", \naccessLevel=" + accessLevel +
                ", \nid=" + id +
                ", \nuuid='" + uuid + '\'' +
                ", \nhidden=" + hidden +
                '}';
    }
}
