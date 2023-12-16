
package ua.nure.article.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Article complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Article"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://article.nure.ua/entity}EntityWithId"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Author" type="{http://article.nure.ua/entity}Author" minOccurs="0"/&gt;
 *         &lt;element name="ArticleTag" type="{http://article.nure.ua/entity}ArticleTag" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Comment" type="{http://article.nure.ua/entity}Comment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Grade" type="{http://article.nure.ua/entity}Grade" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Article", propOrder = {
    "title",
    "body",
    "author",
    "articleTag",
    "comment",
    "grade"
})
public class Article
    extends EntityWithId
{

    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "Body")
    protected String body;
    @XmlElement(name = "Author")
    protected Author author;
    @XmlElement(name = "ArticleTag")
    protected List<ArticleTag> articleTag;
    @XmlElement(name = "Comment")
    protected List<Comment> comment;
    @XmlElement(name = "Grade")
    protected List<Grade> grade;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link Author }
     *     
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link Author }
     *     
     */
    public void setAuthor(Author value) {
        this.author = value;
    }

    /**
     * Gets the value of the articleTag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the articleTag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleTag }
     * 
     * 
     */
    public List<ArticleTag> getArticleTag() {
        if (articleTag == null) {
            articleTag = new ArrayList<ArticleTag>();
        }
        return this.articleTag;
    }

    /**
     * Gets the value of the comment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the comment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comment }
     * 
     * 
     */
    public List<Comment> getComment() {
        if (comment == null) {
            comment = new ArrayList<Comment>();
        }
        return this.comment;
    }

    /**
     * Gets the value of the grade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the grade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Grade }
     * 
     * 
     */
    public List<Grade> getGrade() {
        if (grade == null) {
            grade = new ArrayList<Grade>();
        }
        return this.grade;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author=" + author.toString()  +
                ", articleTag=" + articleTag.toString() +
                ", comment=" + comment.toString() +
                ", grade=" + grade.toString() +
                ", id=" + id +
                '}';
    }
}
