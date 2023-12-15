
package app.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="post" type="{http://it.nure.ua/social}Post" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Posts", namespace = "http://it.nure.ua/social", propOrder = {
    "post"
})
public class Posts {

    @XmlElement(namespace = "http://it.nure.ua/social")
    protected List<Post> post;

    /**
     * Gets the value of the post property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the post property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Post }
     * 
     * 
     */
    public List<Post> getPost() {
        if (post == null) {
            post = new ArrayList<Post>();
        }
        return this.post;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "post=" + post +
                '}';
    }
}
