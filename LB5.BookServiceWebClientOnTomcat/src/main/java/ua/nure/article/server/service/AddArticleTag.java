
package ua.nure.article.server.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.article.entity.ArticleTag;


/**
 * <p>Java class for addArticleTag complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addArticleTag"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://article.nure.ua/entity}ArticleTag" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addArticleTag", propOrder = {
    "articleTag"
})
public class AddArticleTag {

    @XmlElement(name = "ArticleTag", namespace = "http://article.nure.ua/entity")
    protected ArticleTag articleTag;

    /**
     * Gets the value of the articleTag property.
     * 
     * @return
     *     possible object is
     *     {@link ArticleTag }
     *     
     */
    public ArticleTag getArticleTag() {
        return articleTag;
    }

    /**
     * Sets the value of the articleTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArticleTag }
     *     
     */
    public void setArticleTag(ArticleTag value) {
        this.articleTag = value;
    }

}
