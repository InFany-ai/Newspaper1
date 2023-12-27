
package ua.nure.article.server.service;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.article.server.service package. 
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

    private final static QName _DAOException_QNAME = new QName("http://article.nure.ua/server/service", "DAOException");
    private final static QName _AddArticle_QNAME = new QName("http://article.nure.ua/server/service", "addArticle");
    private final static QName _AddArticleResponse_QNAME = new QName("http://article.nure.ua/server/service", "addArticleResponse");
    private final static QName _AddArticleTag_QNAME = new QName("http://article.nure.ua/server/service", "addArticleTag");
    private final static QName _AddArticleTagResponse_QNAME = new QName("http://article.nure.ua/server/service", "addArticleTagResponse");
    private final static QName _AddComment_QNAME = new QName("http://article.nure.ua/server/service", "addComment");
    private final static QName _AddCommentResponse_QNAME = new QName("http://article.nure.ua/server/service", "addCommentResponse");
    private final static QName _AddGrade_QNAME = new QName("http://article.nure.ua/server/service", "addGrade");
    private final static QName _AddGradeResponse_QNAME = new QName("http://article.nure.ua/server/service", "addGradeResponse");
    private final static QName _FindByArticleTag_QNAME = new QName("http://article.nure.ua/server/service", "findByArticleTag");
    private final static QName _FindByArticleTagResponse_QNAME = new QName("http://article.nure.ua/server/service", "findByArticleTagResponse");
    private final static QName _ListArticles_QNAME = new QName("http://article.nure.ua/server/service", "listArticles");
    private final static QName _ListArticlesResponse_QNAME = new QName("http://article.nure.ua/server/service", "listArticlesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.article.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddArticle }
     * 
     */
    public AddArticle createAddArticle() {
        return new AddArticle();
    }

    /**
     * Create an instance of {@link AddArticleResponse }
     * 
     */
    public AddArticleResponse createAddArticleResponse() {
        return new AddArticleResponse();
    }

    /**
     * Create an instance of {@link AddArticleTag }
     * 
     */
    public AddArticleTag createAddArticleTag() {
        return new AddArticleTag();
    }

    /**
     * Create an instance of {@link AddArticleTagResponse }
     * 
     */
    public AddArticleTagResponse createAddArticleTagResponse() {
        return new AddArticleTagResponse();
    }

    /**
     * Create an instance of {@link AddComment }
     * 
     */
    public AddComment createAddComment() {
        return new AddComment();
    }

    /**
     * Create an instance of {@link AddCommentResponse }
     * 
     */
    public AddCommentResponse createAddCommentResponse() {
        return new AddCommentResponse();
    }

    /**
     * Create an instance of {@link AddGrade }
     * 
     */
    public AddGrade createAddGrade() {
        return new AddGrade();
    }

    /**
     * Create an instance of {@link AddGradeResponse }
     * 
     */
    public AddGradeResponse createAddGradeResponse() {
        return new AddGradeResponse();
    }

    /**
     * Create an instance of {@link FindByArticleTag }
     * 
     */
    public FindByArticleTag createFindByArticleTag() {
        return new FindByArticleTag();
    }

    /**
     * Create an instance of {@link FindByArticleTagResponse }
     * 
     */
    public FindByArticleTagResponse createFindByArticleTagResponse() {
        return new FindByArticleTagResponse();
    }

    /**
     * Create an instance of {@link ListArticles }
     * 
     */
    public ListArticles createListArticles() {
        return new ListArticles();
    }

    /**
     * Create an instance of {@link ListArticlesResponse }
     * 
     */
    public ListArticlesResponse createListArticlesResponse() {
        return new ListArticlesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArticle }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addArticle")
    public JAXBElement<AddArticle> createAddArticle(AddArticle value) {
        return new JAXBElement<AddArticle>(_AddArticle_QNAME, AddArticle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArticleResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addArticleResponse")
    public JAXBElement<AddArticleResponse> createAddArticleResponse(AddArticleResponse value) {
        return new JAXBElement<AddArticleResponse>(_AddArticleResponse_QNAME, AddArticleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleTag }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArticleTag }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addArticleTag")
    public JAXBElement<AddArticleTag> createAddArticleTag(AddArticleTag value) {
        return new JAXBElement<AddArticleTag>(_AddArticleTag_QNAME, AddArticleTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddArticleTagResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddArticleTagResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addArticleTagResponse")
    public JAXBElement<AddArticleTagResponse> createAddArticleTagResponse(AddArticleTagResponse value) {
        return new JAXBElement<AddArticleTagResponse>(_AddArticleTagResponse_QNAME, AddArticleTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddComment }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addComment")
    public JAXBElement<AddComment> createAddComment(AddComment value) {
        return new JAXBElement<AddComment>(_AddComment_QNAME, AddComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCommentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addCommentResponse")
    public JAXBElement<AddCommentResponse> createAddCommentResponse(AddCommentResponse value) {
        return new JAXBElement<AddCommentResponse>(_AddCommentResponse_QNAME, AddCommentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGrade }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddGrade }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addGrade")
    public JAXBElement<AddGrade> createAddGrade(AddGrade value) {
        return new JAXBElement<AddGrade>(_AddGrade_QNAME, AddGrade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGradeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddGradeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "addGradeResponse")
    public JAXBElement<AddGradeResponse> createAddGradeResponse(AddGradeResponse value) {
        return new JAXBElement<AddGradeResponse>(_AddGradeResponse_QNAME, AddGradeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByArticleTag }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByArticleTag }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "findByArticleTag")
    public JAXBElement<FindByArticleTag> createFindByArticleTag(FindByArticleTag value) {
        return new JAXBElement<FindByArticleTag>(_FindByArticleTag_QNAME, FindByArticleTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByArticleTagResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByArticleTagResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "findByArticleTagResponse")
    public JAXBElement<FindByArticleTagResponse> createFindByArticleTagResponse(FindByArticleTagResponse value) {
        return new JAXBElement<FindByArticleTagResponse>(_FindByArticleTagResponse_QNAME, FindByArticleTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListArticles }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListArticles }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "listArticles")
    public JAXBElement<ListArticles> createListArticles(ListArticles value) {
        return new JAXBElement<ListArticles>(_ListArticles_QNAME, ListArticles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListArticlesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListArticlesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://article.nure.ua/server/service", name = "listArticlesResponse")
    public JAXBElement<ListArticlesResponse> createListArticlesResponse(ListArticlesResponse value) {
        return new JAXBElement<ListArticlesResponse>(_ListArticlesResponse_QNAME, ListArticlesResponse.class, null, value);
    }

}
