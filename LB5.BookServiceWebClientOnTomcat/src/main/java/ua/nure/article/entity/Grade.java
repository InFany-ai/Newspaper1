
package ua.nure.article.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Grade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Grade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://article.nure.ua/entity}EntityWithId"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ArticleId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Grade", propOrder = {
    "articleId",
    "value"
})
public class Grade
    extends EntityWithId
{

    @XmlElement(name = "ArticleId")
    protected int articleId;
    @XmlElement(name = "Value")
    protected int value;

    /**
     * Gets the value of the articleId property.
     * 
     */
    public int getArticleId() {
        return articleId;
    }

    /**
     * Sets the value of the articleId property.
     * 
     */
    public void setArticleId(int value) {
        this.articleId = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
