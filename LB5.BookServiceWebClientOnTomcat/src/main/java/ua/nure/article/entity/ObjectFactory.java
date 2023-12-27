
package ua.nure.article.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.article.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Article_QNAME = new QName("http://article.nure.ua/entity", "Article");
    private final static QName _ArticleTag_QNAME = new QName("http://article.nure.ua/entity", "ArticleTag");
    private final static QName _Comment_QNAME = new QName("http://article.nure.ua/entity", "Comment");
    private final static QName _Grade_QNAME = new QName("http://article.nure.ua/entity", "Grade");
    private final static QName _ArticleList_QNAME = new QName("http://article.nure.ua/entity", "articleList");
    private final static QName _Return_QNAME = new QName("http://article.nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.article.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public Article createArticle() {
        return new Article();
    }

    /**
     * Create an instance of {@link ArticleTag }
     * 
     */
    public ArticleTag createArticleTag() {
        return new ArticleTag();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link Grade }
     * 
     */
    public Grade createGrade() {
        return new Grade();
    }

    /**
     * Create an instance of {@link EntityWithId }
     * 
     */
    public EntityWithId createEntityWithId() {
        return new EntityWithId();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Article }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Article }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "Article")
    public JAXBElement<Article> createArticle(Article value) {
        return new JAXBElement<Article>(_Article_QNAME, Article.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleTag }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArticleTag }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "ArticleTag")
    public JAXBElement<ArticleTag> createArticleTag(ArticleTag value) {
        return new JAXBElement<ArticleTag>(_ArticleTag_QNAME, ArticleTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Comment }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "Comment")
    public JAXBElement<Comment> createComment(Comment value) {
        return new JAXBElement<Comment>(_Comment_QNAME, Comment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Grade }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Grade }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "Grade")
    public JAXBElement<Grade> createGrade(Grade value) {
        return new JAXBElement<Grade>(_Grade_QNAME, Grade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Article }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Article }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "articleList")
    public JAXBElement<Article> createArticleList(Article value) {
        return new JAXBElement<Article>(_ArticleList_QNAME, Article.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/entity", name = "return")
    public JAXBElement<Integer> createReturn(Integer value) {
        return new JAXBElement<Integer>(_Return_QNAME, Integer.class, null, value);
    }

}
